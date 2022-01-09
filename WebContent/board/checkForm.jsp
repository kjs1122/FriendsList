<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/friends.css">
<script type="text/javascript" src="script/friends.js"></script>
</head>
<body>
<div align="center">
<form action="FriendsServlet" method="post" name="frm">
	<input type="hidden" name="command" value="success_check">
	<input type="hidden" name="name" value="${param.name}">
	<table>
		<tr><td colspan="2">이름을 입력해주세요</td></tr>		
		<tr>
			<th>이름</th>
			<td align="left">&nbsp;<input type="text" name="checkName"></td>
		</tr>
		
	</table>
	${message}
	<br><br><input type="submit" value="확인">&nbsp;
	<input type="reset" value="취소" onclick="win_close()"><br>

</form>
</div>
</body>
</html>