package com.example.OrderService.Jwt;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class JwtAuthFilter extends OncePerRequestFilter {
    @Autowired
    JwtUtil jwtUtil;



    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String tokenHeader= request.getHeader("Authorization");
        System.out.println("Do jwtfilter");
        String jwttoken=null;
        String username=null;
        if(tokenHeader!=null && tokenHeader.startsWith("Bearer ")) {
            jwttoken = tokenHeader.substring(7);

            try {
                username = this.jwtUtil.extractUsername(jwttoken);
                System.out.println("order:"+username);
                String roles=this.jwtUtil.extractIssuer(jwttoken);
                System.out.println("Rolse:"+roles);

                List<GrantedAuthority> simpleGrantedAuthorities= new ArrayList<>();
                String[] role=roles.split(" ");

                for(String r: role){
                    simpleGrantedAuthorities.add(new SimpleGrantedAuthority(r));

                }

                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, null, simpleGrantedAuthorities);

                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }


            }catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }

        filterChain.doFilter(request,response);

    }
}
