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
			<legend>�α���</legend>
			<ul>
				<li>
					<label for="username">���̵�</label>
					<input type="text" name="username" id="username" value="ndarkness">
				</li>
				<li>
					<label for="password">��й�ȣ</label>
					<input type="text" name="password" id="password" value="1234">
				</li>
			</ul>
			</fieldset>
			<input type="submit">
	</form>
</body>
</html>