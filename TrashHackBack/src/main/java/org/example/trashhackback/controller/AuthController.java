package org.example.trashhackback.controller;

import jakarta.annotation.security.PermitAll;
import org.apache.tomcat.Jar;
import org.example.trashhackback.entity.UserDao;
import org.example.trashhackback.service.AuthService;
import org.example.trashhackback.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;
    private JwtService jwtService;

    @PermitAll
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDao user) {
        boolean isAuthenticated = authService.authenticate(user.getLogin(), user.getPassword());

        if (isAuthenticated) {
            return ResponseEntity.ok("Login successful, token = " + jwtService.generateToken(user.getLogin(), user.getPassword()));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect login or password");
        }
    }

    @PermitAll
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDao user) {
        boolean isRegistered = authService.register(user.getLogin(), user.getPassword());
        if (isRegistered) {
            return ResponseEntity.ok("Registration successful, token = " + jwtService.generateToken(user.getLogin(), user.getPassword()));
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User with this login already exists");
        }
    }
}
