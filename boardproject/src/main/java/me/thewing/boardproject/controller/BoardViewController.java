package me.thewing.boardproject.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import me.thewing.boardproject.domain.BoardDto;
import me.thewing.boardproject.service.BoardService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardViewController {

	private BoardService boardService;

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
	public String insertBoard(@Valid BoardDto boardDto) {
		boardService.insertBoard(boardDto);
		return "redirect:/board/list";
	}

	@GetMapping("/edit/{seq}")
	public String edit(@PathVariable("seq") Integer seq, Model model) {
		BoardDto boardDto = boardService.getBoard(seq);
		model.addAttribute("board", boardDto);
		return "edit";
	}

	@PostMapping("/updateBoard")
	public String updateBoard(@Valid BoardDto boardDto) {
		boardService.updateBoard(boardDto);
		return "redirect:/board/list";
	}

	@PostMapping("/delBoard")
	public String delBoard(BoardDto boardDto) {
		boardService.delBoard(boardDto);
		return "redirect:/board/list";
	}

}
