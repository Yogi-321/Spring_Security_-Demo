package com.example.JWTDemo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


    @GetMapping("/welcome")
    public String getWelcomeMsg()
    {
        return "Welcome to Home Controller";
    }

}
