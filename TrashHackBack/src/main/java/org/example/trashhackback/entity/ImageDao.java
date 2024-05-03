package org.example.trashhackback.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class ImageDao {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String img;
}
