package com.school.test.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.test.dto.LoginRequest;
import com.school.test.dto.MessageResponse;
import com.school.test.dto.SignupRequest;
import com.school.test.dto.UserInfoResponse;
import com.school.test.entity.ERole;
import com.school.test.entity.Role;
import com.school.test.entity.User;
import com.school.test.repository.RoleRepository;
import com.school.test.repository.UserRepository;
import com.school.test.security.JwtUtils;
import com.school.test.security.UserDetailsImpl;
import com.school.test.security.UserDetailsServiceImpl;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
 @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;
  
  @Autowired
  UserDetailsServiceImpl userDetailsService;

  @PostMapping("/signin")
  public UserInfoResponse authenticateUser(@Valid @RequestBody LoginRequest loginRequest, HttpServletResponse response) {
      Authentication authentication = authenticationManager
              .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

      SecurityContextHolder.getContext().setAuthentication(authentication);
      UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

      String accessToken = jwtUtils.generateTokenFromUsername(userDetails.getUsername());
      String refreshToken = jwtUtils.generateRefreshToken(userDetails.getUsername());

      ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);
      response.setHeader(HttpHeaders.SET_COOKIE, jwtCookie.toString());

      return new UserInfoResponse(accessToken, refreshToken);
  }


  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
    }

    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
    }

    // Create new user's account
    User user = new User(signUpRequest.getUsername(),
                         signUpRequest.getEmail(),
                         encoder.encode(signUpRequest.getPassword()));

    Set<String> strRoles = signUpRequest.getRole();
    Set<Role> roles = new HashSet<>();
//    System.out.println(strRoles);
    if (strRoles == null) {
      Role userRole = roleRepository.findByName(ERole.ROLE_USER)
          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);
    } else {
      strRoles.forEach(role -> {
        switch (role) {
        case "admin":
        	
          Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(adminRole);
          
          break;
        case "mod":

          Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(modRole);
          

          break;
        default:
          Role userRole = roleRepository.findByName(ERole.ROLE_USER)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(userRole);
        }
      });
    }

    user.setRoles(roles);
    userRepository.save(user);

    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }
  
  @PostMapping("/refresh-token")
  public ResponseEntity<?> refreshToken(HttpServletRequest request, HttpServletResponse response) {
      try {
          String refreshToken = jwtUtils.getJwtFromCookies(request);
          System.out.println(refreshToken + "oldrefreshtoken");
          
          if (refreshToken != null && jwtUtils.validateJwtToken(refreshToken)) {
              String username = jwtUtils.getUserNameFromJwtToken(refreshToken);
              UserDetailsImpl userDetails = (UserDetailsImpl) userDetailsService.loadUserByUsername(username);
              
              // Generate new tokens
              String newAccessToken = jwtUtils.generateTokenFromUsername(username);
              ResponseCookie newJwtCookie = jwtUtils.generateJwtCookie(userDetails);
              response.setHeader(HttpHeaders.SET_COOKIE, newJwtCookie.toString());
              
              String newRefreshToken = jwtUtils.generateRefreshToken(username);
              ResponseCookie newRefreshTokenCookie = jwtUtils.generateRefreshTokenCookie(newRefreshToken);
              response.addHeader(HttpHeaders.SET_COOKIE, newRefreshTokenCookie.toString());
              
              System.out.println(newAccessToken + newRefreshToken + "");
              
              // Return the new tokens
              return ResponseEntity.ok().body(new UserInfoResponse(newAccessToken, newRefreshToken));
          } else {
              return ResponseEntity.badRequest().body(new MessageResponse("Error: Invalid refresh token"));
          }
      } catch (Exception e) {
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse("Error: Could not process refresh token"));
      }
  }

  @PostMapping("/signout")
  public ResponseEntity<?> logoutUser() {
    ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
        .body(new MessageResponse("You've been signed out!"));
  }
}