package com.choong.post.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.choong.common.exception.CommonException;
import com.choong.common.util.DefaultProperties;
import com.choong.common.vo.InitializeVO;
import com.choong.common.vo.ResponseResultVO;
import com.choong.post.service.PostService;
import com.choong.post.service.PostServiceImpl;
import com.choong.post.vo.PostVO;

@Controller
@RequestMapping("/write")
public class WriteController {
	
	private Log log = LogFactory.getLog(WriteController.class);
	
	@Autowired
	private DefaultProperties defaultProperties;
	
	@Autowired
	private PostService postService;
	
	@RequestMapping("/view")
	public String viewWrite(Model model){
		
		return "post/write";
	}
	
	
	
	@RequestMapping("/summernote")
	public String viewSummernote(Model model){
		
	
    	
		return "post/summernote";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public @ResponseBody ResponseResultVO saveContents(HttpServletRequest request){
		ResponseResultVO result = new ResponseResultVO();
		String contents = ServletRequestUtils.getStringParameter(request, "contents", null);
		int memberNo = ServletRequestUtils.getIntParameter(request, "memberNo", -1);
		
		try {
			PostVO postVO = new PostVO();
			postVO.setContents(contents);
			postVO.setMemberNo(memberNo);
			
			postService.addPostContent(postVO);
		} catch(CommonException e){
			log.error(e);
			result.setStatus(e.getCode());
			result.setMessage(e.getCode());
		}
		return result;
	}
	
	@RequestMapping(value="/save/{id}", method=RequestMethod.PUT)
	public void saveContents(@PathVariable("id") int id){
		
	}
	
}
