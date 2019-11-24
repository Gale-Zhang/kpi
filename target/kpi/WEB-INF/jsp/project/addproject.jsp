<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add project</title>
<link href="/kpi/resources/css/mystyle.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div align="center">
	<form method="get" action="/kpi/project/add">
		<p>
			项目ID<input type="text" name="projectID"><br>
			教师ID<input type="text" name="teacherID"><br>
			项目名称<input type="text" name="name"><br>
			项目类型<input type="text" name="types"><br>
			资金<input type="text" name="funding"><br>
			开始时间(格式:2018-1-1)<input type="text" name="start"><br>
			结束时间(格式:2018-1-1)<input type="text" name="end"><br>
		</p>
		<p>
			<input type="submit" name="Submit" value="提交">
		</p>
	</form>
</div>
</body>
</html>