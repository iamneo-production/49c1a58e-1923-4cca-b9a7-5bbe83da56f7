package com.examly.springapp.Controller;

import com.examly.springapp.Model.LoginModel;
import com.examly.springapp.Model.UserModel;
import com.examly.springapp.Service.UserService;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;
    

    @PostMapping("/login")
    public Boolean checkUser(LoginModel data) {
        if (userService.checkUserById(data.getEmail())) {
            if (userService.getUserById(data.getEmail()).getPassword().equals(data.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
