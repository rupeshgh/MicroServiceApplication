package com.example.AuthenticationService.Controller;


import com.example.AuthenticationService.Jwt.JwtUtil;
import com.example.AuthenticationService.SecurityConfig.CustomUserDetails;
import com.example.AuthenticationService.SecurityConfig.CustomUserDetailsService;
import com.example.AuthenticationService.payload.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth-service")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    CustomUserDetailsService customUserDetailsService;
    @Autowired
    JwtUtil jwtUtil;



    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticateUser(@RequestBody  LoginRequest loginRequest){

        String email=loginRequest.getEmail();
        String password=loginRequest.getPassword();
        System.out.println(email +"" +password);

            try {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(email, password);
                Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);


                CustomUserDetails customUserDetails= (CustomUserDetails) customUserDetailsService.loadUserByUsername(email);


                String JwtToken = jwtUtil.generateToken(customUserDetails);


                return new ResponseEntity<>(JwtToken, HttpStatus.OK);


            }catch (Exception exception){


                return new ResponseEntity<>(exception.getMessage(), HttpStatusCode.valueOf(401));
            }


    }

}
