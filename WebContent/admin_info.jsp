<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*,course.study.vo.Student" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生基本信息</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
	<a href="logout.jsp">注销</a>
	<div>
		<a href="admin_info.jsp">学生基本信息</a>
		<a href="AdminSelectStudent">学生选课信息</a>
		<a href="StudentStatistics">学生信息统计</a>
		<a href="CourseStatistics">选课情况信息</a>
	</div>
	<br>
	<a href="admin_add.jsp">添加</a>
	<form action="QueryServlet" method="get">
		按学号查询：
		<input type="text" name="queryById">
		<input type="hidden" name="type" value="byId">
		<input type="submit" name="submit" value="查询">
	</form>
	<form action="QueryServlet" method="get">
		按姓名查询：
		<input type="text" name="queryByName"/>
		<input type="hidden" name="type" value="byName"/>
		<input type="submit" name="submit" value="查询">
	</form>
		
	<form action="QueryServlet" method="get">
		<input type="hidden" name="type" value="showAll"/>
		<input type="submit" name="submit" value="显示全部"/>
	</form>
	<div>
		<table>
			<tr>
				<th>学号</th>
				<th>姓名</th>
				<th>身份证号码</th>
				<th>班级</th>
				<th>性别</th>
				<th>密码</th>
				<th>籍贯</th>
				<th>家庭地址</th>
				<th>联系电话</th>
				<th>兴趣</th>
				<th>操作</th>
			</tr>
		
			<%
				Map<String,Student> map_stu = (Map<String,Student>)session.getAttribute("student");
				Set<Map.Entry<String,Student>> set = map_stu.entrySet();
				Iterator<Map.Entry<String,Student>> iter = set.iterator();
				while(iter.hasNext()){
					Map.Entry<String,Student> me = iter.next();
					String stu_id = me.getValue().getStu_id();
					String name = me.getValue().getName();
					String card_id = me.getValue().getCard_id();
					String stu_class = me.getValue().getStu_class();
					String sex = me.getValue().getSex();
					String password = me.getValue().getPassword();
					String perovince = me.getValue().getPerovince();
					String address = me.getValue().getAddress();
					String tel = me.getValue().getTel();
					String interest = me.getValue().getInterests();
			%>
			<tr>
				<td><%=stu_id %></td>
				<td><%=name %></td>
				<td><%=card_id %></td>
				<td><%=stu_class %></td>
				<td><%=sex %></td>
				<td><%=password %></td>
				<td><%=perovince %></td>
				<td><%=address %></td>
				<td><%=tel %></td>
				<td><%=interest %></td>
				<td>
					<a href="admin_update.jsp?stu_id=<%=stu_id %>&name=<%=name%>&card_id=<%=card_id %>&stu_class=<%=stu_class%>
					&sex=<%=sex%>&password=<%=password%>&perovince=<%=perovince%>
					&address=<%=address%>&tel=<%=tel%>&interest=<%=interest%>">修改</a>
					<a href="AdminDelete?stu_id=<%=stu_id %>">删除</a>
				</td>
			</tr>
			<%
				}
			%>
		</table>
	
	</div>
	<%
		if(request.getAttribute("isStudent") == "id"){
			out.println("<script>alert('输入的学号不存在！')</script>");
		}else if(request.getAttribute("isStudent")=="name"){
			out.println("<script>alert('输入的姓名不存在！')</script>");
		}
		
		if(request.getAttribute("update_success") == "true"){
			out.println("<script>alert('修改成功！')</script>");
		}else if(request.getAttribute("update_success") == "false"){
			out.println("<script>alert('修改的学号已经存在！')</script>");
		}
		
		if(request.getAttribute("add_success")=="true"){
			out.println("<script>alert('添加成功！')</script>");
		}else if(request.getAttribute("add_success") == "false"){
			out.println("<script>alert('学号已经存在！')</script>");
		}
	%>
</body>
</html>