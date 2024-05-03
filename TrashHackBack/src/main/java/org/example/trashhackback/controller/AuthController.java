package org.example.trashhackback.controller;

import org.example.trashhackback.entity.UserDao;
import org.example.trashhackback.service.AuthService;
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

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDao loginRequest) {
        boolean isAuthenticated = authService.authenticate(loginRequest.getLogin(), loginRequest.getPassword());
        if (isAuthenticated) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect login or password");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDao registerRequest) {
        boolean isRegistered = authService.register(registerRequest.getLogin(), registerRequest.getPassword());
        if (isRegistered) {
            return ResponseEntity.ok("Registration successful");
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User with this login already exists");
        }
    }
}
