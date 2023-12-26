package com.olegkirillovich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/profile")
    public String viewProfile(Model model) {
        // Логика для отображения профиля пользователя
        return "profile";
    }

    // Потом добавлю еще методы
}