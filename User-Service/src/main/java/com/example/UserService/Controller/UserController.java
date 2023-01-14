package com.example.UserService.Controller;


import com.example.UserService.Model.User;

import com.example.UserService.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/userservice/register")
    public ResponseEntity<?> RegisterUser(@RequestBody  User user){

        User savedUser=userService.save(user);

       if (savedUser!=null){
           return new ResponseEntity<>(user.getEmail(),HttpStatus.CREATED);
       }

       else {
           return new ResponseEntity<>(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS);
       }

    }
    @GetMapping("/userservice/getAllUser")
    public ResponseEntity<?> getUsers(){

        List<String> users=userService.getUsers();

        return new ResponseEntity<>(users,HttpStatus.OK);
    }




}
