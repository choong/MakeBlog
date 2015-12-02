package com.choong.common.util;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;

import com.choong.controller.main.MakeBlogApplication;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(MakeBlogApplication.class)
public class FileUtilTests extends AbstractTestNGSpringContextTests  {
	
	
	private String filePath1;
	private String filePath2;
	
	private String fileName;
	
	@Before
	public void setup(){
		filePath1 =  "/upload/image/";
		filePath2 =  "/upload/image";
		fileName = "untitled1.png";
	}
	
	@Autowired
	private FileUtil fileUtil;
	
	
	@Test
	public void testExistFile1_result_true(){
		String path = filePath1 + fileName;
		Assert.assertTrue(fileUtil.existFile(path));
	}
	
	@Test
	public void testExistFile1_result_false(){
		Assert.assertFalse(fileUtil.existFile(""));
	}
	
	@Test
	public void testExistFile2_result_true(){
		Assert.assertTrue(fileUtil.existFile(filePath2, fileName));
	}
	
	@Test
	public void testExistFile2_result_false(){
		Assert.assertFalse(fileUtil.existFile("", ""));
	}
	
	@Test
	public void testExistFile2WithOutSeparator(){
		Assert.assertTrue(fileUtil.existFile(filePath2, fileName));
	}
	
	
}
