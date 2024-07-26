package com.e_commerce.e_commerceWebsite.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long ProductId;
	 
	 @Column
	 private String Name;
	 
	 @Column
	 private String Description;
	 
	 @Column
	 private Long Price;
	 
	 @Column
	 private Long QuantityAvailable;

	public Long getProductId() {
		return ProductId;
	}

	public void setProductId(Long productId) {
		ProductId = productId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Long getPrice() {
		return Price;
	}

	public void setPrice(Long price) {
		Price = price;
	}

	public Long getQuantityAvailable() {
		return QuantityAvailable;
	}

	public void setQuantityAvailable(Long quantityAvailable) {
		QuantityAvailable = quantityAvailable;
	}
	 
	 
	
}
