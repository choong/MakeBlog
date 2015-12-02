package com.choong.controller.main;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.choong.common.util.DefaultProperties;
import com.choong.common.vo.InitializeVO;

@Controller
public class MainController {

	@Autowired
	private DefaultProperties defaultProperties;
	
    @RequestMapping("/")
    public String home(Model model) {
    	
    	InitializeVO initVO = init();
    	model.addAttribute("init", initVO);
        return "welcome";
    }

    private InitializeVO init(){
    	InitializeVO initVO = new InitializeVO();
    	initVO.setTitle(defaultProperties.getWebSiteTitle());
    	
    	return initVO;
    	
    }
    
    
}