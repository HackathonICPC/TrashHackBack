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

//    @Column(nullable = false)
//    Long previewImg;
//
//    @Column(nullable = false)
//    Long smallPreviewImg;

    @Column(nullable = false)
    Long experience;
//
//    @Column
//    @OneToMany(mappedBy = "id")
//    List<UserDao> participants;
//
//    @Column(nullable = false)
//    LocalDate orderTime;
//
//    @Column(nullable = false)
//    Boolean isFinished;
//
//    @Column(nullable = false)
//    Boolean isConfirmed;
//
//    @Column(nullable = false)
//    Double lat;
//
//    @Column(nullable = false)
//    Double lon;

    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    UserDao creator;
}
