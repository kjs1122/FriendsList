<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>친구명단</title>	
<link rel="stylesheet" type="text/css" href="css/friends.css">
</head>
<body>
<div id="wrap">
<a href="FriendsServlet?command=friends_insert_form" style="float: right">친구등록</a>
<table>
	<tr>
		<th>이름</th><th>나이</th><th>성별</th><th>직업</th><th>생일</th><th>전화번호</th><th>여자친구</th>
	</tr>
	<c:forEach var="friend" items="${friendsList}">
	<tr>
		<td><a href="FriendsServlet?command=friends_view&name=${friend.name}">${friend.name}</a></td>
		<td>${friend.age}</td>
		<td>${friend.gender}</td>
		<td>${friend.job}</td>
		<td>${friend.birth}</td>
		<td>${friend.phone}</td>
		<td>${friend.girlfriend}</td>
	</tr>
	</c:forEach>
</table>
</div>
</body>
</html>