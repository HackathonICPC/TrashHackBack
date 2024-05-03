package org.example.trashhackback.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class UserDao {
    @Id
    @GeneratedValue
    private String login;

    @Column
    private String password;
}