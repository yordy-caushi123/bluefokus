package com.example.solucion.models;

public class AuthResponse {
    private String token;

    public AuthResponse(String token) {
        this.token = token;
    }

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

    
}
