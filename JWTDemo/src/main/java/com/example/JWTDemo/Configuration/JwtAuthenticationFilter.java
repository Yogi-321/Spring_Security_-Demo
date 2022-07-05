package com.example.JWTDemo.Configuration;

import com.example.JWTDemo.Helper.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomerUserDetailsService customerUserDetailsService;




    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
           String requestHeader= request.getHeader("Authorization");
           String username=null;
           String jwtToken=null;
           //checking format
           if(requestHeader!=null && requestHeader.startsWith("Bearer "))
           {
               jwtToken=requestHeader.substring(7);
               System.out.println(jwtToken);
           }
    }
}
