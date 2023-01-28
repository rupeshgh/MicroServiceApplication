package com.example.AuthenticationService.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


//@ToString
//@RequiredArgsConstructor
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Roles {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    private String name;

    @ManyToMany(mappedBy = "UserRoles",fetch = FetchType.EAGER)

    private Set<User> users=new HashSet<>();

    public Roles(String ok_role) {
        this.name=ok_role;
    }

    public void addUser(User user){
    this.users.add(user);

}


}
