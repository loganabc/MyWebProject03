<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,course.study.vo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选课情况统计</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<a href="admin_info.jsp">首页</a>&nbsp;&nbsp;<a href="logout.jsp">注销</a>
<h1>选课情况统计</h1>
<div>
	<table>
		<tr>
			<th>学号</th>
			<th>姓名</th>
			<th>选课数量</th>
		</tr>
		<%
			List<Map.Entry<Student,Integer>> list = (List<Map.Entry<Student,Integer>>)session.getAttribute("list");
			for(Map.Entry<Student,Integer>mapping:list){
				String student_id = mapping.getKey().getStu_id();
				String name = mapping.getKey().getName();
				int num = mapping.getValue();
			
		%>
		<tr>
			<td><%=student_id %></td>
			<td><%=name %></td>
			<td><%=num %></td>
		</tr>
		<%
			}
		%>
	</table>
</div>
</body>
</html>