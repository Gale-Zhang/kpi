<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>详细信息</title>
<link href="/kpi/resources/css/show.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div align="center" class="title">
	<h2 style="font-size:25px">教师姓名：${teacher.name}，工号：${teacher.teacherID}，KPI总计：<fmt:formatNumber type="number" value="${all[0] + all[1]}" pattern="0.00" maxFractionDigits="2"/>
	</h2>
	<a href="/kpi/index.jsp">返回主页</a>
</div>
<hr style=" height:2px;border:none;border-top:2px dotted #185598;" /> 
<br>
<div align="center" class="教研和科研" width="1000px">	
	<h2 style="font-size:30px">教研和科研</h2>
	<table>
		<caption>经费</caption>	
		<tr>
			<th>经费序号</th><th>经费数目（万元）</th><th>经费类型</th><th>KPI</th>
		</tr>
		<c:forEach var="funding" items="${fundings}" varStatus="loop">
		<tr>
			<td align="center">${funding.fundingID}</td>
			<td align="center">${funding.number}</td><td align="center">${funding.type}</td>
			<td align="center">${fundingkpi[loop.count - 1]}</td>
		</tr>
		</c:forEach>
		<tr><td  align="center">总计</td><td></td><td></td><td align="center">${fundingkpi[fundingkpi.size() - 1]}</td>
	</table> 
	<br/>
	<table>
		<caption>科研</caption>
		<tr>
			<th>项目序号</th><th width="40%">项目名称</th><th>项目类型</th>
			<th>经费(万元)</th><th>开始时间</th><th>结束时间</th><th>KPI</th>
		</tr>
		<c:forEach var="project" items="${projects}" varStatus="loop">
		<tr>
			<td align="center">${project.projectID}</td>
			<td align="center">${project.name}</td><td align="center">${project.types}</td>
			<td align="center">${project.funding}</td><td align="center">${project.start}</td>
			<td align="center">${project.end}</td><td align="center">${projectkpi[loop.count - 1]}</td>
		</tr>
		</c:forEach>
		<tr><td align="center">总计</td><td></td><td></td><td></td><td></td><td></td><td align="center">${projectkpi[projectkpi.size() - 1]}</td>
	</table> 
	<br/>
	<table>
		<caption>科研和教研论文</caption>	
		<tr>
			<th>论文序号</th><th width="40%">论文名</th><th>期刊</th>
			<th>年份</th><th>类型</th><th>档次</th><th>KPI</th>
		</tr>
		<c:forEach var="paper" items="${papers}" varStatus="loop">
		<tr>
			<td align="center">${paper.paperID}</td>
			<td align="center">${paper.name}</td><td align="center">${paper.book}</td>
			<td align="center">${fn:substring(paper.time, 0, 4)}</td><td align="center">${paper.type}</td>
			<td align="center">${paper.level}</td><td align="center">${paperkpi[loop.count - 1]}</td>
		</tr>
		</c:forEach>
		<tr><td align="center">总计</td><td></td><td></td><td></td><td></td><td></td><td align="center">${paperkpi[paperkpi.size() - 1]}</td>
	</table> 
	<br/>
	<table>
		<caption>专著</caption>	
		<tr><th>类型</th><th width="50%">详细信息</th><th>KPI</th></tr>
		<tr><td align="center">总计</td><td></td><td align="center">0</td>
	</table> 
	<br/>
	<table>
		<caption>教材</caption>	
		<tr><th>类型</th><th width="50%">详细信息</th><th>KPI</th></tr>
		<tr><td align="center">总计</td><td></td><td align="center">0</td>
	</table> 
	<br/>
	<table>
		<caption>发明专利</caption>	
		<tr>
			<th>专利序号</th><th width="40%">专利名称</th><th>专利状态</th><th>时间</th><th>是否为国际专利</th><th>KPI</th>
		</tr>
		<c:forEach var="patent" items="${patents}" varStatus="loop">
		<tr>
			<td align="center">${patent.paperID}</td>
			<td align="center">${patent.name}</td><td align="center">${patent.state}</td>
			<td align="center">${patent.time}</td><td align="center">${patent.isInter}</td>
			<td align="center">${patentkpi[loop.count - 1]}</td>
		</tr>
		</c:forEach>
		<tr><td align="center">总计</td><td></td><td></td><td></td><td></td><td align="center">${patentkpi[patentkpi.size() - 1]}</td>
	</table> 
	<br/>
	<table>
		<caption>奖项</caption>	
		<tr><th>类型</th><th width="50%">详细信息</th><th>KPI</th></tr>
		<tr><td align="center">总计</td><td></td><td align="center">0</td>
	</table> 
	<br/>
	<table>
		<caption>举办会议</caption>	
		<tr><th>类型</th><th width="50%">详细信息</th><th>KPI</th></tr>
		<tr><td align="center">总计</td><td></td><td align="center">0</td>
	</table> 
	<br/>
	<table>
		<caption>邀请报告</caption>	
		<tr>
			<th>类型</th><th>KPI</th>
		</tr>
		<c:forEach var="report" items="${reports}" varStatus="loop">
		<tr>
		
			<td align="center">${report.type}</td><td align="center">${reportkpi[loop.count - 1]}</td>
		</tr>
		</c:forEach>
		<tr><td align="center">总计</td><td align="center">${reportkpi[reportkpi.size() - 1]}</td>
	</table> 
	<br/>
	<table>
		<caption>其他声誉</caption>	
		<tr><th>类型</th><th width="50%">详细信息</th><th>KPI</th></tr>
		<tr><td align="center">总计</td><td></td><td align="center">0</td>
	</table>
	<br/>	
	<h2 style="font-size:25px">教研和科研KPI总计为：${all[1]}</h2>
