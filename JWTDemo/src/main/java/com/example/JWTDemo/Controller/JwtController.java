package com.example.JWTDemo.Controller;

import com.example.JWTDemo.Helper.JwtUtil;
import com.example.JWTDemo.Model.JwtRequest;
import com.example.JWTDemo.Model.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private JwtRequest jwtRequest;

    @PostMapping("/token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest)
    {
        System.out.println(jwtRequest);
        this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUserName(),jwtRequest.getPassword()));
        UserDetails userDetails= this.userDetailsService.loadUserByUsername(jwtRequest.getUserName());
           String token= this.jwtUtil.generateToken(userDetails);
        System.out.println("Token "+token);

        return ResponseEntity.ok(new JwtResponse(token));
    }

}
