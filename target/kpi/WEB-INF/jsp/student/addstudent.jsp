<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add student</title>
<link href="/kpi/resources/css/mystyle.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div align="center">
	<form method="get" action="/kpi/student/add">
		<p>
			教师ID<input type="text" name="teacherID"><br>
			学生姓名<input type="text" name="name"><br>
			研究课题<input type="text" name="task"><br>
		</p>
		<p>
			学生类型
			<input type="radio" name="type" value="博士生" >博士生
			<input type="radio" name="type" value="硕士生" >硕士生
			<input type="radio" name="type" value="本科生" checked>本科生<br>
		</p>
		<p>
			<input type="submit" name="Submit" value="提交">
		</p>
	</form>
</div>
</body>
</html>