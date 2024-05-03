package org.example.trashhackback.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class ImageDao {
    @Id
    private Long id;

    @Column
    @Lob
    private Byte[] img;
}
