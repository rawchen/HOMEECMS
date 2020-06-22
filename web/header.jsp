<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--1. Server info: <%= application.getServerInfo() %><br>--%>
<%--2. Servlet version: <%= application.getMajorVersion() %>.<%= application.getMinorVersion() %><br>--%>
<%--3. JSP version: <%= JspFactory.getDefaultFactory().getEngineInfo().getSpecificationVersion() %><br>--%>
<%--4. Java version: <%= System.getProperty("java.version") %><br>--%>
<div class="head">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top"><h1 class="fl"><a href="indexServlet"><img alt="" src="img/logo.png"/></a></h1>
            <div class="fr clearfix" id="top1"><p class="fl">
            	<c:if test="${isLogin !=1 }">
            		<a href="login.jsp" id="login">登录</a><a href="reg.jsp" id="reg">注册</a>
            	</c:if>
            	
            	<c:if test="${isLogin ==1 }">

                    你好：<b style="font-size: 18px">${name.user_name}</b>
            	
            	</c:if>
<%--            	<c:if test="${isAdminLogin ==1 }">--%>
<%--            		<a href="manage/admin_index.jsp" id="login1">进入后台</a>--%>
<%--            	</c:if>--%>
            </p>
                <form action="#" method="get" class="fl"><input type="text" placeholder="热门搜索：干花花瓶"/><input
                        type="button"/></form>
                <div class="btn fl clearfix"><a href="mygxin.jsp"><img src="img/grzx.png"/></a><a href="#" class="er1"><img
                        src="img/ewm.png"/></a>
                        <a href="cart.html"><img src="img/gwc.png"/></a>
                        
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