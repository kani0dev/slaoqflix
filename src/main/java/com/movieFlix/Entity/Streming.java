package com.movieFlix.Entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor @AllArgsConstructor

@Entity
@Getter @Setter
@Table(name = "streaming")
public class Streming {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 100, nullable = false, name = "name")
    private String name;
}
