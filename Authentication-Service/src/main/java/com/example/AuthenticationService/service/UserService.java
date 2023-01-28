package com.example.AuthenticationService.service;

import com.example.AuthenticationService.Model.Roles;
import com.example.AuthenticationService.Model.User;
import com.example.AuthenticationService.Repository.RolesRepository;
import com.example.AuthenticationService.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
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

        User user=userRepository.findByEmail(email);
        Roles role=rolesRepository.getRolesByName(roleName);

        user.getUserRoles().add(role);
    }

    public List<String> getUsers() {
        List<User>users=userRepository.findAll();

        return users.stream().map(User::getUsername).collect(Collectors.toList());
    }

    public void deleteUser(int i) {
        //Get user from usertable
        Optional<User> optUser=userRepository.findById(i);
         User user=optUser.get();

        //Take roles of user and find exact role from role repository and remove this user from each roles.
        Set<Roles> roles=user.getUserRoles();


        //If user has multiple role. To delete user completely ,need to delete from each set of roles
      roles.forEach(roles1 -> {
          Roles fromRole=rolesRepository.getRolesByName(roles1.getName());

          fromRole.getUsers().remove(user);

      });
        //No need to call rolerepository.save to commit the changes after removing user from each role.
        //Its perform automatically by calling  userRepo.delete

        userRepository.delete(user);


    }

    public void createAndSaveNewUserWithRole() {

        //saving user from role side

        System.out.println("starts");

        User user= new User();
        user.setEmail("chris@gmail.com");
        user.setUsername("chris");
        user.setPassword("asdasdasd");

        Roles role= rolesRepository.getRolesByName("ROLE_USER");


//         Roles role = new Roles(null,"manager",new HashSet<>());
        role.addUser(user);
//        rolesRepository.save(role);

        user.addRoles(role);

         userRepository.save(user);


    }
}
