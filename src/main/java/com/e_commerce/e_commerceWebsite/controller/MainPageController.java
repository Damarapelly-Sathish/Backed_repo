package com.e_commerce.e_commerceWebsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_commerce.e_commerceWebsite.Model.Product;
import com.e_commerce.e_commerceWebsite.Service.ProductService;

@RestController
@RequestMapping("/home")
public class MainPageController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/")
	public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
	
	@PostMapping("/addProduct")  
	public ResponseEntity<Product> AddProduct(@RequestBody Product product) {
		Product savedProduct = productService.addProduct(product);
		return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
	}
	
	
	
}


