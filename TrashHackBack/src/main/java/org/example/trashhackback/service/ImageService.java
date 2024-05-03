import org.example.trashhackback.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public Image saveImage(MultipartFile file) throws IOException {
        Image image = new Image();
        image.getClass(file.getBytes());
        return imageRepository.save(image);
    }

    public Image getImage(Long id) {
        return imageRepository.findById(id).orElse(null);
    }
}