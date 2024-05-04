package org.example.trashhackback.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table
@Data
public class UserDao {
    @Id
    @GeneratedValue
    Long id;

    @Column(nullable = false)
    String login, password;

    @Column
    Long avatarId;

    @Column(nullable = false)
    Long experiencePoints = 0L;

    @Column
    @OneToMany(mappedBy = "id")
    List<TaskDao> tasks;

}