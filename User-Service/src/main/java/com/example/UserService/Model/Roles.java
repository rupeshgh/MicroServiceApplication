package com.example.UserService.Model;

import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;
import java.util.List;



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

    @ManyToMany(mappedBy = "UserRoles",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @ToString.Exclude

    private List<User> users=new ArrayList<>();

    public Roles(String ok_role) {
        this.name=ok_role;
    }

    public void addUser(User user){
    this.users.add(user);

}


}
