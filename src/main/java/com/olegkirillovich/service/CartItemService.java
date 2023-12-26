package com.olegkirillovich.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.olegkirillovich.model.CartItem;
import com.olegkirillovich.repository.CartItemRepository;

import java.util.List;

@Service
public class CartItemService {

    private final CartItemRepository cartItemRepository;

    @Autowired
    public CartItemService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    public List<CartItem> getCartItemsByUserId(Long userId) {
        return cartItemRepository.findByUser_Id(userId);
    }

}
