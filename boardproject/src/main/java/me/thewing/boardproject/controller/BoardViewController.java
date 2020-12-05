package me.thewing.boardproject.controller;

import me.thewing.boardproject.domain.BoardDto;
import me.thewing.boardproject.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardViewController {

    @Autowired
    BoardService boardService;

    @GetMapping("/list")
    public String list(Model model) {
        List<BoardDto> list = boardService.getList();

        model.addAttribute("boards", list);
        return "boardList";
    }

    @GetMapping("/board/{seq}")
    public String board(@PathVariable("seq") Integer seq, Model model) {
        boardService.updateCnt(seq);
        BoardDto boardDto = boardService.getBoard(seq);
        model.addAttribute("board", boardDto);
        return "board";
    }

    @GetMapping("/write")
    public String write() {



        return "write";
    }

    @PostMapping("insertBoard")
    public String insertBoard(BoardDto boardDto) {
        System.out.println(boardDto);
        boardService.insertBoard(boardDto);
//        ResponseEntity.ok("success");
//        ResponseEntity.ok().body("success");
        return "redirect:/board/list";
    }

    @GetMapping("/edit/{seq}")
    public String edit(@PathVariable("seq") Integer seq,Model model) {
        BoardDto boardDto = boardService.getBoard(seq);
        model.addAttribute("board", boardDto);

        return "edit";
    }

    @PostMapping("update")
    public String updateBoard(BoardDto boardDto) {
        System.out.println(boardDto);
        boardService.insertBoard(boardDto);
//        ResponseEntity.ok("success");
//        ResponseEntity.ok().body("success");
        return "redirect:/board/list";
    }


}
