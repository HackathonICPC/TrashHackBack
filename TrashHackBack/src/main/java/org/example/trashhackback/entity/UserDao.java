package org.example.trashhackback.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class UserDao {
    @Id
    private Integer id;

    @Column
    private String login, pass;
}