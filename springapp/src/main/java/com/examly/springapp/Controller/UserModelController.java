package com.examly.springapp.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserModelController {
    @RequestMapping("/hello")
    public String greet() {
        return "Good Day";
    }
   
    
}