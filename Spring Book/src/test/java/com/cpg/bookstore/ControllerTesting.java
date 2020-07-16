package com.cpg.bookstore;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import com.cpg.bookstore.controller.MyController;
import com.cpg.bookstore.entities.BookInformation;
@RunWith(SpringJUnit4ClassRunner.class)
public class ControllerTesting{

	@InjectMocks
	private MyController myController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(myController).build();
	}
	
	@Test
	public void demoTest() throws Exception
	{
		mockMvc.perform(put("/UpdateBookInfo"))
		.andExpect(status().isOk())
		.andExpect(content().string("ERROR!!!"));
	
	
	}
	
}
