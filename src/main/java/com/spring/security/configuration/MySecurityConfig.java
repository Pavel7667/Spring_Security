package com.spring.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

import javax.sql.DataSource;

/**
 * "@EnableWebSecurity" class that configure Security part of project
 */
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * @see MyConfig method "dataSource" create Bean to conect to DB
     */
    @Autowired
    private DataSource dataSource;

    /**
     * Using aggregation to Bean "dataSource" get connection to DB and to Users
     * INFO(name,password,role)
     *
     * @param auth object holding login,password
     * @throws Exception in case wrong input
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
    }

    /**
     * For this URL have access Users with some role
     * And ask login INFO for all roles
     * <p>
     * In case of authorization(have one role) and trying to get access to URL
     * with another role, catch "HTTP Status 403 – Forbidden"
     *
     * @param http URL of user request
     * @throws Exception in case wrong input
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasAnyRole("EMPLOYEE", "HR", "MANAGER")
                .antMatchers("/hr_info").hasRole("HR")
                .antMatchers("/manager_info/**").hasRole("MANAGER")
                .and().formLogin().permitAll();
    }
}
