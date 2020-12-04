package me.thewing.boardproject.repository.mapper;

import me.thewing.boardproject.domain.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<BoardDto> getBoardList();

    void insertBoard(BoardDto boardDto);
}
