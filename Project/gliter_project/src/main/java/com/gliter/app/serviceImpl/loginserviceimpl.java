package com.gliter.app.serviceImpl;

import com.gliter.app.model.loginmodel;
import com.gliter.app.service.LoginService;

public class loginserviceimpl implements LoginService {

	@Override
	public boolean getLoginService(loginmodel lm) {
		if(lm.getU_name().equalsIgnoreCase("admin") && lm.getU_pass().equalsIgnoreCase("admin")){
			return true;
		}else{
			return false;			
		}
	}

}
