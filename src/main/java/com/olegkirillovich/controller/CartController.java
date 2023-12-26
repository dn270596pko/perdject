// CartController.java
package com.olegkirillovich.controller;

import com.olegkirillovich.model.CartItem;
import com.olegkirillovich.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {

    private List<CartItem> cartItems = new ArrayList<>();

    @GetMapping("/cart")
    public String viewCart(Model model) {
        model.addAttribute("cartItems", cartItems);
        return "cart";
    }

    @GetMapping("/cart/checkout")
    public String checkout(Model model) {
        model.addAttribute("cartItems", cartItems);
        return "checkout";
    }

    @PostMapping("/cart/add")
    public String addToCart(@RequestParam Long productId, @RequestParam int quantity, Model model) {
        // Просто для примера
        Product product = getProductById(productId);
        if (product != null) {
            CartItem cartItem = new CartItem(product, quantity, product.getPrice() * quantity);
            cartItems.add(cartItem);
        }
        model.addAttribute("cartItems", cartItems);
        return "redirect:/cart";
    }

    @GetMapping("/cart/remove")
    public String removeFromCart(@RequestParam Long productId, Model model) {
        // Просто для примера
        cartItems.removeIf(cartItem -> cartItem.getProduct().getId().equals(productId));
        model.addAttribute("cartItems", cartItems);
        return "redirect:/cart";
    }

    // Заглушка для получения продукта по идентификатору
    private Product getProductById(Long productId) {
        // запрос в БД - возвращаю заглушку
        return new Product(productId, "Product " + productId, 10.0);
    }
}
