package com.example.devops.global;

import jakarta.persistence.*;

@Entity
@Table(name ="BOARDS")
public class Board {
    public Board(String content, String name, Long id) {
        this.content = content;
        this.name = name;
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="BOARD_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    @Column(name = "CONTENT")
    private String content;
}
