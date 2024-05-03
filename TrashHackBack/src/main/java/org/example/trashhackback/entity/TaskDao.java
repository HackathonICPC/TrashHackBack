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
    String info;

    @Column(nullable = false)
    Long previewImg;

    @Column(nullable = false)
    Long smallPreviewImg;

    @Column
    String description;

    @Column
    Long peopleCount;

    @Column
    Long experience;

    @Column
    @OneToMany(mappedBy = "id")
    List<UserDao> participants;

    @Column(nullable = false)
    LocalDate orderTime;

    @Column(nullable = false)
    Boolean isFinished;

    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    UserDao leader;
}
