package com.choong.post.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.choong.AbstractPostJunitTest;
import com.choong.post.service.PostService;


public class WriteControllerTest extends AbstractPostJunitTest {
	
	@Mock
	PostService postService;
	
	@InjectMocks
	private WriteController writeController;
	
	@Test
	public void contextLoads() {
	}
	
	@Value("${local.server.port}")
	private int port;

	@Value("${local.server.url}")
	private String url;
	
	
	
	private MockMvc mockMvc;
	
	@Before
	@Override
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(writeController).build(); 
	}
	
	
	@Test
	public void testWriteView() throws Exception {
		mockMvc.perform(get(this.url + ":" + this.port + "/write/view")).andExpect(status().isOk());
	}
	
	@Test
	public void testWriteSave() throws Exception {
		mockMvc.perform(post(this.url + ":" + this.port + "/write/save")).andExpect(status().isOk());
	}
	
	@Test
	public void testWriteSaveHttpMethodGet() throws Exception {
		mockMvc.perform(get(this.url + ":" + this.port + "/write/save")).andExpect(status().is4xxClientError());
	}
	
}
