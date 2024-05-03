package org.example.trashhackback.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.apache.commons.lang3.builder.HashCodeExclude;

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
    Long previewImg;

    @Column
    String description;

    @Column
    @OneToMany(mappedBy = "id")
    List<UserDao> participants;

    @Column(nullable = false)
    LocalDate orderTime;

    @Column(nullable = false)
    Boolean isfinished;

    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    UserDao leader;
}
