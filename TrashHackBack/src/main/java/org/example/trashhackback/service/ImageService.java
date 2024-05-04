package org.example.trashhackback.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.example.trashhackback.entity.ImageDao;
import org.example.trashhackback.entity.UserDao;
import org.example.trashhackback.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;

    public void deleteAll() {
        imageRepository.deleteAll();
    }

    public Long save(MultipartFile file) throws IOException {
        ImageDao imageDao = new ImageDao();

        String filename = UUID.randomUUID() + ".jpg";
        String filePath = "images/" + filename;

        imageDao.setImg(filename);

        File targetFile = new File(filePath);
        FileUtils.copyInputStreamToFile(file.getInputStream(), targetFile);

        return imageRepository.save(imageDao).getId();
    }

    public List<ImageDao> get() {
        return imageRepository.findAll();
    }
}