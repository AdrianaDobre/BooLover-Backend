package com.bookloverbackend.bookloverbackend.controller;

import com.bookloverbackend.bookloverbackend.exceptions.EmailUsedAlready;
import com.bookloverbackend.bookloverbackend.exceptions.WrongCredentials;
import com.bookloverbackend.bookloverbackend.model.AuthRequest;
import com.bookloverbackend.bookloverbackend.model.User;
import com.bookloverbackend.bookloverbackend.service.UserService;
import com.bookloverbackend.bookloverbackend.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public String createUser(@RequestBody User user) throws EmailUsedAlready {
        return userService.registerUser(user);
    }

    @PostMapping("/auth")
    public String generateAuthToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
        } catch (Exception e) {
            throw new WrongCredentials("Incorrect email or password");
        }
        return jwtUtil.generateToken(authRequest.getEmail());
    }

}
