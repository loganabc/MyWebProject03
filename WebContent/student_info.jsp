<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="course.study.vo.Student" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选课中心</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<h1>学生选课中心</h1>
<%
	Student stu = (Student) session.getAttribute("student");
%>
<h3><%=stu.getName() %>，欢迎进入个人中心</h3>
<a href="student_update.jsp">修改资料</a>
<a href="StudentCourseCenter">选课中心</a>
<a href="logout.jsp">注销</a>
<div>
	<table>
		<tr>
			<td>学号</td>
			<td><%=stu.getStu_id() %></td>
		</tr>
		
		<tr>
			<td>姓名</td>
			<td><%=stu.getName() %></td>
		</tr>
		
		<tr>
			<td>身份证号码</td>
			<td><%=stu.getCard_id() %></td>
		</tr>
		
		<tr>
			<td>班级</td>
			<td><%=stu.getStu_class() %></td>
		</tr>
		
		<tr>
			<td>性别</td>
			<td><%=stu.getSex() %></td>
		</tr>
		
		<tr>
			<td>登录密码</td>
			<td><%=stu.getPassword() %></td>
		</tr>
		
		<tr>
			<td>籍贯</td>
			<td><%=stu.getPerovince() %></td>
		</tr>
		
		<tr>
			<td>家庭住址</td>
			<td><%=stu.getAddress() %></td>
		</tr>
		
		<tr>
			<td>联系电话</td>
			<td><%=stu.getTel() %></td>
		</tr>
		
		<tr>
			<td>兴趣爱好</td>
			<td><%=stu.getInterests() %></td>
		</tr>
	</table>
</div>
</body>
</html>