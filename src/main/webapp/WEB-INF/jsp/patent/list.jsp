<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link href="/kpi/resources/css/mystyle.css" rel="stylesheet" type="text/css" />
<body align="center">
<h2 style="font-size:30px">专利信息</h2>
<a href="/kpi">返回主页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="addpatent">增加</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="deletepatent">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<!-- <a href="findpatent">查找(待完成)</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="modifypatent">修改(待完成)</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; --><br/><br/>
<table width="1000" align="center">
	<tr>
		<th>专利ID</th><th>教师ID</th><th>专利名称</th><th>专利状态</th><th>时间</th><th>是否为国际专利</th>
	</tr>
	<c:forEach var="patent" items="${list}">
	<tr>
		<td align="center">${patent.paperID}</td><td align="center">${patent.teacherID}</td>
		<td align="center">${patent.name}</td><td align="center">${patent.state}</td>
		<td align="center">${patent.time}</td><td align="center">${patent.isInter}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>
