package com.example.security_demo.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}
