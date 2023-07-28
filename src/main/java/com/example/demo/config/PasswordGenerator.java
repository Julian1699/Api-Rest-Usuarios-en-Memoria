package com.example.demo.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "admin";
        String rawPassword2 = "customer";
        String encodedPassword = encoder.encode(rawPassword);
        String encodedPassword2 = encoder.encode(rawPassword2);
        System.out.println(encodedPassword);
        System.out.println(encodedPassword2);
    }
}
