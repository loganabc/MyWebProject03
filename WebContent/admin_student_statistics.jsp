<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息统计</title>
<link ref="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<a href="admin_info.jsp">首页</a>&nbsp;&nbsp;<a href="logout.jsp">注销</a>
<h1>学生籍贯统计</h1>
<div>
	<table>
		<tr>
			<th>籍贯</th>
			<th>学生人数</th>
		</tr>
		<%
			Map<String,Integer>pero = (Map<String,Integer>)session.getAttribute("pero");
			Set<Map.Entry<String,Integer>> set1 = pero.entrySet();
			Iterator<Map.Entry<String,Integer>> iter1 = set1.iterator();
			while(iter1.hasNext()){
				Map.Entry<String,Integer> me1 = iter1.next();
				String perovince = me1.getKey();
				int num = me1.getValue();
			
		%>
		<tr>
			<td><%=perovince %></td>
			<td><%=num %></td>
		</tr>
		<%
			}
		%>
	</table>
</div>
<h1>学生爱好统计</h1>
<div>
	<table>
		<tr>
			<th>爱好</th>
			<th>学生人数</th>
		</tr>
		<%
			Map<String, Integer> inter = (Map<String,Integer>)session.getAttribute("inter");
			Set<Map.Entry<String,Integer>> set2 = inter.entrySet();
			Iterator<Map.Entry<String,Integer>> iter2 = set2.iterator();
			while(iter2.hasNext()){
				Map.Entry<String,Integer> me2 = iter2.next();
				String interest = me2.getKey();
				int num = me2.getValue();
			
		%>
		<tr>
			<td><%=interest %></td>
			<td><%=num %></td>
		</tr>
		<%
			}
		%>
	</table>

</div>
</body>
</html>