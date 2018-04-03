package com.esri.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.esri.bean.Response;
import com.esri.bean.User;
import com.esri.constant.Action;
import com.esri.constant.Param;
import com.esri.constant.Status;
import com.esri.service.UserService;
import com.esri.utils.JSONParser;
import com.esri.web.servlet.BaseHttpServlet;

@WebServlet("/UserServlet")
public class UserServlet extends BaseHttpServlet {

	private static final long serialVersionUID = 1L;

	UserService userService = new UserService();

	public UserServlet() {
		super();
	}

	/**
	 * 处理网页端的请求
	 */
	@Override
	protected void handleWebRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter(Param.ACTION);
		String password = request.getParameter(Param.PASSWORD);
		String confirm = request.getParameter("CONFIRM_PASSWORD");
		String userName = request.getParameter(Param.USER_NAME);

		Response r = new Response();

		if (action != null) {
			switch (action) {
			// 登录
			case Action.LOGIN:
				if (userName != "" && password != "") {
					User user = new User();
					user.setPassword(password);
					user.setUserName(userName);

					r = userService.login(user);
					String code = r.getCode();

					// 重定向
					// 用户名不存在
					if (code.equals(Status.USER_NONEXSIT)) {
						response.sendRedirect("index.jsp?reason=user_nonexsit");

						// 密码错误
					} else if (code.equals(Status.PASSWORD_WRONG)) {
						response.sendRedirect("index.jsp?reason=password_wrong");

						// 登录成功
					} else if (code.equals(Status.SUCCESS)) {
						response.sendRedirect("jsp/main.jsp?username=" + userName);
					}

				}

				break;

			// 注册
			case Action.REGISTER:
				if (userName != null && password != null && confirm != null) {
					
					if(!password.equals(confirm)){
						response.sendRedirect("index.jsp?reason=password_paradox");
					}else{
						
						User user = new User();
						user.setPassword(password);
						user.setUserName(userName);

						// 注册
						r = userService.register(user);
						response.sendRedirect("index.jsp");
					}
					
				}

				break;

			default:
				break;
			}

		}

	}

	/**
	 * 处理移动端的请求
	 */
	@Override
	protected void handleMobileRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter(Param.ACTION);
		String password = request.getParameter(Param.PASSWORD);
		String userName = request.getParameter(Param.USER_NAME);

		Map<String, String[]> params=request.getParameterMap();
		
		 for(Map.Entry<String, String[]> entry:params.entrySet()){  
	            String key = entry.getKey();  
	            String[] value = entry.getValue();  
	            
	            System.out.println(key+":"+value);  
	        }  
		 
		PrintWriter writer = response.getWriter();
		try {
			writer = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Response r = new Response();

		if (action != null) {
			switch (action) {
			// 登录
			case Action.LOGIN:
				if (userName != null && password != null) {
					User user = new User();
					user.setPassword(password);
					user.setUserName(userName);

					// 登录
					r = userService.login(user);

				}

				break;

			// 注册
			case Action.REGISTER:
				if (userName != null && password != null) {
					User user = new User();
					user.setPassword(password);
					user.setUserName(userName);

					// 注册
					r = userService.register(user);
				}

				break;

			default:
				break;
			}

			// 将消息返回
			if (r.getCode() != null) {

				writer.println(JSONParser.toJSONString(r));
				writer.close();
			}

		}
	}

}
