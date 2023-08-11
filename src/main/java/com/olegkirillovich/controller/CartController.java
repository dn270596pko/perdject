package com.olegkirillovich.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.olegkirillovich.model.Cart;
import com.olegkirillovich.model.Product;
import com.olegkirillovich.service.CartService;
import com.olegkirillovich.service.ProductService;
import com.olegkirillovich.service.UserService;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;
    private final ProductService productService;
    private final UserService userService;

    @Autowired
    public CartController(CartService cartService, ProductService productService, UserService userService) {
        this.cartService = cartService;
        this.productService = productService;
        this.userService = userService;
    }

    @GetMapping("/view")
    public String viewCart(Model model) {
        Cart cart = cartService.getCartByUser(userService.getCurrentUser());
        model.addAttribute("cart", cart);
        return "cart/view";
    }

    @PostMapping("/add/{productId}")
    public String addToCart(@PathVariable Long productId) {
        Product product = productService.getProductById(productId);
        cartService.addToCart(userService.getCurrentUser(), product);
        return "redirect:/cart/view";
    }

    @PostMapping("/remove/{productId}")
    public String removeFromCart(@PathVariable Long productId) {
        Product product = productService.getProductById(productId);
        cartService.removeFromCart(userService.getCurrentUser(), product);
        return "redirect:/cart/view";
    }

    @GetMapping("/checkout")
    public String checkoutCart(Model model) {
        Cart cart = cartService.getCartByUser(userService.getCurrentUser());
        model.addAttribute("cart", cart);
        return "cart/checkout";
    }

    @PostMapping("/placeOrder")
    public String placeOrder() {
        Cart cart = cartService.getCartByUser(userService.getCurrentUser());
        cartService.placeOrder(cart);
        return "redirect:/cart/view";
    }
}