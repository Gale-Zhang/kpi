<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link href="/kpi/resources/css/mystyle.css" rel="stylesheet" type="text/css" />
<body align="center">
<p>
<br>
<br>
<h2 style="font-size:30px">折算信息</h2>
<br>
<br>
<form method="get" action="/kpi/conversion/add">
	<p>
		类型<input type="radio" name="type" value="实验室">实验室<input type="radio" name="type" value="培训研究">培训研究<input type="radio" name="type" value="行政">行政<br/>
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
