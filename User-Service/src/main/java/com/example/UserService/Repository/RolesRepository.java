package com.example.UserService.Repository;

import com.example.UserService.Model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RolesRepository extends JpaRepository<Roles,Integer> {

    @Query("select r from Roles r where r.name=:role")
     Roles getRolesByName(@Param("role") String role);
}