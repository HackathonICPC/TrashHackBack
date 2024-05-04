package org.example.trashhackback.controller;

import jakarta.annotation.security.PermitAll;
import org.example.trashhackback.controller.request.UserRequest;
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
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;
    @Autowired
    private JwtService jwtService;

    @PermitAll
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserRequest user) {
        Long id = authService.authenticate(user.login(), user.password());
        if (id != -1) {
            return ResponseEntity.ok(jwtService.generateToken(id));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PermitAll
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRequest user) {
        Long id = authService.register(user.login(), user.password());
        if (id != -1) {
            return ResponseEntity.ok(jwtService.generateToken(id));
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
