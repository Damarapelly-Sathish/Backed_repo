package com.e_commerce.e_commerceWebsite.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_commerce.e_commerceWebsite.Model.Cart;
import com.e_commerce.e_commerceWebsite.Model.CartItem;
import com.e_commerce.e_commerceWebsite.Repo.CartRepository;

@Service
public class CartService {
	@Autowired
    private CartRepository cartRepository;

    public Cart getCart(String userId) {
        return cartRepository.findByUserId(userId).orElse(new Cart(userId));
    }

    public Cart addItemToCart(String userId, CartItem item) {
        Cart cart = getCart(userId);
        Optional<CartItem> existingItem = cart.getItems().stream()
                .filter(i -> i.getProductId().equals(item.getProductId()))
                .findFirst();

        if (existingItem.isPresent()) {
            existingItem.get().setQuantity(existingItem.get().getQuantity() + item.getQuantity());
        } else {
            cart.addItem(item);
        }

        return cartRepository.save(cart);
    }

    public Cart updateItemQuantity(String userId, String productId, int quantity) {
        Cart cart = getCart(userId);
        Optional<CartItem> existingItem = cart.getItems().stream()
                .filter(i -> i.getProductId().equals(productId))
                .findFirst();

        existingItem.ifPresent(cartItem -> cartItem.setQuantity(quantity));
        return cartRepository.save(cart);
    }

    public Cart removeItemFromCart(String userId, String productId) {
        Cart cart = getCart(userId);
        cart.getItems().removeIf(item -> item.getProductId().equals(productId));
        return cartRepository.save(cart);
    }

}
