package org.example.trashhackback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@SpringBootApplication
public class TrashHackBackApplication {

    public static void main(String[] args) {
        String directoryPath = "images";

        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        Path dirPath = Paths.get("images/");
        try (Stream<Path> stream = Files.walk(dirPath)) {
            stream
                    .filter(Files::isRegularFile)
                    .forEach(path -> {
                        try {
                            Files.delete(path);
                        } catch (IOException e) {
                            System.err.println("Unable to delete: " + path + " due to " + e.getMessage());
                            return;
                        }
                    });
        } catch (IOException e) {
            System.err.println("Error walking through the directory: " + e.getMessage());
            return;
        }
        SpringApplication.run(TrashHackBackApplication.class, args);
    }

}
