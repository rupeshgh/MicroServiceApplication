package com.example.UserService.Controller;


import com.example.UserService.Model.User;

import com.example.UserService.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-service")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> RegisterUser(@RequestBody  User user){

        User savedUser=userService.save(user);

       if (savedUser!=null){
           return new ResponseEntity<>(user.getEmail(),HttpStatus.CREATED);
       }

       else {
           return new ResponseEntity<>(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS);
       }

    }
    @GetMapping("/getAllUser")
    public ResponseEntity<?> getUsers(){
        System.out.println("called");
        List<String> users=userService.getUsers();

        return new ResponseEntity<>(users,HttpStatus.OK);
    }




}
