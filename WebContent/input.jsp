<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>입력</title>
</head>
<body>
	<form action="inputCheck.jsp" method="post">
		<table border="1">
			<tr>
				<td>
					<label>이름</label>
					<input type="text" name="name" />
				</td>
			</tr>	 
			<tr>  
				<td>
					<label>나이</label>
					<input type="text" name="age" />
				</td>
			</tr>
			<tr>
				<td align="center">
					<input type="submit" value="전송" />
				</td>
			</tr>
		</table>
	</form>	
</body>
</html>