package com.choong.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.choong.common.util.DefaultProperties;
import com.choong.common.vo.InitializeVO;


public class InitInterceptor implements HandlerInterceptor {
	
	@Autowired
	private DefaultProperties defaultProperties;
	
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {}

	
	
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView model) throws Exception {
		InitializeVO initVO = init();
    	model.addObject("init", initVO);
	}

	private InitializeVO init(){
    	InitializeVO initVO = new InitializeVO();
    	initVO.setTitle(defaultProperties.getWebSiteTitle());
    	
    	return initVO;
    	
    }
	
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		return true;
	}

}
