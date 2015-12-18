package com.choong.post.service;

import com.choong.common.exception.CommonException;
import com.choong.post.vo.PostVO;

public interface PostService {

	public long addPostContent(PostVO postVO) throws CommonException;
	
	public int updatePostContent(PostVO postVO) throws CommonException;
	
	public int deletePostContent(long id) throws CommonException;
	
	public PostVO getPostContent(long id) throws CommonException;
}
