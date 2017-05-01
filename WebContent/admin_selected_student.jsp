<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*,course.study.vo.Student" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>已选课的学生</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<a href="admin_info.jsp">学生基本信息</a>&nbsp;&nbsp;
<a href="AdminSelectStudent">学生选课信息</a>&nbsp;&nbsp;
<a href="logout.jsp">注销</a>
<h1>已经选过课的学生</h1>
<div>
	<table>
		<tr>
			<th>学号</th>
			<th>姓名</th>
		</tr>
		<%
			Map<String,Student> map_selected_stu = (Map<String,Student>)session.getAttribute("map_selected_stu");
			Set<Map.Entry<String,Student>> set = map_selected_stu.entrySet();
			Iterator<Map.Entry<String,Student>> iter = set.iterator();
			while(iter.hasNext()){
				Map.Entry<String,Student> me = iter.next();
				String stu_id = me.getKey();
				String stu_name = me.getValue().getName();
			
		%>
		<tr>
			<td><a href="AdminStudentCoursesInfo?student_id=<%=stu_id%>"><%=stu_id %></a></td>
			<td><%=stu_name %></td>
		</tr>
		<%
			}
		%>
	</table>
</div>
</body>
</html>