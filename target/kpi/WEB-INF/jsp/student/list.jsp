<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link href="/kpi/resources/css/mystyle.css" rel="stylesheet" type="text/css" />
<body align="center">
<h2 style="font-size:30px">学生信息</h2>
<a href="/kpi">返回主页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="addstudent">增加</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="deletestudent">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<!-- <a href="findstudent">查找(待完成)</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="modifystudent">修改(待完成)</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; --><br/><br/>
<table width="1000" align="center">
	<tr>
		<th>学生ID</th><th>教师ID</th><th>学生姓名</th><th>学生类型</th><th>研究课题</th>
	</tr>
	<c:forEach var="student" items="${list}">
	<tr>
		<td align="center">${student.studentID}</td><td align="center">${student.teacherID}</td>
		<td align="center">${student.name}</td><td align="center">${student.type}</td>
		<td align="center">${student.task}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>
