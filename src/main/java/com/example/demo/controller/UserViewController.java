package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.User;

@Controller
@RequestMapping("/views/users")
public class UserViewController {

    @GetMapping("/createUserForm")
    public String createUserForm() {
        return "components/users/createUserForm";
    }

    @GetMapping("/usersList")
    public String getUsersList(Model model) {
        ArrayList<User> usersList = new ArrayList<User>() {{
            add(new User("John Doe", 34, "Dhaka"));
            add(new User("Max Payne", 65, "New York"));
            add(new User("Uzumaki Naruto", 17, "Munich"));
            add(new User("John Constantine", 45, "London"));
        }};
        
        model.addAttribute("usersList", usersList);
        return "components/users/usersList";
    }

}
