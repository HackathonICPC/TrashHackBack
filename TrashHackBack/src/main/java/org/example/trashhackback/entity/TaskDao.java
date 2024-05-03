package org.example.trashhackback.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class TaskDao {
    @Id
    @GeneratedValue
    private Long id;

    private String login, pass;
}
