package com.e_commerce.e_commerceWebsite.Security;

import okhttp3.Credentials;

public class UserConfig {
	 public static void main(String[] args) {
	        String username = "your_username"; // This should be fetched or initialized appropriately
	        String password = "your_password"; // This should be fetched or initialized appropriately

	        // Check if username and password are not null
	        if (username != null && password != null) {
	            String credential = Credentials.basic(username, password);
	            // Use the credential for your request
	            System.out.println("Credential: " + credential);
	        } else {
	            // Handle the null case
	            throw new IllegalArgumentException("Username or password is null");
	        }
	    }
    
	}
