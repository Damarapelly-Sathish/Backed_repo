package com.e_commerce.e_commerceWebsite.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.e_commerce.e_commerceWebsite.Model.User;
import com.e_commerce.e_commerceWebsite.Repo.loginRepository;

@Service
public class LoginService {
	
	@Autowired
    private loginRepository loginRepository;

    public void addCred(User userData) {
    	loginRepository.save(userData);
    }
    public int isEmailExist(String Email) {
		return loginRepository.isEmailExist(Email);
	}  
    
}
