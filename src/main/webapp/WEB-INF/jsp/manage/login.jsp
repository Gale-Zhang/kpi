<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录界面</title>
<link href="/kpi/resources/css/mystyle.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div align="center">
	<h1>欢迎登陆</h1><br><br><br><br><br><br><br>
	<form method="get" action="/kpi/manage/verification">
		<p>请输入密码<br><br><br>
			<input type="text" name="password">
			<input type="submit" name="Submit" value="提交">
		</p>
	</form><br><br><br><br><br><br>
	<a href="/kpi">返回主页</a>
</div>
</body>
</html>