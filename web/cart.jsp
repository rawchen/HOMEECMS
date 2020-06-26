<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>我的购物车</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
    <script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
</head>
<body><!--------------------------------------cart--------------------->
<div class="head ding">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top"><h1 class="fl"><a href="indexServlet"><img src="img/logo.png"/></a></h1>
            <div class="fr clearfix" id="top1"><p class="fl"><a href="login.html" id="login">登录</a><a href="reg.html"
                                                                                                      id="reg">注册</a>
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
</div>
<div class="cart mt"><!-----------------logo------------------->
    <!--<div class="logo"><h1 class="wrapper clearfix"><a href="index.html"><img class="fl" src="images/temp/logo.png"></a><img class="top" src="images/temp/cartTop01.png"></h1></div>-->
    <!-----------------site------------------->
    <div class="site"><p class=" wrapper clearfix"><span class="fl">购物车</span><img class="top"
                                                                                   src="images/temp/cartTop01.png"><a
            href="indexServlet" class="fr">继续购物&gt;</a></p></div><!-----------------table------------------->
    <div class="table wrapper">
        <div class="tr">
            <div>商品</div>
            <div>单价</div>
            <div>数量</div>
            <div>小计</div>
            <div>操作</div>
        </div>

       <c:forEach var="rs" items="${cartList}">
        <div class="th">
            <div class="pro clearfix"><label class="fl">
            	<input name="ck" type="checkbox" value="${rs.cart_id}"/>
            	
            	<span></span></label>
            	<a class="fl" href="toProductViewServlet?id=${rs.product_id}" target="_blank">
                <dl class="clearfix">
                    <dt class="fl"><img width="120" height="120" src="${pageContext.request.contextPath}/upload/product/${rs.product_photo}"></dt>
                    <dd class="fl"><p>${rs.product_name}</p>
                        <p>家居分类</p>
                        <p>xxx</p></dd>
                </dl>
            </a></div>
            <div class="price">￥${rs.product_price }.00</div>
            <div class="number">
            	<p class="num clearfix">
            	<img class="fl sub" src="images/temp/sub.jpg">
            	<span datasrc="${rs.cart_id }" class="fl">${rs.product_quantity }</span>
            	<img class="fl add" src="images/temp/add.jpg"></p>
           </div>
            <div class="price sAll">￥${rs.product_price * rs.product_quantity }.00</div>
            <div class="price"><a class="del" datasrc="${rs.cart_id }" href="#2">删除</a></div>
        </div>
       
       </c:forEach>
       
        
        <div class="goOn">空空如也~<a href="indexServlet">去逛逛</a></div>
        <div class="tr clearfix"><label class="fl"><input class="checkAll" type="checkbox"/><span></span></label>
            <p class="fl"><a href="#">全选</a><a href="#" class="del">删除</a></p>
            <p class="fr"><span>共<small id="sl">0</small>件商品</span><span>合计:&nbsp;<small id="all">￥0.00</small></span><a
                    href="javascript:toorder()" class="count">结算</a></p></div>
    </div>
</div>

<script>
	function toorder() {
			var str = "";
			
			$("input[name='ck']:checked").each(function(index, item){
				if($("input[name='ck']:checked").length-1 == index){
					str+= $(this).val();
				}else{
					str+= $(this).val()+",";
				}
				
			});
			
			location.href="orderselect?eids="+str;
		
	}
</script>
<div class="mask"></div>
<div class="tipDel"><p>确定要删除该商品吗？</p>
    <p class="clearfix"><a class="fl cer" href="#">确定</a><a class="fr cancel" href="#">取消</a></p></div><!--返回顶部-->
<div class="gotop"><a href="#" class="dh">
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
        违法和不良信息举报电话：888-888-8888，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</p></div><!----------------mask------------------->
<div class="mask"></div><!-------------------mask内容------------------->
<div class="proDets"><img class="off" src="images/temp/off.jpg"/>
    <div class="proCon clearfix">
        <div class="proImg fr"><img class="list" src="images/temp/proDet.jpg"/>
            <div class="smallImg clearfix"><img src="images/temp/proDet01.jpg" data-src="images/temp/proDet01_big.jpg"><img
                    src="images/temp/proDet02.jpg" data-src="images/temp/proDet02_big.jpg"><img src="images/temp/proDet03.jpg"
                                                                                          data-src="images/temp/proDet03_big.jpg"><img
                    src="images/temp/proDet04.jpg" data-src="images/temp/proDet04_big.jpg"></div>
        </div>
        <div class="fl">
            <div class="proIntro change"><p>颜色分类</p>
                <div class="smallImg clearfix"><p class="fl on"><img src="images/temp/prosmall01.jpg" alt="白瓷花瓶+20支快乐花"
                                                                     data-src="images/temp/proBig01.jpg"></p>
                    <p class="fl"><img src="images/temp/prosmall02.jpg" alt="白瓷花瓶+20支兔尾巴草"
                                       data-src="images/temp/proBig02.jpg"></p>
                    <p class="fl"><img src="images/temp/prosmall03.jpg" alt="20支快乐花" data-src="images/temp/proBig03.jpg"></p>
                    <p class="fl"><img src="images/temp/prosmall04.jpg" alt="20支兔尾巴草" data-src="images/temp/proBig04.jpg"></p>
                </div>
            </div>
            <div class="changeBtn clearfix"><a href="#2" class="fl"><p class="buy">确认</p></a><a href="#2" class="fr"><p
                    class="cart">取消</p></a></div>
        </div>
    </div>
</div>
<div class="pleaseC"><p>请选择宝贝</p><img class="off" src="images/temp/off.jpg"/></div>

<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="js/cart.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>