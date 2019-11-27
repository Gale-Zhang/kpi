<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add paper</title>
<link href="/kpi/resources/css/mystyle.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div align="center">
	<form method="get" action="/kpi/paper/add">
		<p>
			教师ID<input type="text" name="teacherID"><br>
			论文名称<input type="text" name="name"><br>
			期刊<input type="text" name="book"><br>
			卷号<input type="text" name="number"><br>
			页码<input type="text" name="page"><br>
			年份<input type="text" name="time"><br>
		</p>
		<p>
			类型
			<input type="radio" name="type" value="科研">科研
			<input type="radio" name="type" value="教研">教研
			<br>
		</p>
		<p>
			档次
			<input type="radio" name="level" value="顶级">顶级
			<input type="radio" name="level" value="一流">一流
			<input type="radio" name="level" value="一般">一般
			<br>
		</p>
		<p>
			<input type="submit" name="Submit" value="提交">
		</p>
	</form>
</div>
</body>
</html>