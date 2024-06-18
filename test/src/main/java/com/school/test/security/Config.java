////package com.school.test.security;
////
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.ComponentScan;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
////import org.springframework.security.core.userdetails.User;  
////import org.springframework.security.config.annotation.web.configuration.*; 
////import org.springframework.security.core.userdetails.UserDetailsService;
////import org.springframework.security.provisioning.InMemoryUserDetailsManager;
////import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
////
////
////@EnableWebSecurity 
////@ComponentScan 
////public class Config extends WebSecurityConfiguration implements WebMvcConfigurer  { 
////	
//////	 @SuppressWarnings("deprecation")
////	@Bean 
////	    public UserDetailsService userDetailsService() throws Exception {  
////	        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();  
////	        manager.createUser(User.withDefaultPasswordEncoder().username("javatpoint").  
////	        password("java123").roles("USER").build());  
////	        return manager;  
////	    }  
////	      
////	    protected void configure(HttpSecurity http) throws Exception {  
////	        http.securityMatcher("/").authorizeHttpRequests(null).httpBasic();
////	    }  
////	    
////}
//package com.school.test.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.context.SecurityContextHolder;
////import org.springframework.security.core.context.SecurityContextHolder;
////import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.config.http.SecurityFilterChain;
//@EnableWebSecurity
//public class Config {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        return SecurityContextHolder.createExpressionUnsafeFilterChain(http ->
//                http
//                        .authorizeRequests()
//                        .anyRequest().authenticated()
//                        .and()
//                        .httpBasic());
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() throws Exception {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withDefaultPasswordEncoder().username("javatpoint")
//                .password("java123").roles("USER").build());
//        return manager;
//    }
//}
