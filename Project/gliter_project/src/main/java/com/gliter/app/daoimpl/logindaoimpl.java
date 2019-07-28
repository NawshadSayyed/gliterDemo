package com.gliter.app.daoimpl;

import org.springframework.web.servlet.ModelAndView;

import com.gliter.app.dao.logindao;
import com.gliter.app.model.loginmodel;
import com.gliter.app.serviceImpl.loginserviceimpl;

public class logindaoimpl implements logindao {

	@Override
	public ModelAndView getlogin(loginmodel lm) {
		ModelAndView mv;
		loginserviceimpl l= new loginserviceimpl();
		 boolean result=  l.getLoginService(lm);
		if(result){
			mv = new ModelAndView();
			mv.setViewName("dashboard");
			mv.addObject("loginmodel",lm);	
		}else{
			mv = new ModelAndView();
			mv.setViewName("failure");
			mv.addObject("mssage","try Again..");
		}
		
		return mv;
	}

}
