<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("euc_kr");

	String name = request.getParameter("name");	
	String age = request.getParameter("age");
	
	session.setAttribute("name", name);
	session.setAttribute("age", age);
	
	response.sendRedirect("output.jsp");
	
// 	RequestDispatcher rd = request.getRequestDispatcher("output.jsp");
// 	rd.forward(request, response);
	
%>

  