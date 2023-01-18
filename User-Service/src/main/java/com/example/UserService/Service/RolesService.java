package com.example.UserService.Service;

import com.example.UserService.Model.Roles;
import com.example.UserService.Repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RolesService {

    @Autowired
    RolesRepository rolesRepository;

    public void saveRole(Roles role){
        rolesRepository.save(role);


    }

   public Roles getRole(String s){

        return rolesRepository.findByName(s);
    }
}
