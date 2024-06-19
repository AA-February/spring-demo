package com.example.security_demo.controller;

import com.example.security_demo.dto.AuthRequest;
import com.example.security_demo.dto.UserRequest;
import com.example.security_demo.dto.UserResponse;
import com.example.security_demo.service.AuthService;
import com.example.security_demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private AuthService authService;

    @PostMapping(path = "/register")
    ResponseEntity<UserResponse> register(@RequestBody UserRequest request) {
      return new ResponseEntity<>(userService.registerUser(request), HttpStatus.CREATED);
    }

    @PostMapping(path = "/auth")
    ResponseEntity<String> auth(@RequestBody AuthRequest authRequest){
      return new ResponseEntity<>(authService.authenticate(authRequest),HttpStatus.OK);
    }

    @GetMapping(path = "/hello/23")
    @PreAuthorize("hasRole('ROLE_ADMIN,ROLE_EMPLOYEE')")
    public String hello (){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        // ReservationRepository.getReservationById
        // reservation.getUser().getEmail == userDetails.getEmail

        return "hello admin";
    }
}
