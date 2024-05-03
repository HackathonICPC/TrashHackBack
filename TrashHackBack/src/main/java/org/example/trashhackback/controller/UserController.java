package org.example.trashhackback.controller;

import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.example.trashhackback.entity.UserDao;
import org.example.trashhackback.repository.UserRepository;
import org.example.trashhackback.service.UserService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @Secured("ROLE_ADMIN")
    @GetMapping("/deleteAllUsers")
    void deleteAll() {
        userService.deleteAll();
    }

    @PermitAll
    @PostMapping("/createUser")
    void createUser(@RequestBody UserDao userDao) {
        userService.save(userDao);
    }

}
