package com.example.user_ms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/info")
    public String getUserInfo() {
        return "User Information";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") Long id) {
        // Dummy User Data
        return "User with ID: " + id;
    }
}