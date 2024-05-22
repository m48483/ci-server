package com.example.devops.request;

import com.example.devops.global.Board;

public record BoardRequest(
        String name, String content
) {
    public Board toEntity(){
        return new Board(content,name,null);
    }
}
