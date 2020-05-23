<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <script src="jquery.js"></script> -->
<title>注册</title>
</head>
<body>
	 <fieldset style="width:500px;">
 <legend>注册</legend>
	<!--form表单的action属性规定当提交表单时，向何处发送表单数据，method属性指明表单的提交方式，分为get和post，默认为get-->
   <form action="http://localhost:8088/user/regsiter" method="post">
   <!--输入文本框，SIZE表示显示长度，maxlength表示最多输入长度-->
   账号：<input type="text" name="username" value="请输入用户名" SIZE="20" maxlength="20"><br>
    <!--密码框，其中所有输入的内容都以密文的形式显示-->
   密码：<input type="password" name="password" value="请输入密码" SIZE="20" maxlength="20"><br>
  
  手机：<input type="text" name="phone" value="请输入手机号" SIZE="20" maxlength="20"><br>
  邮箱：<input type="text" name="email" value="请输入邮箱" SIZE="20" maxlength="20"><br>
   验证码：<input type="text" name="captcha" value="请输入验证码" SIZE="10" maxlength="10"><br>
   <img src="http://localhost:8088/user/verification" />
<!--    <input type="hidden" name="backurl" value="http://localhost:8088/user/login"> -->
   <!--提交表单按钮，当点击提交后，所有填写的表单内容都会被传输到服务器端-->
   <input type="submit" value="提交" >
   <!--重置表单按钮，当点击重置后，所有表单恢复原始显示内容-->
   <input type="reset" value="重置">
	</form>
	<!--表单结束-->
	</fieldset>
</body>
</html>