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
					<label for="userId">아이디</label>
					<input type="text" name="userId" id="userId">
				</li>
				<li>
					<label for="userPwd">비밀번호</label>
					<input type="text" name="userPwd" id="userPwd">
				</li>
				<li>
					<label for="userName">회원명</label>
					<input type="text" name="userName" id="userName">
				</li>
			</ul>
			</fieldset>
			<input type="submit">
			</form>
</body>
</html>