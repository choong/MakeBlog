package com.choong.post.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.choong.common.util.DefaultProperties;
import com.choong.common.vo.InitializeVO;
import com.choong.common.vo.ResponseResultVO;

@Controller
@RequestMapping("/write")
public class WriteController {
	
	@Autowired
	private DefaultProperties defaultProperties;
	
	@RequestMapping("/view")
	public String viewWrite(Model model){
		
		InitializeVO initVO = init();
    	model.addAttribute("init", initVO);
    	
		return "post/write";
	}
	
	private InitializeVO init(){
    	InitializeVO initVO = new InitializeVO();
    	initVO.setTitle(defaultProperties.getWebSiteTitle());
    	
    	return initVO;
    	
    }
	
	@RequestMapping("/summernote")
	public String viewSummernote(Model model){
		
		InitializeVO initVO = init();
    	model.addAttribute("init", initVO);
    	
		return "post/summernote";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public @ResponseBody ResponseResultVO saveContents(HttpServletRequest request){
		ResponseResultVO result = new ResponseResultVO();
		String contents = ServletRequestUtils.getStringParameter(request, "contents", null);
		int memberNo = ServletRequestUtils.getIntParameter(request, "memberNo", -1);
		return result;
	}
	
	@RequestMapping(value="/save/{id}", method=RequestMethod.PUT)
	public void saveContents(@PathVariable("id") int id){
		
	}
	
}
