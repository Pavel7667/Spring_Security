package com.spring.security.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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
     *
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
                        roles("MANAGER", "HR"));
    }

    /**
     * For this URL have access Users with some role
     * And ask login INFO for all roles
     *
     * In case of authorization(have one role) and trying to get access to URL
     * with another role, catch "HTTP Status 403 – Forbidden"
     *
     * @param http URL of user request
     * @throws Exception in case wrong input
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasAnyRole("employee", "HR", "MANAGER")
                .antMatchers("/hr_info").hasRole("HR")
                .antMatchers("/manager_info/**").hasRole("MANAGER")
                .and().formLogin().permitAll();
    }
}
