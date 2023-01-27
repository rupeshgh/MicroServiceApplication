package com.example.AuthenticationService.Repository;

import com.example.AuthenticationService.Model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RolesRepository extends JpaRepository<Roles,Integer> {

    @Query("select r from Roles r where r.name=:role")
     Roles getRolesByName(@Param("role") String role);

    @Query("select r from Roles r where r.name=:s")
    Roles findByName(@Param("s") String s);
}