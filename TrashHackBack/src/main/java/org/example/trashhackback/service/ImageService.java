package org.example.trashhackback.service;

import lombok.RequiredArgsConstructor;
import org.example.trashhackback.entity.ImageDao;
import org.example.trashhackback.entity.UserDao;
import org.example.trashhackback.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;

    public void deleteAll() {
        imageRepository.deleteAll();
    }

    public void save(ImageDao imageDao) {
        imageRepository.save(imageDao);
    }

    public List<ImageDao> get() {
        return imageRepository.findAll();
    }
}