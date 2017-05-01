<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,course.study.vo.Course" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选课中心</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>

	<a href="student_info.jsp">首页</a>&nbsp;&nbsp;<a href="logout.jsp">注销</a>
	<br><br>
	<a href="select-courses.jsp">选课操作</a>
	<a href="student_courses_info.jsp">选课列表</a>
	<div>
		<form action="StudentSelectCourses" method="post">
			<table>
				<tr>
					<th></th>
					<th>课程号</th>
					<th>课程名</th>
				</tr>
				<%
					Map<String,Course> not_selected = (Map<String,Course>) session.getAttribute("not_selected");
					Set<Map.Entry<String,Course>> set = not_selected.entrySet();
					Iterator<Map.Entry<String,Course>> iter = set.iterator();
					while(iter.hasNext()){
						Map.Entry<String,Course> me = iter.next();
						String course_id = me.getValue().getCourse_id();
						String course_name = me.getValue().getCourse_name();
				%>
				<tr>
					<td><input type="checkbox" name="course" value="<%=course_id %>"></td>
					<td><%=course_id %></td>
					<td><%=course_name %></td>
				</tr>
				<%
					}
				%>
			</table>
			<input type="submit" nem="submit" value="保存">
		</form>
	</div>
	<%
		if(request.getAttribute("is_select") == "true"){
			out.println("<script>alert('选课成功！')</script>");
		}
		else if(request.getAttribute("is_selected") == "false"){
			out.println("<script>alert('请选择课程！')</script>");
		}
	%>
</body>
</html>