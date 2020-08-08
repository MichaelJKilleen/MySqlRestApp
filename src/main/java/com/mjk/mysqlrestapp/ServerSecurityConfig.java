package com.mjk.mysqlrestapp;

import com.mjk.mysqlrestapp.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/*
Owner: EMAILADDRESS=nomadmike@yahoo.com, CN=bottomfeedersoftware, OU=mjk, O=Bottom Feeder So
ftware, L=Glen Allen, ST=VA, C=US
Issuer: EMAILADDRESS=nomadmike@yahoo.com, CN=mkilleen, OU=mjk, O=Bottom Feeder S
oftware, L=Glen Allen, ST=VA, C=US

 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class ServerSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated().and()
                .x509()
                .subjectPrincipalRegex("CN=(.*?)(?:,|$)")
                .userDetailsService(userDetailsService());
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return (UserDetailsService) username -> {
            if (username.equals("bottomfeedersoftware")) {
                return new User(username, "",
                        AuthorityUtils
                                .commaSeparatedStringToAuthorityList("ROLE_ADMIN,ROLE_USER"));
            }
            else if (username.equals("toptiersoftware")) {
                return new User(username, "",
                        AuthorityUtils
                                .commaSeparatedStringToAuthorityList("ROLE_USER"));
            }
            else {
                throw new UsernameNotFoundException(String.format("User %s not found", username));
            }
        };
    }
}