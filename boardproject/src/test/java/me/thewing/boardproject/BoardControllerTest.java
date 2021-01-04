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
    void getList() throws Exception{
        mockMvc.perform(get(boardPath+"/getlist"))
                .andDo(print())
                .andExpect(status().isOk())
                ;
    }

    @Test
    void getBoard() throws Exception {

        mockMvc.perform(get(boardPath+"/getBoard/1"))
                .andDo(print())
                .andExpect(status().isOk())
                ;
    }

    @Test
    void insertBoard() throws Exception{
        System.out.println("test");
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
                .andExpect(status().isCreated())
        ;

    }

    @Test
    void apiTest() throws Exception {
        // mockMvc.perform(get("https://dapi.kakao.com/v2/local/geo/coord2address.json?input_coord=WGS84&y=37.599191&x=126.716316")
        //                     .contentType(MediaType.APPLICATION_JSON)
    }

}