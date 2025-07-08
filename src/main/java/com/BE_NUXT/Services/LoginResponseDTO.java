package com.BE_NUXT.Services;

public class LoginResponseDTO {
	
	    private String token;
	    private String error;

	    // Constructeur succès
	    public LoginResponseDTO(String token) {
	        this.token = token;
	    }

	    // Constructeur erreur
	    public LoginResponseDTO(String token, String error) {
	        this.token = token;
	        this.error = error;
	    }

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

		public String getError() {
			return error;
		}

		public void setError(String error) {
			this.error = error;
		}

	
}
