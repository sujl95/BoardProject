package me.thewing.boardproject;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;

import me.thewing.boardproject.domain.BoardDto;
import me.thewing.boardproject.service.BoardService;

@WebMvcTest
//@Transactional
public class BoardControllerTest {
	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	@MockBean
	BoardService boardService;

	String boardPath = "/api/board";

	@Test
	void getList() throws Exception {
		mockMvc.perform(get(boardPath + "/getlist"))
				.andDo(print())
				.andExpect(status().isOk())
		;
	}

	@Test
	void getBoard() throws Exception {

		mockMvc.perform(get(boardPath + "/getBoard/1"))
				.andDo(print())
				.andExpect(status().isOk())
		;
	}

	@Test
	void insertBoard() throws Exception {
		System.out.println("test");
		BoardDto test = BoardDto.builder()
				.title("test")
				.content("내용")
				.writer("thewing")
				.password(1234)
				.regdate(LocalDateTime.now().toString())
				.cnt(1)
				.build();
		ResultActions resultActions = mockMvc.perform(post("/api/board/insertBoard")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(test)))
				.andDo(print())
				.andExpect(status().isCreated());
		System.out.println("resultActions = " + resultActions.andReturn()
				.getResponse()
				.getContentAsString()
		);
	}

	@Test
	void apiTest() throws Exception {
		// mockMvc.perform(get("https://dapi.kakao.com/v2/local/geo/coord2address.json?input_coord=WGS84&y=37.599191&x=126.716316")
		//                     .contentType(MediaType.APPLICATION_JSON)
	}

}