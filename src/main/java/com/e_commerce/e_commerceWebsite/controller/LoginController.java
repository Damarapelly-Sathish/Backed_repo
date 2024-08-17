package com.e_commerce.e_commerceWebsite.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_commerce.e_commerceWebsite.Model.Product;
import com.e_commerce.e_commerceWebsite.Model.User;
import com.e_commerce.e_commerceWebsite.Service.LoginService;

@RestController
@RequestMapping("/account")

public class LoginController {
	
	@Autowired
	private LoginService LoginService;


	
	@PostMapping("/SignUp")
	public String createToken(@RequestBody User userData) throws Exception {
		String Email=userData.getEmail();
		int validation=LoginService.isEmailExist(Email);
	    try {
	    	if(validation!=1)
	            LoginService.addCred(userData);
	    } catch (Exception ex) {
	        throw new Exception("Already existed with this Email");
	    }
        return "Account is successfully created";
	}

	
}