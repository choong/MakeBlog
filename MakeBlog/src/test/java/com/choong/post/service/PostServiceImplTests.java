package com.choong.post.service;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import com.choong.AbstractPostJunitTest;
import com.choong.common.exception.CommonException;
import com.choong.mapper.post.dao.PostMapper;

@Transactional
public class PostServiceImplTests extends AbstractPostJunitTest{
	
	
	@Configuration
	static class PostServiceImplTestsConfiguration{
		@Bean
		public PostMapper postMapper(){
			return Mockito.mock(PostMapper.class);
		}
	}
	
	@Autowired
	private PostService postService;
	
	
	
	@Test
	public void testAddPostContent() throws CommonException{
		postService.addPostContent(postVO);
		
	}
	
	@Test(expected=CommonException.class)
	public void testAddPostContentWithoutContent() throws CommonException{
		postVO.setContents("");
		postService.addPostContent(postVO);
	}
	
	@Test(expected=CommonException.class)
	public void testAddPostContentWithoutMemberNo() throws CommonException{
		postVO.setMemberNo(-1);
		postService.addPostContent(postVO);
	}
	
	
	@Test
	public void testModifyPostContent() throws CommonException{
		postService.updatePostContent(postVO);
		
	}
	
	@Test(expected=CommonException.class)
	public void testModifyPostContentWithoutID() throws CommonException{
		postVO.setId(-1);
		postService.updatePostContent(postVO);
	}
	
	@Test(expected=CommonException.class)
	public void testModifyPostContentWithoutContent() throws CommonException{
		postVO.setContents("");
		postService.updatePostContent(postVO);
	}
	
	@Test(expected=CommonException.class)
	public void testModifyPostContentWithoutMemberNo() throws CommonException{
		postVO.setMemberNo(-1);
		postService.updatePostContent(postVO);
	}
	
	@Test
	public void testDeletePostContent() throws CommonException{
		postService.deletePostContent(postVO.getId());
		
	}
	
	@Test(expected=CommonException.class)
	public void testDeletePostContentWithoutID() throws CommonException{
		postVO.setId(-1);
		postService.deletePostContent(postVO.getId());
	}
	
	@Test
	public void testGetPostContent() throws CommonException{
		postService.getPostContent(postVO.getId());
		
	}
	
	@Test(expected=CommonException.class)
	public void testGetPostContentWithoutID() throws CommonException{
		postVO.setId(-1);
		postService.getPostContent(postVO.getId());
	}
	
}
