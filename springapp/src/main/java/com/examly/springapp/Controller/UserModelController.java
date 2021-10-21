package com.examly.springapp.Controller;

import com.examly.springapp.Model.UserModel;
import com.examly.springapp.Service.UserService;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class UserModelController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public Boolean saveUser(@RequestBody UserModel user) {
        if (user.isNull()) {
            return false;
        } else if (userService.checkUserById(user.getEmail())) {
            userService.addNewUser(user);
            return true;
        }
        return false;
    }
}
