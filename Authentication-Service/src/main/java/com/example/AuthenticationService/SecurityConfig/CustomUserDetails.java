package com.example.AuthenticationService.SecurityConfig;

import com.example.AuthenticationService.Model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;


public class CustomUserDetails implements UserDetails {
    private final User user;

    public CustomUserDetails(User user) {
       this.user=user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<SimpleGrantedAuthority>authorities=new ArrayList<>();

        this.user.getUserRoles().forEach(roles -> {
//            System.out.println(roles.getName());
            authorities.add(new SimpleGrantedAuthority(roles.getName()));
        });
        return authorities;
    }


    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return  this.user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
