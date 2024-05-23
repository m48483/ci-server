package com.example.devops.service;

import com.example.devops.global.Board;
import com.example.devops.global.BoardRepository;
import com.example.devops.request.BoardRequest;
import com.example.devops.response.BoardResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class BoardServiceTest {
    @Mock
    private BoardRepository boardRepository;
    @InjectMocks
    private BoardServiceImpl boardService;

    @Test
    void getById() {
        Board board = new Board("test", "test", 1L);
        BDDMockito.given(boardRepository.findById(1l))
                .willReturn(Optional.of(board));


        BoardResponse byId = boardService.getById(1l);

//        행위 검증
        Mockito.verify(boardRepository, times(1)).findById(1l);
//        상태 검증
        assertEquals("test", byId.name());
        assertEquals("test", byId.content());
        assertNotNull(byId.id());
    }
    @Test
    void getByIdNotExist() {
        BDDMockito.given(boardRepository.findById(1l)).willReturn(Optional.empty());
        assertThrows(IllegalArgumentException.class, ()->{
            boardService.getById(1l);
        });
        Mockito.verify(boardRepository, times(1)).findById(1l);

    }

    @Test
    void deleteById() {
//        BDDMockito.given(boardRepository.deleteById(1l));
//        case 2: 있을 때
//        given
        BDDMockito.doNothing().when(boardRepository).deleteById(1L);
        BDDMockito.given(boardRepository.findById(1L))
                        .willReturn(Optional.of(new Board(null, null,1L)));
        boardService.deleteById(1L);
    }

    @Test
    void deleteByIdFail() {
//        BDDMockito.given(boardRepository.deleteById(1l));
//        case 1: id가 없을 때
//        when then
//        assertThrows(IllegalArgumentException.class, ()->{boardService.deleteById(100L);});
        BDDMockito.given(boardRepository.findById(100L))
                .willReturn(Optional.empty());
        assertThrows(IllegalArgumentException.class, ()->{
            boardService.deleteById(100L);
        });
    }


    @Test
    void getAll() {
//
        BDDMockito.given(boardRepository.findAll()).willReturn(
                List.of(new Board("test","test", 1L),new Board("test","test", 2L)));

        List<BoardResponse> all = boardService.getBoards();

        assertEquals(2, all.size());
        assertEquals("test", all.get(1).name());
        Mockito.verify(boardRepository).findAll();
    }

//    @Test
//    void saveBoard() {
//        BoardRequest request = new BoardRequest("test", "test");
//        Board entity = request.toEntity();
////        BDDMockito.given(boardRepository.save(entity))
////                .willReturn(entity);
////        boardService.save(request);
//
//        Mockito.verify(boardRepository, Mockito.times(1)).save(entity);
//    }
}