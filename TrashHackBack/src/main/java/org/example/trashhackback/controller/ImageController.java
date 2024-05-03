package org.example.trashhackback.controller;

import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.example.trashhackback.entity.ImageDao;
import org.example.trashhackback.entity.UserDao;
import org.example.trashhackback.repository.UserRepository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.example.trashhackback.service.ImageService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/images")
public class ImageController {

    private final ImageService imageService;

    @Secured("ROLE_ADMIN")
    @GetMapping("/deleteAll")
    void deleteAll() {
        imageService.deleteAll();
    }

    @PermitAll
    @PostMapping("/save")
    void save(@RequestBody ImageDao imageDto) {
        //imageService.save();
    }
}
