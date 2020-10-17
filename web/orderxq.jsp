<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>个人信息</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/myorder.css"/>
</head>
<body><!------------------------------head------------------------------>
<div class="head ding">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top"><h1 class="fl"><a href="indexServlet"><img src="img/logo.png"/></a></h1>
            <div class="fr clearfix" id="top1"><p class="fl"><a href="#" id="login">登录</a><a href="#" id="reg">注册</a>
            </p>
                <form action="searchProductServlet" method="post" class="fl"><input required type="text" name="key" placeholder="热门搜索：干花"/><input
                        type="submit" value=""/></form>
                <div class="btn fl clearfix"><a href="mygxin.html"><img src="img/grzx.png"/></a><a href="#" class="er1"><img
                        src="img/ewm.png"/></a><a href="cart.html"><img src="img/gwc.png"/></a>
                    <p><a href="#"><img src="img/smewm.png"/></a></p></div>
            </div>
        </div>
        <ul class="clearfix" id="bott">
            <li><a href="indexServlet">首页</a></li>
            <c:forEach var="f" items="${flist}">
                <li><a href="selectProductList?fid=${f.category_id}">${f.category_name}</a>
                    <div class="sList2">
                        <div class="clearfix">
                            <c:forEach var="c" items="${clist}">
                                <c:if test="${f.category_id == c.category_parentid}">
                                    <a href="selectProductList?cid=${c.category_id}">${c.category_name}</a>
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</div><!------------------------------idea------------------------------>
<div class="address mt">
    <div class="wrapper clearfix"><a href="#" class="fl">首页</a><span>/</span><a href="#"
                                                                                         class="on">我的订单</a><span>/</span><a
            href="#" class="on">订单详情</a></div>
</div><!------------------------------Bott------------------------------>
<div class="Bott">
    <div class="wrapper clearfix">
        <div class="zuo fl">
            <h3><a href="#"><img src="${pageContext.request.contextPath}/upload/user/${user.user_photo}" style="width: 92px; border-radius: 45px"/></a>
                <p class="clearfix"><span class="fl">[${user.user_name}]</span><span class="fr">[<a href="logoutServlet">退出登录</a>]</span></p></h3>
            <div><h4>我的交易</h4>
                <ul>
                    <li><a href="toCartServlet">我的购物车</a></li>
                    <li class="on"><a href="toMyOrderListServlet">我的订单</a></li>
                    <li><a href="${pageContext.request.contextPath}/toMyCommentListServlet">评价晒单</a></li>
                </ul>
                <h4>个人中心</h4>
                <ul>
                    <li><a href="toUserInfoServlet">我的中心</a></li>
                    <li><a href="toMyAddressListServlet">地址管理</a></li>
                </ul>
                <h4>账户管理</h4>
                <ul>
                    <li><a href="toMyInfoServlet">个人信息</a></li>

                </ul>
            </div>
        </div>
        <div class="you fl">
            <div class="my clearfix"><h2>订单详情<a href="#">请谨防钓鱼链接或诈骗电话，了解更多&gt;</a></h2>
                <h3>订单号：<span>${order.order_id}</span></h3></div>
            <div class="orderList">
                <div class="orderList1">
                    <div class="clearfix"><a href="#" class="fl"><img src="${pageContext.request.contextPath}/upload/product/${order.product_photo}" style="width: 65px"/></a>
                        <p class="fl"><a href="#">${order.product_name}</a><a href="#">¥${order.product_price}.00×${order.product_quantity}</a></p></div>
                </div>
                <div class="orderList1"><h3>收货信息</h3>
                    <p>姓 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<span>${address.user_name}</span></p>
                    <p>联系电话：<span>${address.user_phone}</span></p>
                    <p>收货地址：<span>${address.user_address}</span></p></div>
                <div class="orderList1"><h3>支付方式及送货时间</h3>
                    <p>支付方式：<span>在线支付</span></p>
                    <p>送货时间：<span>不限送货时间</span></p></div>
                <div class="orderList1 hei"><h3><strong>商品总价：</strong><span>¥${order.order_price}</span></h3>
                    <p><strong>运费：</strong><span>¥0</span></p>
                    <p><strong>订单金额：</strong><span>¥${order.order_price}</span></p>

                    <c:if test="${'1'.equals(order.is_pay)}">
                        <p><strong>实付金额：</strong><span>¥${order.order_price}</span></p></div>
                    </c:if>
                    <c:if test="${!'1'.equals(order.is_pay)}!='1'">
                        <p><strong>实付金额：</strong><span>¥0</span></p></div>
                    </c:if>

            </div>
        </div>
    </div>
</div>
<<!--返回顶部-->
<div class="gotop"><a href="toCartServlet">
    <dl>
        <dt><img src="img/gt1.png"/></dt>
        <dd>去购<br/>物车</dd>
    </dl>
</a><a href="#" class="dh">
    <dl>
        <dt><img src="img/gt2.png"/></dt>
        <dd>联系<br/>客服</dd>
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
    <p>888-888-8888</p></div><!--footer-->
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
<script src="js/user.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>
