<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원가입</title>
</head>
<body>
			<form action="/register" method="post">
			<fieldset>
			<legend>회원가입</legend>
			<ul>
				<li>
					<label for="user_id">아이디</label>
					<input type="text" name="user_id" id="user_id">
				</li>
				<li>
					<label for="user_pwd">비밀번호</label>
					<input type="text" name="user_pwd" id="user_pwd">
				</li>
				<li>
					<label for="user_name">회원명</label>
					<input type="text" name="user_name" id="user_name">
				</li>
			</ul>
			</fieldset>
			<input type="submit">
			</form>
</body>
</html>