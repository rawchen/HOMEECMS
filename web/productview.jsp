<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<html>
<head>
    <meta charset="UTF-8">
    <title>详情页</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
</head>
<body><!------------------------------head------------------------------>

<%@ include file="header.jsp" %>

<!-----------------address------------------------------->
<div class="address">
    <div class="wrapper clearfix">
    		<a href="indexServlet">首页</a><span>/</span>${fatherC.category_name }<span>/</span>${childC.category_name}</a>
    </div>
</div><!-----------------------Detail------------------------------>
<div class="detCon">
    <div class="proDet wrapper">
        <div class="proCon clearfix">
            <div class="proImg fl">
            <img class="det" src="${pageContext.request.contextPath}/upload/product/${p.product_photo}"/>
                <div class="smallImg clearfix"><img src="${pageContext.request.contextPath}/upload/product/${p.product_photo}"
                                                    data-src="${pageContext.request.contextPath}/upload/product/${p.product_photo}"><img
                        src="images/temp/proDet02_big.jpg" data-src="images/temp/proDet02_big.jpg"><img
                        src="images/temp/proDet03_big.jpg" data-src="images/temp/proDet03_big.jpg"><img
                        src="images/temp/proDet04_big.jpg" data-src="images/temp/proDet04_big.jpg"></div>
            </div>
            <div class="fr intro">
                <div class="title"><h4>${p.product_name}</h4>
                    <p>【${p.product_name}${p.product_name}】&emsp;&emsp;&emsp;<span style="font-size: 14px;color: #000000">销量 :</span> <span style="font-size: 16px;">123</span></p><span>￥${p.product_price}.00</span></div>
                <div class="proIntro">
                    <p>颜色分类</p>
                    <div class="smallImg clearfix categ">
                        <p class="fl"><img src="${pageContext.request.contextPath}/upload/product/${p.product_photo}"
                                                                            alt="${p.product_name}"
                                                                            data-src="${pageContext.request.contextPath}/upload/product/${p.product_photo}"></p>
                        <p class="fl"><img src="images/temp/proDet02_big.jpg" alt="XXXX"
                                           data-src="images/temp/proDet02_big.jpg"></p>
                        </div>
                    <p>数量&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;库存<span>${p.product_stock}</span>件</p>
                    <div class="num clearfix">
                    		<img class="fl sub" src="images/temp/sub.jpg">
                    		<span id="countP" class="fl" contentEditable="true">1</span><img
                            class="fl add" src="images/temp/add.jpg">
                        <p class="please fl">请选择商品属性!</p></div>
                </div>
                <div class="btns clearfix">
                    <input id="userid" type="hidden" value="${name.user_id}">

                	<a href="javascript:void(0);" onclick ="js_method(${p.product_id})";><p class="buy fl">立即购买</p></a>

                    <a href="javascript:void(0);" onclick ="js_method2(${p.product_id})"><p class="cart fr"> 加入购物车</p></a></div>
            </div>
        </div>
    </div>
</div>

<script>
    function js_method(a) {
        if ($(".categ p").hasClass("on")) {

            var cont=document.getElementById("count");
            location.href='toOrderServlet?uid='+document.getElementById("userid").value+'&pid='+a+'&count='+document.getElementById("countP").innerHTML;

            $(".proIntro").css("border", "none");
            $(".num .please").hide()
        } else {
            $(".proIntro").css("border", "1px solid #c10000");
            $(".num .please").show()
        }

    }
    function js_method2(a) {
        if ($(".categ p").hasClass("on")) {

            var cont=document.getElementById("count");
            location.href='addCartServlet?uid='+document.getElementById("userid").value+'&pid='+a+'&count='+document.getElementById("countP").innerHTML;

            $(".proIntro").css("border", "none");
            $(".num .please").hide()
        } else {
            $(".proIntro").css("border", "1px solid #c10000");
            $(".num .please").show()
        }

    }
</script>
<script>
	function shopAdd(id, url) {
		var count = document.getElementById("count").innerHTML;

		location.href='cartadd?id='+id+'&count='+count+'&url='+url;
		
	}
</script>

<div class="introMsg wrapper clearfix">
    <div class="msgL fl">
        <div class="msgTit clearfix"><a class="on">商品详情</a><a>所有评价</a></div>
        <div class="msgAll">
            <div class="msgImgs">
                ${p.product_info}
            </div>
            <div class="eva">
                <c:if test="${empty comments}">
                    <div class="per clearfix">
                        <div class="perR fl"><p>该商品还没有人评论哦</p>
                            <p>

                            <p><span></span></p></div>
                    </div>
                </c:if>
                <c:forEach var="c" items="${comments}">
                    <div class="per clearfix"><img class="fl" src="images/temp/per02.jpg">
                        <div class="perR fl"><p>用户ID：${c.user_id}</p>
                            <p>${c.comment_content}

                            <p><span>${c.comment_time}</span></p></div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
    <div class="msgR fr" style="width:200px;"><h4>为你推荐</h4>
        <div class="seeList">
        <c:forEach var="cp" items="${classlist}">
        <a href="toProductViewServlet?id=${cp.product_id }">
            <dl>
                <dt><img src="${pageContext.request.contextPath}/upload/product/${cp.product_photo }" style="width: 160px"></dt>
                <dd>${cp.product_name }</dd>
                <dd>￥${cp.product_price }.00</dd>
            </dl>
        </a>
        </c:forEach>
        
        </div>
    </div>
</div>
<div class="like"><h4>最近访问</h4>
    <div class="bottom">
        <div class="hd"><span class="prev"><img src="images/temp/prev.png"></span><span class="next"><img
                src="images/temp/next.png"></span></div>
        <div class="imgCon bd">
            <div class="likeList clearfix">
                <div>
                
                
                 <c:forEach var="lp" items="${lastlist}">
			        <a href="toProductViewServlet?id=${lp.product_id }">
			            <dl>
			                <dt><img src="${pageContext.request.contextPath}/upload/product/${lp.product_photo}" style="width: 216px;"></dt>
			                <dd>${lp.product_name }</dd>
			                <dd>￥${lp.product_price }.00</dd>
			            </dl>
			        </a>
       			 </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div><!--返回顶部-->
<div class="gotop"><a href="toCartServlet">
    <dl class="goCart">
        <dt><img src="img/gt1.png"/></dt>
        <dd>去购<br/>物车</dd>
        <span>${cartCount}</span></dl>
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
</a><a href="#" class="toptop" style="display: none;">
    <dl>
        <dt><img src="img/gt4.png"/></dt>
        <dd>返回<br/>顶部</dd>
    </dl>
</a>
    <p>888-888-8888</p></div>
<div class="msk"></div><!--footer-->
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
<script src="js/jquery.SuperSlide.2.1.1.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/nav.js" type="text/javascript" charset="utf-8"></script>
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="js/cart.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">jQuery(".bottom").slide({
    titCell: ".hd ul",
    mainCell: ".bd .likeList",
    autoPage: true,
    autoPlay: false,
    effect: "leftLoop",
    autoPlay: true,
    vis: 1
});</script>
</body>
</html>
