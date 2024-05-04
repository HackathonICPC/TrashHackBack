package org.example.trashhackback.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table
@Data
@Entity
public class UserTaskDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id") // Изменено имя столбца на "user_id"
    private UserDao user;

    @ManyToOne
    @JoinColumn(name = "task_id") // Изменено имя столбца на "task_id"
    private TaskDao task;
}
