<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add funding</title>
<link href="/kpi/resources/css/mystyle.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div align="center">
	<form method="get" action="/kpi/funding/add">
		<p>
			教师ID<input type="text" name="teacherID"><br>
			经费数目<input type="text" name="number"><br>
		</p>
		<p>
			经费类型
			<input type="radio" name="type" value="纵向">纵向
			<input type="radio" name="type" value="横向">横向
			<br>
		</p>
		<p>
			<input type="submit" name="Submit" value="提交">
		</p>
	</form>
</div>
</body>
</html>