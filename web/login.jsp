<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
</head>
<body><!-------------------login-------------------------->
<div class="login">
    <form action="${pageContext.request.contextPath}/loginServlet" method="post"><h1><a href="indexServlet"><img src="images/temp/logo.png"></a></h1>
        <p></p>
        <div class="msg-warn hide"><b></b>登录时注意电脑环境，以防账号丢失</div>
        <p><input type="text" name="userName" value="" placeholder="昵称/邮箱/手机号" required></p>
        <p><input type="password" name="passWord" value="" placeholder="密码" required></p>
        <p><input type="submit" name="" value="登  录"></p>
        <p class="txt"><a class="" href="reg.jsp">免费注册</a><a href="forget.html">忘记密码？</a></p></form>
</div>
</body>
</html>