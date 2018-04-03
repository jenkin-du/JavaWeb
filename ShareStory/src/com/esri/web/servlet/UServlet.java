package com.esri.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.esri.bean.Response;
import com.esri.bean.User;
import com.esri.constant.*;
import com.esri.service.UserService;
import com.esri.utils.JSONParser;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UServlet")
public class UServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter writer = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		String source = request.getParameter(Param.SOURCE);

		UserService userService = new UserService();

		if (source != null) {

			/**
			 * 处理移动端的访问
			 */
			if (source.equals(Source.MOBILE)) {
				System.out.println("mobile");
				
				String action = request.getParameter(Param.ACTION);
				String password = request.getParameter(Param.PASSWORD);
				String userName = request.getParameter(Param.USER_NAME);

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
					writer.println(JSONParser.toJSONString(r));
					writer.close();
				}

			/**
			 * 处理网页版的访问
			 */
			} else if (source.equals(Source.WEB)) {

				System.out.println("web");
				String action = request.getParameter(Param.ACTION);
				String password = request.getParameter(Param.PASSWORD);
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

						
							//r = userService.login(user);
							//重定向
							
							/*response.sendRedirect("jsp/main.jsp?username="+userName);*/
							if(false){
								response.sendRedirect("jsp/main.jsp");
							}else{
								response.sendRedirect("index.html");
							}
							

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

				}
			}

		}

	}
}
