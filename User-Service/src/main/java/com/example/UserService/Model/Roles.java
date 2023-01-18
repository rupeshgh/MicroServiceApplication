package com.example.UserService.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Transactional
public class Roles {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)


    private Integer id;


    private String name;

//
@JsonIgnore
    @ManyToMany(mappedBy = "UserRoles")

    private List<User> users=new ArrayList<>();



}
