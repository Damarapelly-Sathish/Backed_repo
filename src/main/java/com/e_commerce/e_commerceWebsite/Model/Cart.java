package com.e_commerce.e_commerceWebsite.Model;

import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Cart {
	 @Id
	    private String userId;

	    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<CartItem> items = new ArrayList<>();

	    // Constructors, Getters, Setters
	    public Cart() {}

	    public Cart(String userId) {
	        this.userId = userId;
	    }

	    public String getUserId() {
	        return userId;
	    }

	    public void setUserId(String userId) {
	        this.userId = userId;
	    }

	    public List<CartItem> getItems() {
	        return items;
	    }

	    public void setItems(List<CartItem> items) {
	        this.items = items;
	    }

	    public void addItem(CartItem item) {
	        this.items.add(item);
	    }

	    public void removeItem(CartItem item) {
	        this.items.remove(item);
	    }
}
