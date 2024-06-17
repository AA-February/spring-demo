package com.example.security_demo.dto;

import lombok.Data;

@Data
public class UserResponse {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String token;
}
