package org.example.trashhackback.controller;

import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.example.trashhackback.entity.ImageDao;
import org.example.trashhackback.entity.UserDao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.trashhackback.service.ImageService;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/images")
public class ImageController {

    private final ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            imageService.save(file);
            return ResponseEntity.status(HttpStatus.OK).body("File uploaded successfully");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Could not upload the file");
        }
    }

    @GetMapping("/getAll")
    public List<ImageDao> getAll() {
        return imageService.get();
    }
}
