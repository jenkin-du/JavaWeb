package com.esri.dao.impl;

import com.esri.bean.Response;
import com.esri.bean.User;

public interface UserDaoI {

	/**
	 * 验证用户名和密码
	 * @param user 用户类
	 * @return  Response类型
	 *  		验证成功，返回 code为Status.SUCCESS，jsonObj为该用户的json格式的ID号，用法：r.setJsonObj=JsonParser.toJsonString(sequence);
	 *  		用户名不存在， code为Status.USER_NONEXSIT；
	 *  		密码错误， code为Status.PASSWORD_WRONG;
	 */
	public Response validate(User user);
	
	/**
	 * 注册插入
	 * @param user 用户类
	 * 在生成用户ID时，规则："U"+Util.uniqueID(); 注：U 是大写,其余生成id方法类似
	 * @return  Response类型
	 * 			插入成功，返回 code为Status.SUCCESS，jsonObj为该用户的json格式的序列号，
	 *			用户名已存在，返回 code为Status.USER_EXSIT
	 */
	public Response insert(User user);
}
