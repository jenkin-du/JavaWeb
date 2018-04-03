package com.esri.web.servlet;

import java.io.IOException; 
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.esri.utils.JSONParser;
import com.esri.bean.SharedStory;
import com.esri.dao.StoryDao;

/**
 * Servlet implementation class StoryS
 */
@WebServlet("/StoryS")
public class StoryS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StoryS() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		String action = request.getParameter("action");
		String jsonStory = request.getParameter("story");
		String josnPoint = request.getParameter("locationPoint");
		String radius = request.getParameter("radius");

		if (action != null) {
			switch (action) {
			case "sendStory":
				if (jsonStory != null) {

					SharedStory story = JSONParser.toJavaBean(jsonStory, SharedStory.class);
					StoryDao.saveStory(story);

					System.out.println("sendStory");
				}

				break;
			case "getStory":

				// TODO 根据中心点和半径查找

				ArrayList<SharedStory> stories = StoryDao.getStory(null, 0);
				String jsonStories=JSONParser.toJSONString(stories);
				
				out.println(jsonStories);
				System.out.println("getStory");
				break;
			default:
				break;
			}
		}

		out.close();
	}

}
