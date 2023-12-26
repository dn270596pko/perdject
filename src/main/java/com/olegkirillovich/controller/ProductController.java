package com.olegkirillovich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @GetMapping("/products")
    public String viewProducts(Model model) {
        // Логика для отображения списка продуктов
        return "products";
    }

    // Потом добавлю еще методы
}