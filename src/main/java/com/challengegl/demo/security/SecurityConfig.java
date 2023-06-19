package com.challengegl.demo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/sign-up").permitAll() // permitir solicitudes no autenticadas a /sign-up
                .antMatchers("/api/login").permitAll() // permitir solicitudes no autenticadas a /sign-up
                .antMatchers("/h2-console/**").permitAll() // permitir solicitudes no autenticadas a /h2-console
                .anyRequest().authenticated() // cualquier otra solicitud requiere autenticación
                .and()
                .httpBasic()
                .and()
                .headers().frameOptions().sameOrigin(); // permitir el uso de frames para la misma URL de origen (necesario para H2 console)
    }
}
