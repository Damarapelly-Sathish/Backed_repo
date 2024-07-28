package com.e_commerce.e_commerceWebsite.Repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.e_commerce.e_commerceWebsite.Model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
	
}
