package com.olegkirillovich.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.olegkirillovich.model.Cart;
import com.olegkirillovich.model.CartItem;
import com.olegkirillovich.model.Product;
import com.olegkirillovich.repository.CartItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.olegkirillovich.model.*;
import com.olegkirillovich.repository.CartRepository;

import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart getCartByUser(User user) {
        return cartRepository.findByUser(user);
    }

    public void addToCart(User user, Product product) {
        Cart cart = getCartByUser(user);
        List<CartItem> items = cart.getCartItems();
        for (CartItem item : items) {
            if (item.getProduct().equals(product)) {
                item.setQuantity(item.getQuantity() + 1);
                cartRepository.save(cart);
                return;
            }
        }
        CartItem newItem = new CartItem();
        newItem.setProduct(product);
        newItem.setQuantity(1);
        newItem.setCart(cart);
        items.add(newItem);
        cartRepository.save(cart);
    }

    public void removeFromCart(User user, Product product) {
        Cart cart = getCartByUser(user);
        List<CartItem> items = cart.getCartItems();
        items.removeIf(item -> item.getProduct().equals(product));
        cartRepository.save(cart);
    }

    public void placeOrder(Cart cart) {
        // Здесь потом будет логика для оформления заказа
        cart.getCartItems().clear();
        cartRepository.save(cart);
    }

    // Другие методы бизнес-логики для работы с корзиной заебашу позже
}
