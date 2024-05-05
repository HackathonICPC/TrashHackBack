package org.example.trashhackback.controller;

import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.example.trashhackback.entity.ImageDao;
import org.example.trashhackback.entity.UserDao;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.trashhackback.service.ImageService;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/images")
public class ImageController {

    private final ImageService imageService;

    @PostMapping("/upload")
    public Long uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        return imageService.save(file);
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable Long id) {

        try {
            String filename = imageService.findById(id);
            String path = "images/" + filename;

            File imgFile = new File(path);
            if (imgFile.exists()) {
                byte[] image = Files.readAllBytes(Paths.get(path));
                System.out.println(image);
                return ResponseEntity.ok()
                        .contentType(MediaType.IMAGE_JPEG)
                        .body(image);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/getAll")
    public List<ImageDao> getAll() {
        return imageService.get();
    }
}
