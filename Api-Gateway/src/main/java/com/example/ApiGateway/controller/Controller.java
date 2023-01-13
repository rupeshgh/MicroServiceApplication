package com.example.ApiGateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping ("/")
    public void test(){
        System.out.println("asdasd");
    }
}
