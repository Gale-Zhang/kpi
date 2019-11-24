<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link href="/kpi/resources/css/mystyle.css" rel="stylesheet" type="text/css" />
<body align="center">
<h2 style="font-size:30px">其他贡献</h2>
<a href="/kpi">返回主页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="addother">增加</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="deleteother">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<!-- <a href="findother">查找(待完成)</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="modifyother">修改(待完成)</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; --><br/><br/>
<table width="1000" align="center">
	<tr>
		<th>ID</th><th>教师ID</th><th>详细信息</th><th>kpi值</th>
	</tr>
	<c:forEach var="other" items="${list}">
	<tr>
		<td align="center">${other.otherID}</td><td align="center">${other.teacherID}</td>
		<td align="center">${other.message}</td><td align="center">${other.kpi}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>
