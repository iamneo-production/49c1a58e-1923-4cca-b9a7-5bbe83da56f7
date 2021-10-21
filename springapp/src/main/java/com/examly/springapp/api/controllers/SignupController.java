package com.examly.springapp.api.controllers;

import com.examly.springapp.api.models.User;
import com.examly.springapp.api.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupController {
    
    @Autowired 
    UserService userService;

    @PostMapping("/signup")
    public boolean saveUser(@RequestBody User u) {
        
        // add a user obj 
        if(userService.addUser(u) == null) {
            return false;
        }else {
            return true;
        }

    }
}
