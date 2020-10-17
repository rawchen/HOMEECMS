<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>后台管理</title>
	<link rel="stylesheet" type="text/css" href="css/admin_login.css"/>
</head>
<body>
<div class="admin_login_wrap">
    <h1>家居电子商城后台管理系统</h1>
    <div class="adming_login_border">
        <div class="admin_input">
            <form action="${pageContext.request.contextPath}/loginAdminServlet" method="post">
                <ul class="admin_items">
                    <li>
<%--                        <label for="user">管理员帐号：</label>--%>
                        <input type="text" name="userName" placeholder="管理员帐号" required value="" id="user" size="40" class="admin_input_style" />
                    </li>
                    <li>
<%--                        <label for="pwd">管理员密码：</label>--%>
                        <input type="password" name="passWord" placeholder="管理员密码" required value="" id="pwd" size="40" class="admin_input_style" />
                    </li>
                    <li style="padding-top: 20px;">
                        <input type="submit" tabindex="3" value="提交" class="btn btn-primary" />
                    </li>
                </ul>
            </form>
        </div>
    </div>
    <p class="admin_copyright"><a tabindex="5" href="${pageContext.request.contextPath}/indexServlet" target="_blank">家居电子商城首页</a> &copy; 2020</p>
</div>
</body>
</html>