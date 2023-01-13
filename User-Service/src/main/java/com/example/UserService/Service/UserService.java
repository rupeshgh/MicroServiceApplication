package com.example.UserService.Service;

import com.example.UserService.Model.Roles;
import com.example.UserService.Model.User;
import com.example.UserService.Repository.RolesRepository;
import com.example.UserService.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    @Autowired
    RolesRepository rolesRepository;


    public User save(User user) {
        return userRepository.save(user);


    }

    public void addRoleToUser(String email, String roleName) {

        User user=userRepository.getUserByEmail(email);
        Roles role=rolesRepository.getRolesByName(roleName);

        user.getUserRoles().add(role);
    }
}
