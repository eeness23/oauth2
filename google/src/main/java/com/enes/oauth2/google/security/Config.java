package com.enes.oauth2.google.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class Config extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthSuccessHandler authSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/home").hasRole("USER")
                .antMatchers("/**").permitAll()
                .and()
                .oauth2Login().loginPage("/login").successHandler(authSuccessHandler);

    }
}
