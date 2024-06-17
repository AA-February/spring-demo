package com.example.security_demo.controller;

import com.example.security_demo.dto.UserRequest;
import com.example.security_demo.dto.UserResponse;
import com.example.security_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/register")
    ResponseEntity<UserResponse> register(@RequestBody UserRequest request) {
      return new ResponseEntity<>(userService.registerUser(request), HttpStatus.CREATED);
    }

    @GetMapping(path = "/hello")
    public String hello (){
        return "hello";
    }
}
