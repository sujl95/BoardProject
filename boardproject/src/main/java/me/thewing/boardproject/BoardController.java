package me.thewing.boardproject;

import lombok.RequiredArgsConstructor;
import me.thewing.boardproject.domain.BoardDto;
import me.thewing.boardproject.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("getlist")
    public ResponseEntity<?> getList() {
        List<BoardDto> list = boardService.getList();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("insertBoard")
    public String insertBoard(@RequestBody BoardDto boardDto) {
        boardService.insertBoard(boardDto);
//        ResponseEntity.ok("success");
//        ResponseEntity.ok().body("success");

        return "success";
//        return new ResponseEntity<>("success", HttpStatus.OK);
    }



}
