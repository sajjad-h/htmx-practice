package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import io.github.wimdeblauwe.htmx.spring.boot.mvc.HxRequest;

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
    
    @HxRequest
    @GetMapping("/backdrop-modal")
    public String getBackdropModal() {
        return "components/backdrop-modal";
    }
    
    @HxRequest
    @PutMapping("/dummy")
    public  ResponseEntity<String> getDummyResponseEntity() {
        return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
        // return new ResponseEntity<String>("success", HttpStatus.OK);
        // return new ResponseEntity<String>("survice unavailable", HttpStatus.SERVICE_UNAVAILABLE);
    }
    
    // @PutMapping("/dummy")
    // public  String getDummy() {
    //     return "hello";
    // }
}
