<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>最家</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/myorder.css"/>
</head>
<body><!------------------------------head------------------------------>
<div class="head ding">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top"><h1 class="fl"><a href="indexServlet"><img src="img/logo.png"/></a></h1>
            <div class="fr clearfix" id="top1"><p class="fl"><a href="#" id="login">登录</a><a href="#" id="reg">注册</a>
            </p>
                <form action="searchProductServlet" method="post" class="fl"><input required type="text" name="key" placeholder="热门搜索：干花花瓶"/><input
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
    <div class="wrapper clearfix"><a href="#" class="fl">首页</a><span>/</span><a
            href="#">个人中心</a><span>/</span><a href="#" class="on">我的订单</a></div>
</div><!------------------------------Bott------------------------------>
<div class="Bott">
    <div class="wrapper clearfix">
        <div class="zuo fl">
            <h3><a href="#"><img src="${pageContext.request.contextPath}/upload/user/${user.user_photo}" style="width: 92px; border-radius: 45px;"/></a>
                <p class="clearfix"><span class="fl">[${user.user_name}]</span>[<a href="logoutServlet">退出登录</a>]</p></h3>
            <div><h4>我的交易</h4>
                <ul>
                    <li><a href="#">我的购物车</a></li>
                    <li  class="on"><a href="toMyOrderListServlet">我的订单</a></li>
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
            <div class="my clearfix"><h2 class="fl">我的订单</h2><a href="#" class="fl">请谨防钓鱼链接或诈骗电话，了解更多&gt;</a></div>
            <div class="dlist clearfix">
                <ul class="fl clearfix" id="wa">
                    <li class="on"><a href="#2">全部有效订单</a></li>
                    <li><a href="#t2">待支付</a></li>
                    <li><a href="#t3">待发货</a></li>
                    <li><a href="#t4">待收货</a></li>
                    <li><a href="#t5">交易成功</a></li>
                </ul>
                <form action="#" method="get" class="fr clearfix"><input type="text" name="" value=""
                                                                         placeholder="请输入商品名称、订单号"/><input type="button"
                                                                                                           name="" id=""
                                                                                                           value=""/>
                </form>
            </div>

            <c:forEach var="o" items="${orders}">
                <c:if test="${'0'==o.is_pay && '0'==o.is_ship && '0'==o.is_receipt}">
                    <div class="dkuang deng"><p class="one">待支付</p>
                </c:if>
                <c:if test="${'1'==o.is_pay && '0'==o.is_ship && '0'==o.is_receipt}">
                    <div class="dkuang deng"><p class="one">待发货</p>
                </c:if>

                <c:if test="${'1'==o.is_pay && '1'==o.is_ship && '0'==o.is_receipt}">
                    <div class="dkuang deng"><p class="one">待收货</p>
                </c:if>
                <c:if test="${'1'==o.is_pay && '1'==o.is_ship && '1'==o.is_receipt}">
                    <div class="dkuang deng"><p class="one">交易成功</p>
                </c:if>


                    <div class="word clearfix">
                        <ul class="fl clearfix">
                            <li>${o.order_time}</li>
                            <li>订单号:${o.order_id}</li>
                            <li>在线支付</li>
                        </ul>
                        <p class="fr">订单金额：<span>${o.order_price}.00</span>元</p></div>
                    <div class="shohou clearfix"><a href="#" class="fl"><img src="${pageContext.request.contextPath}/upload/product/${o.product_photo}"/></a>
                        <p class="fl"><a href="#">${o.product_name}</a><a href="#">¥${o.product_price}.00×${o.product_quantity}</a></p>
                        <p class="fr">
                            <c:if test="${'0'==o.is_pay && '0'==o.is_ship && '0'==o.is_receipt}">
                                <a href="">取消订单</a>
                            </c:if>

                            <a href="myprod.html">

                            <c:if test="${'0'==o.is_pay && '0'==o.is_ship && '0'==o.is_receipt}">
                                支付

                            </c:if>
                            <c:if test="${'1'==o.is_pay && '0'==o.is_ship && '0'==o.is_receipt}">
                                催一催
                            </c:if>

                            <c:if test="${'1'==o.is_pay && '1'==o.is_ship && '0'==o.is_receipt}">
                                确认收货
                            </c:if>
                            <c:if test="${'1'==o.is_pay && '1'==o.is_ship && '1'==o.is_receipt}">
                                给星星
                            </c:if>


                        </a><a href="${pageContext.request.contextPath}/orderDetailServlet?oid=${o.order_id}">订单详情</a></p></div>
                </div>
            </c:forEach>




            <%--<div class="dkuang"><p class="one">已关闭</p>
                <div class="word clearfix">
                    <ul class="fl clearfix">
                        <li>2016年12月1日 18:53</li>
                        <li>杨小黄</li>
                        <li>订单号:5160513358520018</li>
                        <li>在线支付</li>
                    </ul>
                    <p class="fr">订单金额：<span>99.00</span>元</p></div>
                <div class="shohou clearfix"><a href="#" class="fl"><img src="img/g1.jpg"/></a>
                    <p class="fl"><a href="#">家用创意菜盘子圆盘 釉下彩复古</a><a href="#">¥99.00×1</a></p>
                    <p class="fr"><a href="#">交易失败</a><a href="orderxq.html">订单详情</a></p></div>
            </div>--%>
            <div class="fenye clearfix"><a href="#"><img src="img/zuo.jpg"/></a><a href="#">1</a><a href="#"><img
                    src="img/you.jpg"/></a></div>
        </div>
    </div>
</div><!--返回顶部-->
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
