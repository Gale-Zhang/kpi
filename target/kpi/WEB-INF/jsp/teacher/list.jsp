<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link href="/kpi/resources/css/mystyle.css" rel="stylesheet" type="text/css" />
<body align="center">
<h2 style="font-size:30px">教师名单</h2>
<a href="/kpi/manage.html">返回主页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="addteacher">增加</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="deleteteacher">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<!-- <a href="findteacher">查找(待完成)</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="modifyteacher">修改(待完成)</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; --><br/><br/>
<table width="300" align="center">
	<tr><th>工号</th><th>姓名</th></tr>
	<c:forEach var="teacher" items="${list}">
	<tr><td align="center">${teacher.teacherID}</td><td align="center">${teacher.name}</td></tr>
	</c:forEach>
</table>
</body>
</html>
