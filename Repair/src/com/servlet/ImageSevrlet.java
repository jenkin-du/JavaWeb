package com.servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.DAO;

/**
 * Servlet implementation class ImageSevrlet
 */

public class ImageSevrlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ImageSevrlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String param = request.getParameter("upload");
		String imageName = request.getParameter("imageName");
		String order = request.getParameter("order");

		System.out.println("order=" + order);
		if (param != null && imageName != null && order != null && param.equals("image")) {

			//receiveImage(request, imageName, order);
		//	DAO.saveImagePath(order, imageName);
			InputStream in=request.getInputStream();
			int size=request.getContentLength();
		    DAO.saveImage(order, imageName, request,size);
		
		
			
			System.out.println("size="+size);
			
			PrintWriter out = response.getWriter();
			out.print(true);
			out.flush();
		} else {
			PrintWriter out = response.getWriter();
			out.print(false);
			out.flush();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

		
	}

	/**
	 * 接受上传的图片
	 * 
	 * @param request
	 * @param imageName
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private void receiveImage(HttpServletRequest request, String imageName, String order) {
		InputStream in;
		try {
			in = request.getInputStream();

			int size = request.getContentLength();

			byte[] result = new byte[size]; // 结果

			char ch;
			int i = 0;

			while (i < size) {
				ch = (char) in.read();
				result[i] = (byte) ch;
				i++;
			}

			in.close();

			@SuppressWarnings("deprecation")
			String folder=request.getRealPath("imgs");
			
			File fileFolder = new File(folder+"\\" + order);
			
			System.out.println(folder+"\\" + order);
			
			fileFolder.mkdir();

			String filePath = folder+"\\" + order + "\\" + imageName;
			File file = new File(filePath);
			FileOutputStream fos = new FileOutputStream(file);

			fos.write(result);

			fos.flush();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
