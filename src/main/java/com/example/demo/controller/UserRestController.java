package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    
    @PostMapping("/validateName")
    public String validateUserName(@RequestParam String name) {
        System.out.println(name);
        return (name.length() < 3) ? "Invalid input" : "";
    }
}
