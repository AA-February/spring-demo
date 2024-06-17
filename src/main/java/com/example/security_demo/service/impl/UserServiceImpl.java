package com.example.security_demo.service.impl;

import com.example.security_demo.convertor.UserConverter;
import com.example.security_demo.dto.UserRequest;
import com.example.security_demo.dto.UserResponse;
import com.example.security_demo.entity.User;
import com.example.security_demo.repository.UserRepository;
import com.example.security_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserConverter userConverter;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserConverter userConverter,
                           UserRepository userRepository) {
        this.userConverter = userConverter;
        this.userRepository = userRepository;
    }


    @Override
    public UserResponse registerUser(UserRequest userRequest) {
        User user = userConverter.toUser(userRequest);
        User savedUser = userRepository.save(user);

        return userConverter.toResponse(savedUser);
    }
}
