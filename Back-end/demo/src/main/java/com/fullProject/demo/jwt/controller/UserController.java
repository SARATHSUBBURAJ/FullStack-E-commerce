package com.fullProject.demo.jwt.controller;

import com.fullProject.demo.jwt.entity.User;
import com.fullProject.demo.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registerNewUser")
    public User registerNewUser(@RequestBody User user) {
        return userService.registerNewUser(user);
    }

    @GetMapping("/forAdmin")
    public String forAdmin(){
        return "This URL is only forAdmin";
    }

    @GetMapping("/forUser")
    public String forUser(){
        return "This URL is only forUser";
    }

}
