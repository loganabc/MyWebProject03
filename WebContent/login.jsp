<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生选课管理系统</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
<script type="text/javascript">
function loadImage(){
	document.getElementById("randImage").src = "Verification Code/image.jsp?"+Math.random();
}
</script>
</head>
<body>
	<h1>学生选课管理系统</h1>
	<form id="login" action="admin_info.jsp" method="post" name="myform">
		<input class="text" type="text" name="userid" placeholder="用户名" required><br>
		<input class="text" type="password" name="password" placeholder="密码" required><br>
		<input id="Verification-Code" class="text Verification-Code" type="text" name="rand" placeholder="验证码" required>
		<img name="randImage" id="randImage" src="Verification Code/image.jsp" alt="换一张" title="换一张" width="100" height="47" align="absmiddle" onclick="loadImage()"><br>
		<input id="submit" type="submit" name="submit" value="登&nbsp;录">
	</form>
	<%
		if(request.getAttribute("flag") == "false"){
			out.println("<script>alert('用户名或密码错误！')</script>");
		}
		
		if(request.getAttribute("Verification-Code")=="false"){
			out.println("<script>alert('验证码错误！')</script>");
		}
	%>
</body>
</html>