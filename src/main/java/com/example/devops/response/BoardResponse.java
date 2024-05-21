package com.example.devops.response;

import com.example.devops.global.Board;

public record BoardResponse(
        Long id, String name, String content
) {

    public static BoardResponse from(Board board) {
        return new BoardResponse(
                board.getId(),
                board.getName(),
                board.getContent()

        );
    }
}
