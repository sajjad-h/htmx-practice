package com.example.demo.model;

public class User {
    public String id;
    public String name;
    public String email;
    public int age;
    public String location;
    public Boolean starred;

    public User(String id, String name, String email, int age, String location, Boolean starred) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.location = location;
        this.starred = starred;
    }
}
