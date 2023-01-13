package com.example.UserService.Controller;

import com.example.UserService.Model.Roles;
import com.example.UserService.Repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RolesController {
    @Autowired
    RolesRepository rolesRepository;
    @PostMapping("/addRoles")
    public void saveRoles(@RequestBody Roles roles){

        rolesRepository.save(roles);


    }
}
