// UserController.java
package com.olegkirillovich.controller;

import com.olegkirillovich.model.User;
import com.olegkirillovich.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public String viewProfile(Model model) {
        User currentUser = userService.getCurrentUser();

        // Логика для отображения профиля пользователя
        model.addAttribute("user", currentUser);

        return "profile";
    }

    // Потом добавлю еще методы
}
