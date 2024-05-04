package org.example.trashhackback.controller;

import org.example.trashhackback.service.JwtService;
import org.example.trashhackback.service.UserService;
import org.example.trashhackback.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    JwtService jwtService;

    public ResponseEntity<?> profileInfo(@RequestParam String token) {


        return new ResponseEntity<>("Hello world!", HttpStatus.OK);
    }
}
