package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String getHome() {
        return "home";
    }
    
    @GetMapping("/modal")
    public String getModal() {
        return "components/modal";
    }
    
    @GetMapping("/backdrop-modal")
    public String getBackdropModal() {
        return "components/backdrop-modal";
    }
}
