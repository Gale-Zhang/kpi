<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/kpi/resources/css/mystyle.css" rel="stylesheet" type="text/css" />
<title>add class</title>
</head>
<body>
<div align="center">
	<form method="get" action="/kpi/class/add">
		<p>
			授课教师ID<input type="text" name="teacherID"><br>
			课程名称<input type="text" name="name"><br>
			理论课时<input type="text" name="tduration"><br>
			实验课时<input type="text" name="eduration"><br>
			上机课时<input type="text" name="cduration"><br>
			学生人数<input type="text" name="studentnumber"><br>
			调课次数<input type="text" name="adjustmentnumber"><br>
		</p>
		<p>是否为英文授课
			<input type="radio" name="isEnglish" value="false" checked>否
			<input type="radio" name="isEnglish" value="true">是<br>
		</p>
		<p>
			<input type="submit" name="Submit" value="提交">
		</p>
	</form>
</div>
</body>
</html>