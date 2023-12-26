// OrderController.java
package com.olegkirillovich.controller;

import com.olegkirillovich.model.CartItem;
import com.olegkirillovich.service.CartItemService;
import com.olegkirillovich.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class OrderController {

    private final UserService userService;
    private final CartItemService cartItemService;

    @Autowired
    public OrderController(UserService userService, CartItemService cartItemService) {
        this.userService = userService;
        this.cartItemService = cartItemService;
    }

    @GetMapping("/orders")
    public String viewOrders(Model model) {
        List<CartItem> cartItems = cartItemService.getCartItemsByUserId(userService.getCurrentUser().getId());
        double totalAmount = cartItemService.calculateTotalAmount(cartItems);

        // Логика для отображения списка заказов
        // Можно использовать полученные данные (cartItems и totalAmount)

        return "orders";
    }

    // Потом добавлю еще методы
}
