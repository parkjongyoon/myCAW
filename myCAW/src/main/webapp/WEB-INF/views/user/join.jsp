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
					<input type="text" name="userId" id="user_id">
				</li>
				<li>
					<label for="user_pwd">비밀번호</label>
					<input type="text" name="userPwd" id="user_pwd">
				</li>
				<li>
					<label for="user_name">회원명</label>
					<input type="text" name="userName" id="user_name">
				</li>
				<li>
					<label for="user_authority">권한</label>
					<select name="role" id="user_authority">
					<option value="ROLE_ADMIN">ROLE_MASTER</option>
					<option value="ROLE_USER">ROLE_USER</option>
					</select>
				</li>
			</ul>
			</fieldset>
			<input type="submit">
			</form>
</body>
</html>