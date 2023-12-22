package com.olegkirillovich.service;

import com.olegkirillovich.model.Cart;
import com.olegkirillovich.model.CartItem;
import com.olegkirillovich.repository.CartItemRepository;
import com.olegkirillovich.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.olegkirillovich.model.CartItem;
import com.olegkirillovich.model.Cart;


import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    @Autowired
    public CartService(CartRepository cartRepository, CartItemRepository cartItemRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    public Cart getCartById(Long cartId) {
        return cartRepository.findById(cartId).orElse(null);
    }

    public Cart createCart() {
        Cart cart = new Cart();
        return cartRepository.save(cart);
    }

    public void addToCart(Cart cart, CartItem cartItem) {
        cartItem.setCart(cart);
        cartItemRepository.save(cartItem);
    }

    public void removeFromCart(Cart cart, CartItem cartItem) {
        List<CartItem> cartItems = cart.getCartItems();
        cartItems.remove(cartItem);
        cartItemRepository.delete(cartItem);
        cartRepository.save((Cart) cart);
    }

    public List<CartItem> getCartItems(Cart cart) {
        return cart.getCartItems();
    }

    public void clearCart(Cart cart) {
        cart.getCartItems().clear();
        cartRepository.save((Cart) cart);
    }
}
