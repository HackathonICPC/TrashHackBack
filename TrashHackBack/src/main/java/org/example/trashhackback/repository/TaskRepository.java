package org.example.trashhackback.repository;

import org.example.trashhackback.entity.TaskDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskDao, Long> {
    TaskDao findByTitle(String title);
}
