package org.example.trashhackback.controller;

import jakarta.annotation.security.PermitAll;
import org.example.trashhackback.controller.request.TokenRequest;
import org.example.trashhackback.controller.response.UserResponse;
import org.example.trashhackback.entity.UserDao;
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

    @PermitAll
    @PostMapping("/info")
    public ResponseEntity<?> profileInfo(@RequestParam TokenRequest token) {

        Long id = jwtService.extractId(token.token());
        if (id == -1)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("invalid user token");

        UserDao userDao = userService.findById(id).get();

        UserResponse userResponse = new UserResponse(userDao.getLogin(), userDao.getExperiencePoints(), userDao.getColor());

        return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }
}
