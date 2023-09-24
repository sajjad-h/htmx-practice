package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

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
        user.id = UUID.randomUUID().toString();
        userRepository.save(user);
        return user.toString();
    }
    
    @PutMapping("/")
    @HxTrigger("refreshUsersList")
    public String editUser(@ModelAttribute User user) {
        System.out.println("hi sajjad " + user.id);
        System.out.println("hi sajjad " + user.name);
        System.out.println("hi sajjad " + user.age);
        System.out.println("hi sajjad " + user.location);
        userRepository.update(user);
        return user.toString();
    }
}
