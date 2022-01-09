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
<form action="FriendsFileServlet" method="post" enctype="multipart/form-data" name="frm">
<input type="hidden" name="command" value="friends_update">
	<div id="wrap">
		<table>
			<tr>
				<td style="width: 300px; height: 300px;"><a href="#"><img
						alt="profile" src="upload/${friend.picture}"></a></td>
				<td>
					<table>
						<tr>
							<th>이름</th>
							<td align="left">&nbsp;<input type="text" name="name"
								value="${friend.name}"></td>
						</tr>
						<tr>
							<th>나이</th>
							<td align="left">&nbsp;<input type="text" name="age"
								value="${friend.age}"></td>
						</tr>
						<tr>
							<th>성별</th>
							<td align="left">&nbsp;<select name="gender">
									<option value="남">남자</option>
									<option value="여">여자</option>
							</select></td>
						</tr>
						<tr>
							<th>관계</th>
							<td align="left">&nbsp;<input type="text" name="relation"
								value="${friend.relation}"></td>
						</tr>
						<tr>
							<th>직업</th>
							<td align="left">&nbsp;<input type="text" name="job"
								value="${friend.job}"></td>
						</tr>
						<tr>
							<th>생일</th>
							<td align="left">&nbsp;<input type="date" name="birth"
								value="${friend.birth}"></td>
						</tr>
						<tr>
							<th>전화번호</th>
							<td align="left">&nbsp;<input type="text" name="phone"
								value="${friend.phone}"></td>
						</tr>
						<tr>
							<th>여친유무</th>
							<td colspan="2" align="left">
							<input type="radio"name="girlfriend" value="O" >있음
							<input type="radio"name="girlfriend" value="X" checked="checked" >없음
							</td>
						</tr>
						<tr>
							<th>사진</th>
							<td align="left">&nbsp;<input type="file" name="picture"></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<input type="submit" value="수정" onclick="return check()">
		<input type="button" value="목록"
			onclick="location.href='FriendsServlet?command=friends_list'">
	</div>
</form>
</body>
</html>