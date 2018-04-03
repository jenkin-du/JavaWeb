package com.esri.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.esri.bean.Response;
import com.esri.bean.User;
import com.esri.constant.Status;
import com.esri.dao.impl.UserDaoI;
import com.esri.utils.Util;
import com.esridb.DBLinker;
import com.google.gson.JsonParser;
import com.esri.utils.JSONParser;

public class UserDao implements UserDaoI {

	@Override
	public Response validate(User user) {
		Connection connection = DBLinker.getConnection();
		Response response = new Response();
		String sql = "select * from user where username='"+user.getUserName()+"'";

		try {
			Statement state = connection.createStatement();
			ResultSet set = state.executeQuery(sql);

			while (set.next()) {
				String pwd = set.getString("password");
				String username = set.getString("username");
				String id = set.getString("id");

				System.out.println(pwd + "," + username);

				if (username.equals(user.getUserName()) && pwd.equals(user.getPassword())) {
					response.setCode(Status.SUCCESS);
					response.setJsonObj(JSONParser.toJSONString(id));
					break;
				}
				if (!username.equals(user.getUserName())) {
					response.setCode(Status.USER_NONEXSIT);
				}
				if (!pwd.equals(user.getPassword())) {
					response.setCode(Status.PASSWORD_WRONG);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public Response insert(User user) {
		Connection connection = DBLinker.getConnection();
		Response response = new Response();
		String sql = "insert into user(id,username,password)values(?,?,?)";

		user.setuID("U" + Util.uniqueID());
		try {
			PreparedStatement state = connection.prepareStatement(sql);
			state.setString(1, user.getuID());
			state.setString(2, user.getUserName());
			state.setString(3, user.getPassword());

			if (!state.execute()) {
				response.setCode(Status.SUCCESS);
				response.setJsonObj(JSONParser.toJSONString(user.getuID()));
			}

		} catch (SQLException e) {
			if (validate(user).getCode().equals(Status.SUCCESS)) {
				response.setCode(Status.USER_EXSIT);
			} else {
				e.printStackTrace();
			}
		}
		return response;
	}

}
