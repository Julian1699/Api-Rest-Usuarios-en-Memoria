package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET, "/api/**").hasAnyRole("admin","customer")
                .requestMatchers(HttpMethod.PUT, "/api/**").hasRole("admin")
                .requestMatchers(HttpMethod.POST, "/api/**").hasRole("admin")
                .requestMatchers(HttpMethod.DELETE).denyAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();

        return http.build();
    }

    @Bean
    public UserDetailsService memoryUsers(){
        UserDetails admin = User.builder()
                .username("admin")
                .password("$2a$10$T.Fz4aBArk10auC9Q7wPTutB3Nz0nMv8gDcW9hj/aSUuM8HR0uN5G")
                .roles("admin")
                .build();

        UserDetails customer = User.builder()
                .username("customer")
                .password("$2a$10$X3t4v5lpabIuk5BNSChmpOvjvdi7Dl6IaGnGaOh0whg2EwvlipsTW")
                .roles("customer")
                .build();

        return new InMemoryUserDetailsManager(admin,customer);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
