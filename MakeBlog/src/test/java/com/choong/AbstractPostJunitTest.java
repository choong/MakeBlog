package com.choong;

import org.junit.Before;

import com.choong.post.vo.PostVO;

public abstract class AbstractPostJunitTest extends AbstractJunitTest {

	protected PostVO postVO;

	@Before
	@Override
	public void setUp() {
    	postVO = new PostVO();
    	postVO.setContents("TEST DATA");
    	postVO.setMemberNo(1234567890);
    	
    }
}
