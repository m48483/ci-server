package com.example.devops.global;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name ="BOARDS")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="BOARD_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CONTENT")
    private String content;
}
