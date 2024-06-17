package com.example.security_demo.service;

import com.example.security_demo.dto.UserRequest;
import com.example.security_demo.dto.UserResponse;

public interface UserService {
    UserResponse registerUser(UserRequest userRequest);
}
