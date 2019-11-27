<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加一位教师</title>
<link href="/kpi/resources/css/mystyle.css" rel="stylesheet" type="text/css" />
</head>
<body bgcolor="#FFFFFF">
<div align="center">
	<form method="get" action="/kpi/teacher/add">
		<p>
			教师姓名<input type="text" name="name"><br>
		</p>
		<p>
			<input type="submit" name="Submit" value="提交">
		</p>
	</form>
</div>
</body>
</html>