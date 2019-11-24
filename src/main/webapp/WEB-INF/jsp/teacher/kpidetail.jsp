<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link href="/kpi/resources/css/mystyle.css" rel="stylesheet" type="text/css" />
<body align="center">
<h2 style="font-size:30px">KPI详细信息</h2>
<a href="/kpi">返回主页</a><br/><br/>
<table width="90%" align="center">
	<c:forEach var="str" items="${list}">
	<tr><td align="center">${str}</td></tr>
	</c:forEach>
</table>
</body>
</html>
