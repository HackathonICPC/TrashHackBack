package org.example.trashhackback.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table
@Data
public class TaskDao {
    @Id
    @GeneratedValue
    Long id;

    @Column(nullable = false)
    Long previewImg;

    @Column
    String description;

    @Column
    @OneToMany
    List<UserDao> participants;

    @Column(nullable = false)
    LocalDate orderTime;

    @Column(nullable = false)
    Boolean isfinished;

    @Column(nullable = false)
    UserDao leader;
}
