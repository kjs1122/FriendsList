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
	<div id="wrap">
		<table>
			<tr>
				<td style="width: 300px; height: 300px;"><a href="FriendsServlet?command=file_download&file_name=${friend.picture}"><img alt="profile"
						src="upload/${friend.picture}"></a></td>
				<td>
					<table>
						<tr>
							<th>이름</th>
							<td align="left">&nbsp;${friend.name}</td>
						</tr>
						<tr>
							<th>나이</th>
							<td align="left">&nbsp;${friend.age}</td>
						</tr>
						<tr>
							<th>성별</th>
							<td align="left">&nbsp;${friend.gender}</td>
						</tr>
						<tr>
							<th>관계</th>
							<td align="left">&nbsp;${friend.relation}</td>
						</tr>
						<tr>
							<th>직업</th>
							<td align="left">&nbsp;${friend.job}</td>
						</tr>
						<tr>
							<th>생일</th>
							<td align="left">&nbsp;${friend.birth}</td>
						</tr>
						<tr>
							<th>전화번호</th>
							<td align="left">&nbsp;${friend.phone}</td>
						</tr>
						<tr>
							<th>여자친구</th>
							<td align="left">&nbsp;${friend.girlfriend}</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<input type="button" value="수정" onclick="win_open('FriendsServlet?command=check_form&name=${friend.name}','update')">&nbsp;
		<input type="button" value="삭제" onclick="win_open('FriendsServlet?command=check_form&name=${friend.name}','delete')">&nbsp;
		<input type="button" value="목록" onclick="location.href='FriendsServlet?command=friends_list'">
	</div>
</body>
</html>