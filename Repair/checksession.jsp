
<%@ page language="java" contentType="text/html"  pageEncoding="UTF-8" %>
<%
if(session.getAttribute("userName")==null){
//�û�û�е�½
response.sendRedirect("index.html");}
%>