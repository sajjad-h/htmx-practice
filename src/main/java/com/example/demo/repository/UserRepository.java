package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public class UserRepository {
    private List<User> usersList = new ArrayList<User>() {{
        add(new User(UUID.randomUUID().toString(), "John Doe", "john.doe@gmail.com", 34, "Dhaka", true));
        add(new User(UUID.randomUUID().toString(), "Max Payne", "max.payne@gmail.com", 65, "New York", false));
        add(new User(UUID.randomUUID().toString(), "Uzumaki Naruto", "uzumaki.naruto@gmail.com", 17, "Munich", true));
        add(new User(UUID.randomUUID().toString(), "John Constantine", "john.constantine@gmail.com", 45, "London", false));
    }};

    public List<User> getAllUsers() {
        return usersList;
    }

    public User save(User user) {
        usersList.add(user);
        return user;
    }
    
    public User update(User user) {
        for (int i = 0; i < usersList.size(); i++) {
            if (usersList.get(i).id.equals(user.id)) {
                usersList.set(i, user);
                System.out.print(user.location);
                return user;
            }
        }
        return null;
    }

    public User findById(String id) {
        for (int i = 0; i < usersList.size(); i++) {
            if (usersList.get(i).id.equals(id)) {
                return usersList.get(i);
            }
        }
        return null;
    }
}
