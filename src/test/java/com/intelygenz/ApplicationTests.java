package com.intelygenz;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intelygenz.repository.NumbersRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
//TODO: Add failure test, bad data test
class ApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	void contextLoads() {
	}

	@Test
	void testNumberSortSuccess() throws Exception {

		MvcResult result =mvc.perform(get("/api/getNumbersSorted")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content()
						.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andReturn();

		List<List<Integer>> expectedResult = List.of(new ArrayList<>(List.of(15,7,3,5,1)));
		ObjectMapper mapper = new ObjectMapper();
		List<List<Integer>> obtainedResult = mapper.readValue(result.getResponse().getContentAsString(),List.class);

		assertEquals(expectedResult,obtainedResult);

	}

}
