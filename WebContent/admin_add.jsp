<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加学生</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<style type="text/css">
div{
	margin: 30px auto;
	width:600px;
	height:500px;
}
form{
	margin: 0 auto;
	width:100%;
	height: 100%
}
p{
	margin: 15px 70px 10px 100px;
	position:relative;
	height: 30px;
}
.word{
	display: inline-block;
	position: absolute;
	left:0;
	width: 170px;
	height: 30px;
	line-height: 30px;
	text-align: right;
}
.word .star{
	color: red;
}
.input{
	display:inline-block;
	position: absolute;
	right:0;
	width: 250px;
	height: 25px;
}
.sex{
	display: inline-block;
	margin: 10px -7px;
}
#interests{
	position:relative;
	left:100px;
}
.interest{
	display: inline-block;
	margin:10px -7px;
}
</style>
</head>
<body>
	<a href="admin_info.jsp">首页</a>&nbsp;&nbsp;<a href="logout.jsp">注销</a>
	<div>
		<form action="AdminAdd" method="post" name="form1">
			<p>
				<span class="word">学号：<span class="star">*</span></span>
				<input class="input" type="text" name="student_id" required/>
			</p>
			
			<p>
				<span class="word">姓名：<span class="star">*</span></span>
				<input class="input" type="text" name="name" required/>
			</p>
			
			<p>
				<span class="word">身份证号：<span class="star">*</span></span>
				<input class="input" type="text" name="card_id" required/>
			</p>
			
			<p>
				<span class="word">班级：<span class="star">*</span></span>
				<input class="input" type="text" name="stu_class" required/>
			</p>
			
			<p>
				<span class="word">性别：<span class="star">*</span></span>
				<input class="sex" type="radio" name="sex" value="男" required/>&nbsp;男
				<input class="sex" type="radio" name="sex" value="女" required/>&nbsp;女
				
			</p>
			
			<p>
				<span class="word">密码：<span class="star">*</span></span>
				<input class="input" type="text" name="password" required/>
			</p>
			
			<p>
				<span class="word">籍贯：<span class="star">*</span></span>
				<select class="input" name="perovince">
					<option value="" disabled selected style="display:none;">请选择省份</option>
					<option value="北京市">北京市</option>
					<option value="天津市">天津市</option>
					<option value="河北省">河北省</option>
					<option value="山西省">山西省</option>
					<option value="内蒙古自治区">内蒙古自治区</option>
					<option value="辽宁省">辽宁省</option>
					<option value="黑龙江省">黑龙江省</option>
					<option value="上海市">上海市</option>
					<option value="江苏省">江苏省</option>
					<option value="浙江省">浙江省</option>
					<option value="安徽省">安徽省</option>
					<option value="福建省">福建省</option>
					<option value="江西省">江西省</option>
					<option value="山东省">山东省</option>
					<option value="河南省">河南省</option>
					<option value="湖北省">湖北省</option>
					<option value="湖南省">湖南省</option>
					<option value="广东省">广东省</option>
					<option value="广西壮族自治区">广西壮族自治区</option>
					<option value="海南省">海南省</option>
					<option value="重庆市">重庆市</option>
					<option value="四川省">四川省</option>
					<option value="贵州省">贵州省</option>
					<option value="云南省">云南省</option>
					<option value="西藏自治区">西藏自治区</option>
					<option value="陕西省">陕西省</option>
					<option value="甘肃省">甘肃省</option>
					<option value="青海省">青海省</option>
					<option value="宁夏回族自治区">宁夏回族自治区</option>
					<option value="新疆维吾尔自治区">新疆维吾尔自治区</option>
				</select>
			</p>
			
			<p>
				<span class="word">家庭住址：<span class="star">*</span></span>
				<input class="input" type="text" name="address" required/>
			</p>
			
			<p>
				<span class="word">手机号：<span class="star">*</span></span>
				<input class="input" type="text" name="tel" required/>
			</p>
			
			<p>
				<span class="word">兴趣：<span class="star">*</span></span>
				<span id="interests">
					<input class="interest" type="radio" name="interest" value="运动" required/>&nbsp;运动
					<input class="interest" type="radio" name="interest" value="读书" required/>&nbsp;读书
					<input class="interest" type="radio" name="interest" value="音乐" required/>&nbsp;音乐
					<input class="interest" type="radio" name="interest" value="旅游" required/>&nbsp;旅游
					<input class="interest" type="radio" name="interest" value="社交" required/>&nbsp;社交
				</span>
			</p>
			
			<p>
				
				<input class="btn" type="submit" name="submit" value="确认添加"/>
			</p>
		</form>
	</div>
</body>
</html>