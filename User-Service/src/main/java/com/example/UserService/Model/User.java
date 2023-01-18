package com.example.UserService.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;
import java.util.List;





@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity



public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;
    private String username;

    @Column(unique = true)
    private String email;
    private String password;

    @ManyToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinTable(
            name="user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id")

    )

    private List<Roles> UserRoles=new ArrayList<>();



    public void addRoles(Roles roles){
        UserRoles.add(roles);

    }


}
