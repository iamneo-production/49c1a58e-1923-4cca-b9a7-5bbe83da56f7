package com.examly.springapp.api.controllers;

import com.examly.springapp.api.models.User;
import com.examly.springapp.api.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    
    @Autowired 
    UserService userService;

    @PostMapping("/login")
    public boolean loginUser(@RequestBody User u) {
        if (userService.findUser(u.getId()) != null) {
            
            return true;
        }
        return false;
        // return userService.findUser(u.getId());
    }
}
