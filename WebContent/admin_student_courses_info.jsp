<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*,course.study.vo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>该学生已选中的课程信息</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<a href="admin_info.jsp">首页</a>&nbsp;&nbsp;<a href="admin_selected_student.jsp">返回学生选课信息</a>
&nbsp;&nbsp;<a href="logout.jsp">注销</a>
<h2>该学生已选中的课程信息</h2>
<div>
	<table>
		<tr>
			<th>课程号</th>
			<th>课程名</th>
		</tr>
		<%
			Map<String,Course> map_cou = (Map<String,Course>) session.getAttribute("map_cou");
			Set<Map.Entry<String,Course>> set = map_cou.entrySet();
			Iterator<Map.Entry<String,Course>> iter = set.iterator();
			while(iter.hasNext()){
				Map.Entry<String,Course> me = iter.next();
				String course_id = me.getKey();
				String course_name = me.getValue().getCourse_name();
		%>
		<tr>
			<td><%=course_id %></td>
			<td><%=course_name %></td>
		</tr>
		<%
			}
		%>
	</table>
</div>
</body>
</html>