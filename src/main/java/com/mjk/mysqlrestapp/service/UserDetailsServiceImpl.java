package com.mjk.mysqlrestapp.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username.equals("test")) {
            return User.withDefaultPasswordEncoder()
                    .username("test")
                    .password("test")
                    .roles("test")
                    .build();
        } else {
            return null;
        }
    }
}
