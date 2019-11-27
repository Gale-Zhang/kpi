<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link href="/kpi/resources/css/mystyle.css" rel="stylesheet" type="text/css" />
<body align="center">
<h2 style="font-size:30px">论文信息</h2>
<a href="/kpi/manage.html">返回主页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="addpaper">增加</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="deletepaper">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<!-- <a href="findpaper">查找(待完成)</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="modifypaper">修改(待完成)</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; --><br/><br/>
<table width="1000" align="center">
	<tr>
		<th>论文ID</th><th>教师ID</th><th>论文名</th><th>期刊</th><th>卷号</th><th>页码</th>
		<th>年份</th><th>类型</th><th>档次</th>
	</tr>
	<c:forEach var="paper" items="${list}">
	<tr>
		<td align="center">${paper.paperID}</td><td align="center">${paper.teacherID}</td>
		<td align="center">${paper.name}</td><td align="center">${paper.book}</td>
		<td align="center">${paper.number}</td><td align="center">${paper.page}</td>
		<td align="center">${paper.time}</td><td align="center">${paper.type}</td>
		<td align="center">${paper.level}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>
