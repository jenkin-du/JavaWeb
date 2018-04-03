package com.esri.service;

import com.esri.bean.Response;
import com.esri.bean.User;
import com.esri.dao.UserDao;
import com.esri.service.impl.UserServiceI;

public class UserService implements UserServiceI{

	UserDao dao=new UserDao();
	
	@Override
	public Response login(User user) {
		
		return dao.validate(user);
	}

	@Override
	public Response register(User user) {
		
		return dao.insert(user);
	}

	
}
