package com.example.kycspringjpasecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    BankUserService service;

    AuthenticationManager authenticationManager;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        //httpSecurity.authorizeRequests().anyRequest().authenticated();

        httpSecurity.authorizeRequests().antMatchers("/banker/signup").permitAll();
        httpSecurity.authorizeRequests().antMatchers("/accounts/retrieve","/accounts/created","/accounts/aadhaar","/accounts/min/*","/accounts/perfect/*","/accounts/pancard/*","/accounts/account/*").
                hasAnyAuthority("manager","admin");

        httpSecurity.authorizeRequests().anyRequest().authenticated();

        httpSecurity.csrf().disable();
        httpSecurity.httpBasic();
        httpSecurity.formLogin();

        AuthenticationManagerBuilder builder=httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
        builder.userDetailsService(service);
        authenticationManager=builder.build();
        httpSecurity.authenticationManager(authenticationManager);

        return httpSecurity.build();
    }

}
