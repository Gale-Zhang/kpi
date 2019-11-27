<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link href="/kpi/resources/css/mystyle.css" rel="stylesheet" type="text/css" />
<body align="center">
<p>
<br>
<br>
<h2 style="font-size:30px">邀请报告信息</h2>
<br>
<br>
<form method="get" action="/kpi/report/add">
	<p>
		类型<input type="radio" name="type" value="国际">国际<input type="radio" name="type" value="国内">国内<br/>
		教师ID<input type="text" name="teacherID"><br/>
		kpi值<input type="text" name="kpi"><br/>
	</p>
	<p>
		<input type="submit" name="Submit" value="提交">
	</p>
</form>
<br>
<br>
<a href="/kpi/manage.html">返回主页</a>
</p>

</body>
</html>
