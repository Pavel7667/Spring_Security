package com.spring.security.configuration;

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
                        .username("John1")
                        .password("John1").
                        roles("employee"))
                .withUser(userBuilder
                        .username("Kate2")
                        .password("Kate2").
                        roles("HR"))
                .withUser(userBuilder
                        .username("Jack4")
                        .password("Jac4").
                        roles("employee","HR"));
    }
}
