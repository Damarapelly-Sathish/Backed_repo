package com.e_commerce.e_commerceWebsite.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.e_commerce.e_commerceWebsite.Model.Cart;

public interface CartRepository extends JpaRepository<Cart, String> {
	Optional<Cart> findByUserId(String userId);
}
