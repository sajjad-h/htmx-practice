package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.utils.EmailValidator;

import io.github.wimdeblauwe.htmx.spring.boot.mvc.HxTrigger;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    @Autowired
    private UserRepository userRepository;

    
    @Autowired
    private TemplateEngine templateEngine;

    public List<String> VALID_LOCATIONS = List.of("dhaka", "chittagong");
    
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
    public ResponseEntity<String> editUser(@ModelAttribute User user) {
        List<String> errorsList = new ArrayList<String>();

        if (user.name.length() < 3) {
            errorsList.add("Name length must be greater than 3!");
        }
        if (!EmailValidator.validateEmail((user.email))) {
            errorsList.add("Invalid Email!");
        }
        if (user.age < 18) {
            errorsList.add("Age must be over 18!");
        }
        if (!VALID_LOCATIONS.contains(user.location.toLowerCase())) {
            errorsList.add("Location is not valid!");
        }
        
        if (errorsList.size() > 0) {
            Context context = new Context();
            context.setVariable("errorsList", errorsList);

            // Render the Thymeleaf template with the dynamic data
            String renderedHtml = templateEngine.process("errors", context);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(renderedHtml);
        }
        return ResponseEntity.status(HttpStatus.OK).body(templateEngine.process("backdrop-modal-init", new Context()));
    }
}
