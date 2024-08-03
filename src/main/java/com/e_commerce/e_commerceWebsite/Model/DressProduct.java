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
    private Long Productid;
    
    @Column
    private String name;
    
    @Column
    private String description;
    @Column
    private Double price;
    
    @Column
    private String image;
    
    @Column
    private Double discount;
    
    @Column
    private int rating;
   
    @Column
    private int review;
    
    @Column
    private String gender;
    
    @Column
    private String category;
    
	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public int getRating() {
		return rating;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getReview() {
		return review;
	}

	public void setReview(int review) {
		this.review = review;
	}

	public Long getProductid() {
		return Productid;
	}

	public void setProductid(Long productid) {
		Productid = productid;
	}

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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

    // Getters and Setters
}
