package com.e_commerce.e_commerceWebsite.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_commerce.e_commerceWebsite.Model.Product;
import com.e_commerce.e_commerceWebsite.Repo.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
    private ProductRepo productRepository;
	
	public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
