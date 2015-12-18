package com.choong.main.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.choong.common.util.DefaultProperties;
import com.choong.common.vo.InitializeVO;

@Controller
public class MainController {
	
	
    @RequestMapping("/")
    public String home(Model model) {
        return "welcome";
    }

    
    
    
}