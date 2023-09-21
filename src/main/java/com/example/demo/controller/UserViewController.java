package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.UserRepository;

import io.github.wimdeblauwe.htmx.spring.boot.mvc.HxRequest;

@Controller
@RequestMapping("/views/users")
public class UserViewController {

    @Autowired
    private UserRepository userRepository;

    @HxRequest
    @GetMapping("/createUserForm")
    public String createUserForm() {
        return "components/users/createUserForm";
    }

    @HxRequest
    @GetMapping("/usersList")
    public String getUsersList(Model model) {
        model.addAttribute("usersList", userRepository.getAllUsers());
        return "components/users/usersList";
    }

    @HxRequest
    @GetMapping("/byId/{userId}")
    public String getUser(@PathVariable("userId") String id, Model model) {
        System.out.println(id);
        model.addAttribute("user", userRepository.findById(id));
        return "components/users/userDetails";
    }

}
