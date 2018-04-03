package com.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.DAO;
import com.google.gson.Gson;

import entry.RepairRecord;

/**
 * Servlet implementation class RepairServlet
 */
public class RepairServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RepairServlet() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean success=false;
		PrintWriter out=response.getWriter();
		request.setCharacterEncoding("utf-8");
		
		ServletInputStream instream=request.getInputStream();
		if(instream!=null){
			
			BufferedReader reader=new BufferedReader(new InputStreamReader(instream));
			String temp;
			String data = "";
			while((temp=reader.readLine())!=null){
				data+=temp;
			}
			
			Gson gson=new Gson();
			
			RepairRecord record=gson.fromJson(data, RepairRecord.class);
			success=	DAO.repair(record);
			System.out.println(success);
			out.print(success);
			
		}else{
			
			out.print(success);
		}
	}
}
