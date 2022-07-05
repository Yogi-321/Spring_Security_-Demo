package com.example.JWTDemo.Configuration;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class CustomerUserDetailsService implements UserDetailsService {





    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username.equals("yogesh"))
        {
            return new User("yogesh","yogesh",new ArrayList<>());

        }
        else {
            throw  new UsernameNotFoundException("User Is Not Avialable");
        }
    }
}
