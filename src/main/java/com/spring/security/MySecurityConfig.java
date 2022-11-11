package com.spring.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

/**
 * "@EnableWebSecurity" class that configure Security part of project
 */
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Create login,password in memory
     * @param auth object holding login,password
     * @throws Exception in case wrong input
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        UserBuilder userBuilder = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser(userBuilder
                        .username("ONE")
                        .password("ONE").
                        roles("levelAccessesOne"))
                .withUser(userBuilder
                        .username("TWO")
                        .password("TWO").
                        roles("levelAccessesTwo"))
                .withUser(userBuilder
                        .username("Both")
                        .password("Both").
                        roles("levelAccessesOne","levelAccessesTwo"));
    }
}
