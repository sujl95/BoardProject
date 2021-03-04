package me.thewing.boardproject.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import me.thewing.boardproject.domain.BoardDto;
import me.thewing.boardproject.service.BoardService;

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

	@GetMapping("getBoard/{seq}")
	public ResponseEntity<?> getBoard(@PathVariable("seq") Integer seq) {
		boardService.updateCnt(seq);
		BoardDto boardDto = boardService.getBoard(seq);
		return new ResponseEntity<>(boardDto, HttpStatus.OK);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("insertBoard")
	public String insertBoard(@RequestBody @Valid BoardDto boardDto) {
		try {
			boardService.insertBoard(boardDto);
			return "success";
		} catch (Exception e) {
			return "failed";
		}
	}

	@PostMapping("updateBoard")
	public String updateBoard(@RequestBody @Valid BoardDto boardDto) {
		boardService.updateBoard(boardDto);
		return "success";
	}

	@PostMapping("delBoard")
	public String delBoard(BoardDto boardDto) {
		boardService.delBoard(boardDto);
		return "redirect:/board/list";
	}

}
