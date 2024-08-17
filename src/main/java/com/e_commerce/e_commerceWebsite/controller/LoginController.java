package com.e_commerce.e_commerceWebsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_commerce.e_commerceWebsite.Model.AuthRequest;
import com.e_commerce.e_commerceWebsite.Service.JwtUtil;

@RestController
@RequestMapping("/account")

public class LoginController {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private PasswordEncoder passwordEncoder;

	
	@PostMapping("/login")
	public String createToken(@RequestBody AuthRequest authRequest) throws Exception {
	    try {
	        authenticationManager.authenticate(
	                (Authentication) new UsernamePasswordAuthenticationToken(authRequest.getEmailid(), authRequest.getPassword())
	        );
	    } catch (Exception ex) {
	        throw new Exception("Invalid username or password");
	    }

	    final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getEmailid());
	    return jwtUtil.generateToken(userDetails);
	}

	
	
	
	
}