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
        List<BoardDto> boardList = boardMapper.getBoardList();
        return boardList;
    }

    public void insertBoard(BoardDto boardDto) {
        boardMapper.insertBoard(boardDto);
    }
}


