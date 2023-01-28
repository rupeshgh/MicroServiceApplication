package com.example.AuthenticationService.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class Testcontroller {

    @GetMapping("/ok")
    public String test(){

        return "ok user";
    }
}
