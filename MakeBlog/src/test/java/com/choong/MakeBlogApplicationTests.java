package com.choong;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;

import com.choong.main.controller.MakeBlogApplication;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MakeBlogApplication.class)
@WebAppConfiguration
public class MakeBlogApplicationTests extends AbstractTestNGSpringContextTests  {
	
	
	@Test
	public void contextLoads() {
	}
	
	
	@Value("${local.server.port}")
	private int port;

	@Value("${local.server.url}")
	private String url;
	
	@Test
	public void testHome() throws Exception {
		ResponseEntity<String> entity = new TestRestTemplate()
				.getForEntity(this.url + ":" + this.port, String.class);
	
		Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());
		
	}
	
}
