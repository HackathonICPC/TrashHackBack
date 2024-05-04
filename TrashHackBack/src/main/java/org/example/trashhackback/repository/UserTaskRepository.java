package org.example.trashhackback.repository;

import org.example.trashhackback.entity.UserTaskDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserTaskRepository extends JpaRepository<UserTaskDao, Long> {
    boolean existsByUserIdAndTaskId(Long userId, Long taskId);
    List<UserTaskDao> AllRelations(Long userId);
}