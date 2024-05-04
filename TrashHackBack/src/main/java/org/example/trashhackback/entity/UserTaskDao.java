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
    @JoinColumn(name = "id")
    private UserDao user;

    @ManyToOne
    @JoinColumn(name = "id")
    private TaskDao task;
}