</div>

<hr style=" height:2px;border:none;border-top:2px dotted #185598;" /> 
<div align="center" class="教学	">
	<h2 style="font-size:30px">人才培养</h2>
	<table>
		<caption>课堂教学</caption>	
		<tr><th>课程序号</th><th>课程名称</th><th>理论课时</th>
			<th>实验课时</th><th>上机课时</th><th>学生人数</th><th>调课次数</th><th>英文授课</th><th>KPI</th>
		</tr>
		<c:forEach var="_class" items="${classes}" varStatus="loop">
		<tr>
			<td align="center">${_class.classID}</td>
			<td align="center">${_class.name}</td><td align="center">${_class.theoryduration}</td>
			<td align="center">${_class.experimentduration}</td><td align="center">${_class.computerduration}</td>
			<td align="center">${_class.studentnumber}</td><td align="center">${_class.adjustmentnumber}</td>
			<td align="center">${_class.isEnglish}</td><td align="center">${classkpi[loop.count - 1]}</td>
		</tr>
		</c:forEach>
		<tr><td align="center">总计</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td align="center">${classkpi[classkpi.size() - 1]}</td>
	</table> 
	<br/>
	<table>
		<caption>指导毕设</caption>	
		<tr>
			<th>学生序号</th><th>学生姓名</th><th>学生类型</th><th width="40%">研究课题</th><th>KPI</th>
		</tr>
		<c:forEach var="student" items="${students}" varStatus="loop">
		<tr>
			<td align="center">${student.studentID}</td>
			<td align="center">${student.name}</td><td align="center">${student.type}</td>
			<td align="center">${student.task}</td><td align="center">${studentkpi[loop.count - 1]}</td>
		</tr>
		</c:forEach>
		<tr><td align="center">总计</td><td></td><td></td><td></td><td align="center">${studentkpi[studentkpi.size() - 1]}</td>
	</table>
	<br/>
	<table>
		<caption>教改</caption>	
		<tr><th>类型</th><th width="40%">详细信息</th><th>KPI</th></tr>
		<tr><td align="center">总计</td><td></td><td align="center">0</td>
	</table>
	<br/>
	<table>
		<caption>课程</caption>	
		<tr><th>类型</th><th width="40%">详细信息</th><th>KPI</th></tr>
		<tr><td align="center">总计</td><td></td><td align="center">0</td>
	</table>
	<br/>
	<table>
		<caption>折算</caption>	
		<tr>
			<th>类型</th><th>KPI</th>
		</tr>
		<c:forEach var="conversion" items="${conversions}">
		<tr>
			
			<td align="center">${conversion.type}</td><td align="center">${conversion.kpi}</td>
		</tr>
		</c:forEach>
		<tr><td align="center">总计</td><td align="center"><fmt:formatNumber type="number" value="${conversionkpi[conversionkpi.size() - 1]}" pattern="0.00" maxFractionDigits="2"/></td>
	</table> 
	<br/>
	<table>
		<caption>其他</caption>	
		<tr>
			<th>类型</th><th>KPI</th>
		</tr>

		<tr><td align="center">总计</td><td align="center">0</td>
	</table>
	<br/>
	<h2 style="font-size:25px">教学KPI总计为：<fmt:formatNumber type="number" value="${all[0]}" pattern="0.00" maxFractionDigits="2"/></h2>
</div>
<br/>
<hr style=" height:2px;border:none;border-top:2px dotted #185598;" /> 
</body>
</html>