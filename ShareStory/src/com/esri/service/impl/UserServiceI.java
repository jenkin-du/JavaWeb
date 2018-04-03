package com.esri.service.impl;

import com.esri.bean.Response;
import com.esri.bean.User;

public interface UserServiceI {

	/**
	 * 登录
	 * @param user
	 */
	public Response login(User user);
	
	/**
	 * 注册
	 * @param user
	 */
	public Response register(User user);
}
