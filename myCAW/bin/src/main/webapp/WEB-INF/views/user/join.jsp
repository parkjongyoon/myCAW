<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ������</title>
</head>
<body>
			<form action="/register" method="post">
			<fieldset>
			<legend>ȸ������</legend>
			<ul>
				<li>
					<label for="userId">���̵�</label>
					<input type="text" name="userId" id="userId">
				</li>
				<li>
					<label for="userPwd">��й�ȣ</label>
					<input type="text" name="userPwd" id="userPwd">
				</li>
				<li>
					<label for="userName">ȸ����</label>
					<input type="text" name="userName" id="userName">
				</li>
			</ul>
			</fieldset>
			<input type="submit">
			</form>
</body>
</html>