package org.example.trashhackback.controller;

import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.example.trashhackback.entity.UserDao;
import org.example.trashhackback.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ImageController {

    private final UserRepository userRepository;

    @GetMapping("/e")
    Boolean deleteAllInfo() {
        userRepository.deleteAll();
        return true;
    }

    @PermitAll
    @PostMapping("/schedule")
    void createUser(@RequestBody UserDao schedule) {
        userRepository.save(schedule);
    }
}
