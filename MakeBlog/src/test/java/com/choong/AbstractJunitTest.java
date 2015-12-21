package com.choong;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.choong.main.controller.MakeBlogApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MakeBlogApplication.class)
@WebAppConfiguration
public abstract class AbstractJunitTest {
	
	@Value("${local.server.port}")
	protected int port;

	@Value("${local.server.url}")
	protected String url;
	
	public abstract void setUp();

}
