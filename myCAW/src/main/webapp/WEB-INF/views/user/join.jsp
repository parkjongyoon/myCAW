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
					<label for="user_id">���̵�</label>
					<input type="text" name="user_id" id="user_id">
				</li>
				<li>
					<label for="user_pwd">��й�ȣ</label>
					<input type="text" name="user_pwd" id="user_pwd">
				</li>
				<li>
					<label for="user_name">ȸ����</label>
					<input type="text" name="user_name" id="user_name">
				</li>
			</ul>
			</fieldset>
			<input type="submit">
			</form>
</body>
</html>