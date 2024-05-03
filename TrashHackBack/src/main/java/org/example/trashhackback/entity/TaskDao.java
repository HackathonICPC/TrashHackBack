package org.example.trashhackback.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class TaskDao {
    @Id
    private Long id;

    @Column
    private String login, pass;
}
