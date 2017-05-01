<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>退出页面</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<%
	response.setHeader("refresh", "2;URL=login.jsp");
	session.invalidate();
%>
<h3>您已成功退出本系统，两秒后跳转回登录页面！</h3>
<h3>如果没有跳转，请按<a href="login.jsp">这里</a></h3>
</body>
</html>