<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
</head>
<body><!-------------------reg-------------------------->
<div class="reg">
    <form action="${pageContext.request.contextPath}/regServlet" method="post"><h1><a href="indexServlet"><img src="images/temp/logo.png"></a></h1>
        <p></p>
        <div class="msg-warn hide">
            <b></b>
            <c:if test="${empty msg}">
                注册时注意电脑环境，以防账号丢失
            </c:if>
            <c:if test="${not empty msg}">
                ${msg}
            </c:if>


        </div>
        <p><input type="text" name="userName" value="${userName}" placeholder="请输入用户名" required></p>
        <p><input type="password" name="userPassword" value="${userPassword}" placeholder="请输入密码" required></p>
        <p><input type="password" name="enUserPassword" value="${enUserPassword}" placeholder="请确认密码" required></p>
        <p class="txtL txt"><input class="code" type="text" name="verifycode" value="" placeholder="验证码" required>
            <a href="javascript:refreshCode()">
                <img src="${pageContext.request.contextPath}/checkCodeServlet" title="刷新验证码" id="vcode">
            </a>
        </p>
        <p><input type="submit" name="" value="注册"></p>
        <p class="txtL txt">注册即表示您同意了我们的<a href="#">
            <使用条款和隐私策略>
        </a></p>
        <p class="txt"><a href="login.jsp"><span></span>已有账号登录</a></p>
        <!--<a href="#" class="off"><img src="images/temp/off.png"></a>--></form>
</div>

<script type="text/javascript">
    function refreshCode() {
        var vcode = document.getElementById("vcode");
        vcode.src = "${pageContext.request.contextPath}/checkCodeServlet?time="+new Date().getTime();
    }
</script>
</body>
</html>
