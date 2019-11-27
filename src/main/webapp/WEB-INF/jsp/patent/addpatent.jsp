<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add patent</title>
<link href="/kpi/resources/css/mystyle.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div align="center">
	<form method="get" action="/kpi/patent/add">
		<p>
			教师ID<input type="text" name="teacherID"><br>
			专利名称<input type="text" name="name"><br>
			申请时间(格式2000-1-1)<input type="text" name="time"><br>
		</p>
		<p>
			状态
			<input type="radio" name="state" value="申请">申请
			<input type="radio" name="state" value="授权">授权<br>
		</p>
		<p>
			专利类型
			<input type="radio" name="type" value="true" >国际
			<input type="radio" name="type" value="false" checked>国内<br>
		</p>
		<p>
			<input type="submit" name="Submit" value="提交">
		</p>
	</form>
</div>
</body>
</html>