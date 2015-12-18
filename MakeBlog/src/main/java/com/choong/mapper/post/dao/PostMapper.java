package com.choong.mapper.post.dao;

import java.sql.SQLException;

import com.choong.post.vo.PostVO;

public interface PostMapper {

	public void insertPostContent(PostVO postVO) throws SQLException;
	
	public PostVO selectPostContent(long id) throws SQLException;

	public int updatePostContent(PostVO postVO) throws SQLException;

	public int deletePostContent(long id) throws SQLException;

}