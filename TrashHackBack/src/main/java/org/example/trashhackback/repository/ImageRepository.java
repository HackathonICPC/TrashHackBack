package org.example.trashhackback.repository;

import jakarta.persistence.Id;
import org.example.trashhackback.entity.ImageDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<ImageDao, Long> {

}
