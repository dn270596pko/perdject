package com.olegkirillovich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {

    @GetMapping("/orders")
    public String viewOrders(Model model) {
        // Логика для отображения списка заказов
        return "orders";
    }

    // Потом добавлю еще методы
}