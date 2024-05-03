package org.example.trashhackback.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class UserDao {
    @Id
    @GeneratedValue
    Long id;

    @Column
    private String login, password;
}