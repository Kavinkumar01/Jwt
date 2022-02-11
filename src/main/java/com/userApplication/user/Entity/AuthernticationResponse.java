package com.userApplication.user.Entity;



public class AuthernticationResponse {
	private final String jwt;
	
	public AuthernticationResponse(String jwt) {
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}
	
	
}
