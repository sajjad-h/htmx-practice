package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import io.github.wimdeblauwe.htmx.spring.boot.mvc.HxTrigger;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    @Autowired
    private UserRepository userRepository;
    
    @PostMapping("/validateName")
    public String validateUserName(@RequestParam String name) throws InterruptedException {
        Thread.sleep(2000);
        return (name.length() < 3) ? "Invalid input" : "";
    }
    
    @PostMapping("/")
    @HxTrigger("refreshUsersList")
    public String addUser(@ModelAttribute User user) {
        userRepository.save(user);
        return user.toString();
    }
}
