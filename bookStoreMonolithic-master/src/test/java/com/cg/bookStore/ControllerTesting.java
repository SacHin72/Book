package com.cg.bookStore;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cg.bookStore.web.ManageBookController;

@RunWith(SpringJUnit4ClassRunner.class)
public class ControllerTesting{

	@InjectMocks
	private ManageBookController controller;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	public void demoTest() throws Exception
	{
		mockMvc.perform(post("manageBook/update"))
		.andExpect(status().isFound())
		.andExpect(content().string("Details Updated"));
	
	
	}
	
}

