package com.example.devops.service;

import com.example.devops.global.Board;
import com.example.devops.global.BoardRepository;
import com.example.devops.request.BoardRequest;
import com.example.devops.response.BoardResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;

    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public void save(BoardRequest req) {
        boardRepository.save(req.toEntity());
    }

    @Override
    public List<BoardResponse> getBoards() {
        return boardRepository.findAll()
                .stream()
                .map(BoardResponse::from)
                .toList();
    }

    @Override
    public void delBoards() {
        boardRepository.deleteAll();
    }

    @Override
    public void deleteById(Long id) {
        Optional<Board> byId = boardRepository.findById(id);
        byId.orElseThrow(IllegalArgumentException::new);
        boardRepository.deleteById(id);
    }

    @Override
    public BoardResponse getById(Long id) {
        return BoardResponse.from(boardRepository.findById(id).orElseThrow(IllegalArgumentException::new));
    }
}
