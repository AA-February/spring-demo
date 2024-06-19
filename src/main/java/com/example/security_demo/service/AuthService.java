package com.example.security_demo.service;

import com.example.security_demo.dto.AuthRequest;

public interface AuthService {

    String authenticate(AuthRequest authRequest);
}
