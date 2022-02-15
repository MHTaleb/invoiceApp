package com.talcorpdz.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.talcorpdz.domain.Tva;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class GenericControllerTest {

	private MockMvc mvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	private Tva tva;

	protected String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}

	@BeforeAll
	public void setUp() throws Exception {
		tva = new Tva();
		tva.setTvaID(0L);
		tva.setName("zero");
		tva.setRate(0D);
		tva.setValue("T-0");
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void insertTva() throws JsonProcessingException, Exception {
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post("/api/tva")
		                         .contentType(MediaType.APPLICATION_JSON_VALUE)
		                         .accept(MediaType.APPLICATION_JSON_VALUE)
		                         .content(mapToJson(tva))).andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		int status = response.getStatus();
		System.out.println("status = " + status);
		String content = response.getContentAsString();
		System.out.println(content);

		String error = response.getErrorMessage();
		System.out.println(error);

		assertEquals(200, status);

	}

}
