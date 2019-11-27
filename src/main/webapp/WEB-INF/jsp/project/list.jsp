<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link href="/kpi/resources/css/mystyle.css" rel="stylesheet" type="text/css" />
<body align="center">
<h2 style="font-size:30px">项目信息</h2>
<a href="/kpi/manage.html">返回主页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="addproject">增加</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="deleteproject">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<!-- <a href="findproject">查找(待完成)</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="modifyproject">修改(待完成)</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; --><br/><br/>
<table width="1000" align="center">
	<tr>
		<th>项目ID</th><th>教师ID</th><th>项目名称</th><th>项目类型</th>
		<th>资金</th><th>开始时间</th><th>结束时间</th>
	</tr>
	<c:forEach var="project" items="${list}">
	<tr>
		<td align="center">${project.projectID}</td><td align="center">${project.teacherID}</td>
		<td align="center">${project.name}</td><td align="center">${project.types}</td>
		<td align="center">${project.funding}</td><td align="center">${project.start}</td>
		<td align="center">${project.end}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>
