package com.example.UserService.Service;

import com.example.UserService.Model.Roles;
import com.example.UserService.Model.User;
import com.example.UserService.Repository.RolesRepository;
import com.example.UserService.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    @Autowired
    RolesRepository rolesRepository;


    public User save(User user) {
        System.out.println(user.getUserRoles());
        return userRepository.save(user);


    }

    public void addRoleToUser(String email, String roleName) {

        User user=userRepository.getUserByEmail(email);
        Roles role=rolesRepository.getRolesByName(roleName);

        user.getUserRoles().add(role);
    }

    public List<String> getUsers() {
        List<User>users=userRepository.findAll();

        return users.stream().map(user -> user.getUsername()).collect(Collectors.toList());
    }
}
