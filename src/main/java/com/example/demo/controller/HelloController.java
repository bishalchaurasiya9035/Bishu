package com.example.demo.controller;

import com.example.demo.model.Users;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    private List<Users> users = new ArrayList<>();

    @GetMapping("/hello")
    public String SayHello(){
        return "Hello, Spring Boot";
    }

    @PostMapping("/user")
    public String createUser(@RequestBody Users user){
        users.add(user);
        return "User added: " + user.getName();
    }

    @PostMapping("/users")
    public String createMultipleUsers(@RequestBody List<Users> usersList) {
        users.addAll(usersList);
        return usersList.size() + " users added successfully!!";
    }

    @GetMapping("/alluserslist")
    public List<Users> getUsersList(){
    return users;
    }

}