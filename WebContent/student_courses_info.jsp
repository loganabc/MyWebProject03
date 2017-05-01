<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,course.study.vo.Course" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>已选课程</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<a href="student_info.jsp">返回个人中心</a>&nbsp;&nbsp;<a href="select-courses.jsp">返回选课中心</a>
<h2>你已经选中的课程信息</h2>
<div>
	<table>
		<tr>
			<th>课程号</th>
			<th>课程名</th>
		</tr>
		<%
			Map<String,Course> selected_courses_info = (Map<String,Course>) session.getAttribute("selected_courses_info");
			Set<Map.Entry<String,Course>> set = selected_courses_info.entrySet();
			Iterator<Map.Entry<String,Course>> iter = set.iterator();
			while(iter.hasNext()){
				Map.Entry<String,Course> me = iter.next();
				String course_id = me.getValue().getCourse_id();
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