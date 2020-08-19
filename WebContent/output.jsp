<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String name = (String)session.getAttribute("name");
	String age = (String)session.getAttribute("age");
		
%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>출력</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>
				<label>이름: </label>
				<%=name %>
			</td>
		</tr>
		<tr>
			<td>
				<label>나이: </label>
					<%=age %>
			</td>
		</tr>
	</table>
</body>
</html>