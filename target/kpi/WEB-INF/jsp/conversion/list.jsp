<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link href="/kpi/resources/css/mystyle.css" rel="stylesheet" type="text/css" />
<body align="center">
<h2 style="font-size:30px">折算信息</h2>
<a href="/kpi/manage.html">返回主页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="addconversion">增加</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="deleteconversion">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<!-- <a href="findconversion">查找(待完成)</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="modifyconversion">修改(待完成)</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; --><br/><br/>
<table width="1000" align="center">
	<tr>
		<th>ID</th><th>教师ID</th><th>类型</th><th>kpi值</th>
	</tr>
	<c:forEach var="conversion" items="${list}">
	<tr>
		<td align="center">${conversion.conversionID}</td><td align="center">${conversion.teacherID}</td>
		<td align="center">${conversion.type}</td><td align="center">${conversion.kpi}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>
