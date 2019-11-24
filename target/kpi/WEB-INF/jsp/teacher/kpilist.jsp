<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link href="/kpi/resources/css/mystyle.css" rel="stylesheet" type="text/css" />
<body align="center">
<p>
<h2 style="font-size:30px">KPI</h2><a href="/kpi">返回主页</a>
</p>
<form method="get" action="/kpi/teacher/detailkpi">
	请输入老师工号：<input type="text" name="name"><input type="submit" name="Submit" value="查看详细信息">
</form>
<table width="1000" align="center">
	<tr><th>工号</th><th>姓名</th><th>指导毕设</th><th>授课</th><th>项目</th><th>论文</th><th>专利</th><th>到账经费</th><th>其他</th><th>总计</th></tr>
	<c:forEach var="teacher" items="${list}" varStatus="loop">
	<tr>
		<td align="center">${teacher.teacherID}</td><td align="center">${teacher.name}</td>
		<td align="center">${kpi[loop.count - 1][0]}</td><td align="center">${kpi[loop.count - 1][1]}</td>
		<td align="center">${kpi[loop.count - 1][2]}</td><td align="center">${kpi[loop.count - 1][3]}</td>
		<td align="center">${kpi[loop.count - 1][4]}</td><td align="center">${kpi[loop.count - 1][5]}</td>
		<td align="center">${kpi[loop.count - 1][6]}</td><td align="center">${kpi[loop.count - 1][7]}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>
