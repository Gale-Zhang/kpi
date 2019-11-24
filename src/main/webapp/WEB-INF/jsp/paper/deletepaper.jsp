<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link href="/kpi/resources/css/mystyle.css" rel="stylesheet" type="text/css" />
<head>
<meta charset="UTF-8">
<title>Delete Student</title>
</head>
<body>
<div align="center">
	<form method="get" action="/kpi/paper/delete">
		<p>
			请输入要删除的论文ID<input type="text" name="ID"><br>
		</p>
		<p>
			<input type="submit" name="Submit" value="提交">
		</p>
	</form>
</div>
</body>
</html>