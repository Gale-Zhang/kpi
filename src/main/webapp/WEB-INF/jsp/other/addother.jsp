<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link href="/kpi/resources/css/mystyle.css" rel="stylesheet" type="text/css" />
<body align="center">
<p>
<br>
<br>
<h2 style="font-size:30px">如果有其他类型的绩效贡献，请在此录入</h2>
<br>
<br>
<form method="get" action="/kpi/other/add">
	<p>
		详细信息<textarea name="message" style="width:500px;height:200px;">请输入内容</textarea><br><br><br>
		教师ID<input type="text" name="teacherID">
		kpi值<input type="text" name="kpi">
	</p>
	<p>
		<input type="submit" name="Submit" value="提交">
	</p>
</form>
<br>
<br>
<a href="/kpi">返回主页</a>
</p>

</body>
</html>
