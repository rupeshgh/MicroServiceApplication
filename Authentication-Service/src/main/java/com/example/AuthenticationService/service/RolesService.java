package com.example.AuthenticationService.service;


import com.example.AuthenticationService.Model.Roles;
import com.example.AuthenticationService.Repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RolesService {

    @Autowired
    RolesRepository rolesRepository;

    public void saveRole(Roles role) {
        rolesRepository.save(role);


    }

    public Roles getRole(String s) {

        return rolesRepository.findByName(s);
    }
}

