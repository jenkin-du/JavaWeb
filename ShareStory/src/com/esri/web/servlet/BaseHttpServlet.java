package com.esri.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.esri.constant.Param;
import com.esri.constant.Source;

/**
 * 基本Servlet，其余Servlet都要继承
 * 
 * @author DJS
 *
 */
public class BaseHttpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BaseHttpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		String source = request.getParameter(Param.SOURCE);
		if (source != null) {

			/**
			 * 处理移动端的访问
			 */
			if (source.equals(Source.MOBILE)) {

				handleMobileRequest(request, response);

				/**
				 * 处理网页版的访问
				 */
			} else if (source.equals(Source.WEB)) {

				handleWebRequest(request, response);
			}
		}
	}

	/**
	 * 处理来自网页版的请求
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	protected void handleWebRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * 处理来自移动端的请求
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	protected void handleMobileRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	
	
}
