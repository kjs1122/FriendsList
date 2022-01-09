<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>친구 등록</title>
<link rel="stylesheet" type="text/css" href="css/friends.css">
<script type="text/javascript" src="script/friends.js"></script>
</head>
<body>
	<div id="wrap">
		<form action="FriendsFileServlet" method="post"
			enctype="multipart/form-data" name="frm">
			<input type="hidden" name="command" value="friends_insert">

			<table>
				<tr>
					<th>이름</th>
					<td align="left">&nbsp;<input type="text" name="name" size="10"></td>
				</tr>
				<tr>
					<th>나이</th>
					<td align="left">&nbsp;<input type="text" name="age" size="2"
						maxlength="2"></td>
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
					<td align="left">&nbsp;<input type="text" name="relation" size="10"></td>
				</tr>
				<tr>
					<th>직업</th>
					<td align="left">&nbsp;<input type="text" name="job" size="10"></td>
				</tr>
				<tr>
					<th>생일</th>
					<td align="left">&nbsp;<input type="date" name="birth"
						value="1992-11-22"></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td align="left">&nbsp;<input type="text" name="phone" size="10"></td>
				</tr>
				<tr>
					<th>사진</th>
					<td align="left"><input type="file" name="picture"></td>
				</tr>
				<tr>
					<th>여친유무</th>
					<td colspan="2" align="left">&nbsp;<input type="radio"
						name="girlfriend" value="O">있음 <input type="radio"
						name="girlfriend" value="X" checked="checked">없음</td>
				</tr>
			</table>

			<input type="submit" value="등록" onclick="return check()">&nbsp;
			<input type="reset" value="다시작성">&nbsp;
			<input type="button" value="목록" onclick="location.href='FriendsServlet?command=friends_list'">
		</form>
	</div>
</body>
</html>