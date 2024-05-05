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
    String title;

    @Column(nullable = false)
    String description;

    @Column(nullable = false)
    Long photoID;

    @Column(nullable = false)
    Long experience;

    @Column
    Boolean isStarted = false;

    @Column(nullable = false)
    Double x;

    @Column(nullable = false)
    Double y;

    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    UserDao creator;
}
