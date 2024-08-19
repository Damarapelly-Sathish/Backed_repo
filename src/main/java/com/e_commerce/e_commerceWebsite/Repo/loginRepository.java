package com.e_commerce.e_commerceWebsite.Repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.e_commerce.e_commerceWebsite.Model.User;

@Repository
public interface loginRepository extends JpaRepository<User, Long> {
	@Query(value = "SELECT EXISTS(SELECT 1 FROM users WHERE email = :Email)", nativeQuery = true)
	 int isEmailExist(String Email);
	@Query(value="SELECT id from users where email= :Email",nativeQuery=true)
      String getIdWithEmail(String Email);
	
}
