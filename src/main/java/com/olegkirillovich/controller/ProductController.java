// ProductController.java
package com.olegkirillovich.controller;

import com.olegkirillovich.model.Product;
import com.olegkirillovich.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String viewProducts(Model model) {
        List<Product> products = productService.getAllProducts();

        // Логика для отображения списка продуктов
        model.addAttribute("products", products);

        return "products";
    }

    // Потом добавлю еще методы
}
