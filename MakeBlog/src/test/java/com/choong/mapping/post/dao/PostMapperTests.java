package com.choong.mapping.post.dao;

import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;

import com.choong.AbstractPostJunitTest;
import com.choong.common.util.FileUtil;
import com.choong.main.controller.MakeBlogApplication;
import com.choong.mapper.post.dao.PostMapper;
import com.choong.post.vo.PostVO;

@Transactional

public class PostMapperTests extends AbstractPostJunitTest{
 
    @Autowired
    private PostMapper postMapper;
 
    private PostVO postVO;
            
    @Before
    @Override
    public void setUp() {
    	postVO = new PostVO();
    	postVO.setContents("TEST DATA");
    	postVO.setMemberNo(1234567890);
    	try {
    		postMapper.insertPostContent(postVO);
    	} catch (Exception e){}
    	
    }
 
    @Test
    public void testInsertPostContents() throws SQLException{
    	
    	Assert.assertNotNull(postVO);
        postMapper.insertPostContent(postVO);
        Assert.assertTrue(postVO.getId() > 0);
        
    }
    
    @Test
    public void testSelectPostContent() throws SQLException {
    	
    	PostVO result = postMapper.selectPostContent(postVO.getId());
    	
    	Assert.assertEquals(postVO.getId(), result.getId());
    	Assert.assertEquals(postVO.getContents(), result.getContents());
    	
    }
    
    @Test
    public void testUpdatePostContent() throws SQLException {
    	
    	postVO.setContents("UPDATE POST TEST");
    	postVO.setMemberNo(987654321);
    	postMapper.updatePostContent(postVO);
    	
    	PostVO result = postMapper.selectPostContent(postVO.getId());
    	
    	Assert.assertEquals(postVO.getId(), result.getId());
    	Assert.assertEquals(postVO.getContents(), result.getContents());
    }
    
    @Test
    public void testDeletePostContent() throws SQLException {
    	PostVO beforeDelete = postMapper.selectPostContent(postVO.getId());
    	Assert.assertNotNull(beforeDelete);
    	postMapper.deletePostContent(postVO.getId());
    	PostVO afterDelete = postMapper.selectPostContent(postVO.getId());
    	Assert.assertNull(afterDelete);
    }
}