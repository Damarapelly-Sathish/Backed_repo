package com.e_commerce.e_commerceWebsite.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_commerce.e_commerceWebsite.Model.Product;
import com.e_commerce.e_commerceWebsite.Model.User;
import com.e_commerce.e_commerceWebsite.Service.LoginService;

@CrossOrigin
@RestController
@RequestMapping("/account")

public class LoginController {
	
	@Autowired
	private LoginService LoginService;

	
	@PostMapping("/SignUp")
	public String Userdata(@RequestBody User userData) throws Exception {
	    try {
	    	String Email=userData.getEmail();
	    	int validation=LoginService.isEmailExist(Email);
	    	if(validation!=1)
	            LoginService.addCred(userData);
	    	else
	    		return "Already existed with this Email";
	    } catch (Exception ex) {
	        throw new Exception("Already existed with this Email");
	    }
        return "Account is successfully created";
	}
	@PostMapping("/Login")
	public String loginData(@RequestBody User userData) throws Exception {
		String id;
	    try {
	    	String Email=userData.getEmail();
		   int validation=LoginService.isEmailExist(Email);
	    	if(validation!=0)
	           id=LoginService.getId(Email);
	    	else
	    		return "User does not exist with this mail";
	    } catch (Exception ex) {
	        throw new Exception("User does not exist with this maill");
	    }
        return id;
	}

	
}