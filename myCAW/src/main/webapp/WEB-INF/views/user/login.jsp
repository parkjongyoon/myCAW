<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="/authenticate" method="post">
			<fieldset>
			<legend>로그인</legend>
			<ul>
				<li>
					<label for="username">아이디</label>
					<input type="text" name="username" id="username" value="ndarkness">
				</li>
				<li>
					<label for="password">비밀번호</label>
					<input type="text" name="password" id="password" value="1234">
				</li>
			</ul>
			</fieldset>
			<input type="submit">
	</form>
</body>
</html>