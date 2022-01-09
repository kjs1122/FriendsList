<%@page import="controller.action.FriendsListAction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>`
<%
	response.sendRedirect("FriendsServlet?command=friends_list");

%>
</body>
</html>