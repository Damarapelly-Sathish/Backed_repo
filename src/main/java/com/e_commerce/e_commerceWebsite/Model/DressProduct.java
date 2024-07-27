package com.e_commerce.e_commerceWebsite.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Lob;
import jakarta.persistence.Column;

@Entity
public class DressProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column
    private String name;
    
    @Column
    private String description;
    @Column
    private Double price;
    
    @Column
    @Lob
    private byte[] image;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

    // Getters and Setters
}
