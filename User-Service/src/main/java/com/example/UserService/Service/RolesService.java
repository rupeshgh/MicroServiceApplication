package com.example.UserService.Service;

import com.example.UserService.Controller.RolesController;
import com.example.UserService.Model.Roles;
import com.example.UserService.Repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesService {

    @Autowired
    RolesRepository rolesRepository;

    public void saveRole(Roles role){
        rolesRepository.save(role);


    }
}
