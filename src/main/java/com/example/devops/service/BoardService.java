package com.example.devops.service;

import com.example.devops.request.BoardRequest;
import com.example.devops.response.BoardResponse;

import java.util.List;

public interface BoardService {
    void save(BoardRequest board);
    List<BoardResponse> getBoards();
    void delBoards();
    void deleteById(Long id);
    BoardResponse getById(Long id);

}
