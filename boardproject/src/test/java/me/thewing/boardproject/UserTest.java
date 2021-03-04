package me.thewing.boardproject;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class UserTest {

	@Autowired
	MockMvc mockMvc;

	@Test
	void findByIdTest() throws Exception {
		mockMvc.perform(get("/api/users/{id}", 1L))
				.andDo(print())
				.andExpect(status().isOk());
	}
}
