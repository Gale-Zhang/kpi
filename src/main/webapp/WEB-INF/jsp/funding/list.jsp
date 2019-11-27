<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link href="/kpi/resources/css/mystyle.css" rel="stylesheet" type="text/css" />
<body align="center">
<h2 style="font-size:30px">经费信息</h2>
<a href="/kpi/manage.html">返回主页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="addfunding">增加</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="deletefunding">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<!-- <a href="findfunding">查找(待完成)</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="modifyfunding">修改(待完成)</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; --><br/><br/>
<table width="1000" align="center">
	<tr>
		<th>经费ID</th><th>教师ID</th><th>经费数目</th><th>经费类型</th>
	</tr>
	<c:forEach var="funding" items="${list}">
	<tr>
		<td align="center">${funding.fundingID}</td><td align="center">${funding.teacherID}</td>
		<td align="center">${funding.number}</td><td align="center">${funding.type}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>
