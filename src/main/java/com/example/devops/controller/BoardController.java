package com.example.devops.controller;

import com.example.devops.request.BoardRequest;
import com.example.devops.response.BoardResponse;
import com.example.devops.service.BoardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boards")
@CrossOrigin(
        allowedHeaders = "*",
        origins = "*",
        methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE, RequestMethod.OPTIONS }
)
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping
    public void save(@RequestBody BoardRequest req){
        boardService.save(req);
    }
    @GetMapping
    public List<BoardResponse> get(){
        return boardService.getBoards();
    }
    @DeleteMapping
    public void deleteBoard(){
        boardService.delBoards();
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        boardService.deleteById(id);
    }
}
