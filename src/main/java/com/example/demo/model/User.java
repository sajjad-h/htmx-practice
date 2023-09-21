package com.example.demo.model;

import java.util.UUID;

public class User {
    public String id = UUID.randomUUID().toString();
    public String name;
    public int age;
    public String location;

    public User(String name, int age, String location) {
        this.name = name;
        this.age = age;
        this.location = location;
    }
}
