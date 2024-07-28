package com.e_commerce.e_commerceWebsite.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Products")
public class Product {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long Productid;
	 
	 @Column
	 private String Name;
	 
	 @Column
	 private String Description;
	 
	 @Column
	 private Long Price;
	 
	 @Column
	 private Long Quantityavailable;

	public Long getProductid() {
		return Productid;
	}

	public void setProductid(Long productid) {
		Productid = productid;
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

	public Long getQuantityavailable() {
		return Quantityavailable;
	}

	public void setQuantityavailable(Long quantityavailable) {
		Quantityavailable = quantityavailable;
	}

	 
	 
	 
	
}
