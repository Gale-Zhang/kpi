<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>KPI</title>
<link href="/kpi/resources/css/homepage.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h1 style="font-size:40px" align="center">物理学院教师KPI查询系统</h1><br/><br/>
<div align="center">
	<form method="get" action="/kpi/view/teacherkpi">
		请输入老师工号：<input type="text" name="id"><input type="submit" name="Submit" value="查看详细信息">
	</form>
</div>
</body>
</html>