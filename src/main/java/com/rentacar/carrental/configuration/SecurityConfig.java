package com.rentacar.carrental.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/client/new").permitAll()
                .antMatchers("/api/car/show/all").permitAll()
                .antMatchers("/api/rental/**").hasRole("USER")
                .antMatchers("/api/car/**").hasRole("USER")
                .antMatchers("/api/client/**").hasRole("USER")
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }

    @Override
    public void configure(AuthenticationManagerBuilder builder) throws Exception{
        builder.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(
                "select username,password, role from users where username=?")
                .authoritiesByUsernameQuery(
                        "select username, role from user_roles where username=?")
                .passwordEncoder(bCryptPasswordEncoder);
    }
}
