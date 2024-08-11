package com.e_commerce.e_commerceWebsite.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.e_commerce.e_commerceWebsite.Model.Cart;
import com.e_commerce.e_commerceWebsite.Model.CartItem;
import com.e_commerce.e_commerceWebsite.Service.CartService;

@CrossOrigin
@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
    private CartService cartService;

    @GetMapping("/{userId}")
    public ResponseEntity<Cart> getCart(@PathVariable String userId) {
        return ResponseEntity.ok(cartService.getCart(userId));
    }

    @PostMapping("/{userId}/add")
    public ResponseEntity<Cart> addItemToCart(@PathVariable String userId, @RequestBody CartItem item) {
        return ResponseEntity.ok(cartService.addItemToCart(userId, item));
    }

    @PostMapping("/{userId}/update")
    public ResponseEntity<Cart> updateItemQuantity(@PathVariable String userId, @RequestParam int productId, @RequestParam int quantity) {
        return ResponseEntity.ok(cartService.updateItemQuantity(userId, productId, quantity));
    }

    @PostMapping("/{userId}/remove")
    public ResponseEntity<Cart> removeItemFromCart(@PathVariable String userId, @RequestParam int productId) {
        return ResponseEntity.ok(cartService.removeItemFromCart(userId, productId));
    }
	
}
