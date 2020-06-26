<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>forget</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
    <link rel="stylesheet" type="text/css" href="css/forget.css"/>
</head>
<body><!----------------------------------------order------------------>
<div class="order cart"><!-----------------logo------------------->
    <div class="logo"><h1 class="wrapper clearfix"><a href="index.html"><img class="fl" src="images/temp/logo.png"></a>
    </h1></div>
    <div class="forCon"><p>安全设置-找回密码</p>
        <ul>
            <li class="on"><span>01/</span>输入登录名</li>
            <li><span>02/</span>验证信息</li>
            <li><span>03/</span>重置密码</li>
        </ul>
        <div class="formCon"><!--步骤1-->
            <form action="#" method="post" class="one"><input type="text" value=""
                                                              placeholder="昵称/邮箱"><label>请输入昵称/邮箱</label><br/><input
                    type="text" value="" placeholder="验证码"><label>请输入验证码</label><br/><img
                    src="images/temp/code.jpg"><br><input type="button" value="下一步" class="next"></form><!--步骤2-->
            <form action="#" method="post" class="two"><p>电子邮箱：<span>114081*****qq.com</span></p>
                <p class="tip">验证邮件已发往你的电子邮箱，请点击邮件中的链接完成验证</p><input type="button" value="去邮箱验证" class="next1"></form>
            <!--步骤3-->
            <form action="#" method="post" class="three"><label>新密码：</label><input type="text" value=""><br/><label>确认密码：</label><input
                    type="text" value=""><br/><input type="button" value="完成"></form>
        </div>
    </div>
</div>
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>