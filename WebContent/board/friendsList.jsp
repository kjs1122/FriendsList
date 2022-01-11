<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	int startPage = (Integer)(request.getAttribute("startPage"));
	int endPage = (Integer)(request.getAttribute("endPage"));
	int maxPage = (Integer)(request.getAttribute("maxPage"));
	int nowPage = (Integer)(request.getAttribute("nowPage"));

%>
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
	<tr align="center" height="20">
		<td colspan="7" >
				<%if(nowPage <= 1) {%>
				[이전]&nbsp;
			<%} else { %>		
				<a href="/FriendsServlet?command=friends_list&page=<%= nowPage - 1%>">[이전]</a>&nbsp;
			<%} %>
			<%for(int a = startPage; a <= endPage; a++ ) 
				if(a == nowPage) {
			%>
				[<%=a%>]
				<%} else { %>		
				<a href="/FriendsServlet?command=friends_list&page=<%= a%>">[<%=a%>]</a>&nbsp;	
				<%} %>
			<%if(nowPage>=maxPage) {%>		
				[다음]				
			<%} else { %>
				<a href="/FriendsServlet?command=friends_list&page=<%= nowPage + 1%>">[다음]</a>
			<%} %>
	
		</td>
	</tr>
	
</table>
</div>
</body>
</html>