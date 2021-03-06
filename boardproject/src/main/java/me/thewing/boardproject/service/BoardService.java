package me.thewing.boardproject.service;

import lombok.RequiredArgsConstructor;
import me.thewing.boardproject.domain.BoardDto;
import me.thewing.boardproject.repository.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class BoardService {

    private final BoardMapper boardMapper;

    public List<BoardDto> getList() {
        return boardMapper.getBoardList();
    }

    public void insertBoard(BoardDto boardDto) {
        boardMapper.insertBoard(boardDto);
    }

    public BoardDto getBoard(Integer seq) {
        return boardMapper.getBoard(seq);
    }

    public void updateCnt(Integer seq) {
        boardMapper.updateCnt(seq);
    }

    public void updateBoard(BoardDto boardDto) {
        boardMapper.updateBoard(boardDto);
    }

    public void delBoard(BoardDto boardDto) {
        boardMapper.delBoard(boardDto);
    }
}


