package com.example.security_demo.convertor;

import com.example.security_demo.config.JwtService;
import com.example.security_demo.dto.UserRequest;
import com.example.security_demo.dto.UserResponse;
import com.example.security_demo.entity.Role;
import com.example.security_demo.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserConverter {

    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public User toUser(UserRequest userRequest) {
        User user = new User();
        user.setEmail(userRequest.getEmail());
        user.setRole(Role.ROLE_USER);
        user.setFirstname(userRequest.getFirstname());
        user.setLastname(userRequest.getLastname());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));

        return user;
    }

    public UserResponse toResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setFirstname(user.getFirstname());
        userResponse.setLastname(user.getLastname());
        userResponse.setEmail(user.getEmail());
        userResponse.setToken(jwtService.generateJwtToken(user));

        return userResponse;
    }

}
