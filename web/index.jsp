<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>家居电子商城</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
    <link href="//cdn.bootcss.com/flexslider/2.6.3/flexslider.min.css" rel="stylesheet">
    <style>
        .flex-direction-nav a {
            overflow: unset;

        }
    </style>
</head>
<body><!------------------------------head------------------------------>

<%@ include file="header.jsp" %>


<!-------------------------banner--------------------------->
<div class="block_home_slider">
    <div id="home_slider" class="flexslider slide">
        <ul class="slides">
            <li>
                <div class="slide"><img src="img/banner2.jpg"/></div>
            </li>
            <li>
                <div class="slide"><img src="img/banner1.jpg"/></div>
            </li>
        </ul>
    </div>
</div>
</div>
<!------------------------------news------------------------------>
<div class="news">
    <div class="wrapper">
        <h2><img src="img/ih2.jpg"/></h2>
        <div class="flower clearfix tran">

<%--            <c:forEach var="p" items="${newProductList}">--%>
<%--                <a href="toProductViewServlet?id=${p.product_id}" class="clearfix" style="float: left;" >--%>
<%--                    <div>--%>
<%--                        <span class="abl"></span>--%>
<%--                        <img src="${pageContext.request.contextPath}/upload/product/${p.product_photo}" style="width: 228px;">--%>
<%--                        <span class="abr"></span>--%>
<%--                        <br>${p.product_name}--%>
<%--                        <br><span>￥${p.product_price}.00</span>--%>
<%--                    </div>--%>
<%--                </a>--%>
<%--            </c:forEach>--%>


            <c:forEach var="p" items="${newProductList}">
                <a href="toProductViewServlet?id=${p.product_id}" class="clearfix">
                    <dl>
                        <dt><span class="abl"></span><img src="${pageContext.request.contextPath}/upload/product/${p.product_photo}" style="width: 356px;"><span class="abr"></span></dt>
                        <dd>${p.product_name}</dd>
                        <dd><span>￥${p.product_price}.00</span></dd>
                    </dl>
                </a>
            </c:forEach>


        </div>
    </div>
</div><!------------------------------ad------------------------------><a href="#" class="ad"><img
        src="img/ib1.jpg"/></a><!------------------------------people------------------------------>
<div class="people">
    <div class="wrapper"><h2><img src="img/ih3.jpg"/></h2>
        <div class="pList clearfix tran">
            <c:forEach var="p" items="${newProductList2}">
                <a href="toProductViewServlet?id=${p.product_id}" class="clearfix">
                    <dl>
                        <dt><span class="abl"></span><img src="${pageContext.request.contextPath}/upload/product/${p.product_photo}" style="width: 268px;"><span class="abr"></span></dt>
                        <dd>${p.product_name}</dd>
                        <dd><span>￥${p.product_price}.00</span></dd>
                    </dl>
                </a>
            </c:forEach>
        </div>
    </div>
</div><!--返回顶部-->
<div class="gotop"><a href="toCartServlet">
    <dl class="goCart">
        <dt><img src="img/gt1.png"/></dt>
        <dd>去购<br/>物车</dd>
        <span>${cartCount}</span></dl>
    </dl>
</a><a href="toUserInfoServlet">
    <dl>
        <dt><img src="img/gt3.png"/></dt>
        <dd>个人<br/>中心</dd>
    </dl>
</a><a href="#" class="toptop" style="display: none">
    <dl>
        <dt><img src="img/gt4.png"/></dt>
        <dd>返回<br/>顶部</dd>
    </dl>
</a>
    <p>888-888-8888</p></div><!-------------------login--------------------------><!--footer-->
<div class="footer">
    <div class="top">
        <div class="wrapper">
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot1.png"/></a><span class="fl">7天无理由退货</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot2.png"/></a><span class="fl">15天免费换货</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot3.png"/></a><span class="fl">满599包邮</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot4.png"/></a><span class="fl">手机特色服务</span>
            </div>
        </div>
    </div>
    <p class="dibu">家居电子商城&copy;2000-2020公司版权所有 京ICP备000001-11备0000111000号<br/>
        违法和不良信息举报电话：888-888-8888，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</p></div>
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/nav.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.flexslider-min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">$(function () {
    $('#home_slider').flexslider({
        animation: 'slide',
        controlNav: true,
        directionNav: true,
        animationLoop: true,
        slideshow: true,
        slideshowSpeed: 2000,
        useCSS: false
    });
});</script>
</body>
</html>