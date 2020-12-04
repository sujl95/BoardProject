package me.thewing.boardproject;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.thewing.boardproject.domain.BoardDto;
import me.thewing.boardproject.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@Transactional
public class BoardControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    BoardService boardService;

    @Test
    void getList() throws Exception{
        mockMvc.perform(get("/api/board/getlist"))
                .andDo(print())
                .andExpect(status().isOk())
                ;
    }

    @Test
    void insertBoard() throws Exception{
        BoardDto test = BoardDto.builder()
                .title("test")
                .content("내용")
                .writer("thewing")
                .password(1234)
                .regdate(LocalDateTime.now().toString())
                .cnt(1)
                .build();
        mockMvc.perform(post("/api/board/insertBoard")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(test)))
                .andDo(print())
                .andExpect(status().isOk())
        ;

    }
}