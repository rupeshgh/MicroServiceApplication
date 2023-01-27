package com.example.AuthenticationService.Controller;


import com.example.AuthenticationService.Jwt.JwtUtil;
import com.example.AuthenticationService.SecurityConfig.CustomUserDetails;
import com.example.AuthenticationService.payload.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    CustomUserDetails customUserDetails;

    @PostMapping("/authenticate")
    public void authenticateUser(@RequestBody  LoginRequest loginRequest){

        String email=loginRequest.getEmail();
        String password=loginRequest.getPassword();


            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(email, password);
            Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

            CustomUserDetails customUserDetails= (CustomUserDetails) authentication.getPrincipal();

            String JwtToken= jwtUtil.generateToken(customUserDetails);




    }

}
