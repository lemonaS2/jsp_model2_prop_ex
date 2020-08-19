<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="org.smart.bean.GuestBook" %>    
<!DOCTYPE html>
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>main.jsp</title>
</head>
<body>
 	<form action="write.do" method="post">
 		<input type="text" name="content" />
 		<input type="submit" value="글쓰기" />
 		<input type="reset" value="취소" />
 	</form>
 	<hr/>
 	<table>
 		<tr>
 			<th>번호</th>
 			<th>내용</th>
 			<th>작성일</th>
 		</tr>
 		<%
 			GuestBook[] books = (GuestBook[])request.getAttribute("books");
 			if(books.length == 0){
 		%>
 		<tr>
 			<td colspan="3">Empty</td>
 		</tr>
 		<%
 			}else{
				for(GuestBook book : books){ 				
 		%>
 		<tr>
 			<td><%=book.getGid() %></td>
 			<td><%=book.getContent() %></td>
 			<td><%=book.getReg() %></td>
 		</tr>
 		<%
				}
 			}
 		%>
 	</table>
</body>
</html>