package com.olegkirillovich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {

    @GetMapping("/cart")
    public String viewCart(Model model) {
        // Логика для отображения содержимого корзины
        return "cart";
    }

    @GetMapping("/cart/checkout")
    public String checkout(Model model) {
        // Логика для оформления заказа
        return "checkout";
    }

    // потом добавлю методі еще
}
