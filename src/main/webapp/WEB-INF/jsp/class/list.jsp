<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link href="/kpi/resources/css/mystyle.css" rel="stylesheet" type="text/css" />
<body align="center">
<h2 style="font-size:30px">课程信息</h2>
<a href="/kpi">返回主页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="addclass">增加</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="deleteclass">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<!-- <a href="findclass">查找(待完成)</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="modifyclass">修改(待完成)</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; --><br/><br/>
<table width="1000" align="center">
	<tr>
		<th>课程ID</th><th>教师ID</th><th>课程名称</th><th>理论课时</th>
		<th>实验课时</th><th>上机课时</th><th>学生人数</th><th>调课次数</th><th>英文授课</th>
	</tr>
	<c:forEach var="_class" items="${list}">
	<tr>
		<td align="center">${_class.classID}</td><td align="center">${_class.classID}</td>
		<td align="center">${_class.name}</td><td align="center">${_class.theoryduration}</td>
		<td align="center">${_class.experimentduration}</td><td align="center">${_class.computerduration}</td>
		<td align="center">${_class.studentnumber}</td><td align="center">${_class.adjustmentnumber}</td>
		<td align="center">${_class.isEnglish}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>
