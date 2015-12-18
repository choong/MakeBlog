package com.choong.post.service;

import java.sql.SQLException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.choong.common.exception.CommonException;
import com.choong.common.vo.CommonErrorCode;
import com.choong.common.vo.ErrCodable;
import com.choong.mapper.post.dao.PostMapper;
import com.choong.mapping.post.dao.PostMapperTests;
import com.choong.post.vo.PostVO;

@Service
@Transactional
public class PostServiceImpl implements PostService {

	private Log log = LogFactory.getLog(PostServiceImpl.class);
	
	@Autowired
	private PostMapper postMapper;
	
	@Override
	public long addPostContent(PostVO postVO) throws CommonException {
		
		if (StringUtils.isEmpty(postVO.getContents())) {
			throw new CommonException(CommonErrorCode.ERR_0001, "contents");
		}
		
		if (postVO.getMemberNo() == -1) {
			throw new CommonException(CommonErrorCode.ERR_0001, "memberNo");
		}
		try {
			
			postMapper.insertPostContent(postVO);
			
		} catch (SQLException e){
			log.error(e);
			throw new CommonException(CommonErrorCode.ERR_0004);
		}
		
		return postVO.getId();
	}

	@Override
	public int updatePostContent(PostVO postVO) throws CommonException {
		
		if (-1 == postVO.getId()) {
			throw new CommonException(CommonErrorCode.ERR_0001, "id");
		}
		
		if (StringUtils.isEmpty(postVO.getContents())) {
			throw new CommonException(CommonErrorCode.ERR_0001, "contents");
		}
		
		if (postVO.getMemberNo() == -1) {
			throw new CommonException(CommonErrorCode.ERR_0001, "memberNo");
		}
		try {
			
			return postMapper.updatePostContent(postVO);
			
		} catch (SQLException e){
			log.error(e);
			throw new CommonException(CommonErrorCode.ERR_0004);
		}
	}

	@Override
	public int deletePostContent(long id) throws CommonException {
		
		if (-1 == id) {
			throw new CommonException(CommonErrorCode.ERR_0001, "id");
		}
		
		try {
			
			return postMapper.deletePostContent(id);
			
		} catch (SQLException e){
			log.error(e);
			throw new CommonException(CommonErrorCode.ERR_0004);
		}
		
	}

	@Override
	public PostVO getPostContent(long id) throws CommonException {
		if (-1 == id) {
			throw new CommonException(CommonErrorCode.ERR_0001, "id");
		}
		
		try {
			
			return postMapper.selectPostContent(id);
			
		} catch (SQLException e){
			log.error(e);
			throw new CommonException(CommonErrorCode.ERR_0004);
		}
	}

	
}
