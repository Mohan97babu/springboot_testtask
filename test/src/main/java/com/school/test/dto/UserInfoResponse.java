package com.school.test.dto;

import java.util.List;

public class UserInfoResponse {
//	private Long id;
//	private String username;
//	private String email;
//	private List<String> roles;
	private String accessToken;
	private String refreshtoken;

	public String getRefreshtoken() {
		return refreshtoken;
	}

	public void setRefreshtoken(String refreshtoken) {
		this.refreshtoken = refreshtoken;
	}

	public UserInfoResponse(String accesstoken,String refreshtoken) {
//		this.id = id;
//		this.username = username;
//		this.email = email;
//		this.roles = roles;
		this.accessToken =accesstoken;
		this.refreshtoken=refreshtoken;
		
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public List<String> getRoles() {
//		return roles;
//	}
}