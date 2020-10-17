<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="head">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top"><h1 class="fl"><a href="indexServlet"><img alt="" src="img/logo.png"/></a></h1>
            <div class="fr clearfix" id="top1">


            	<c:if test="${isLogin !=1 }">
                    <p class="fl" style="padding-top: 7px;">
            		<a href="login.jsp" id="login">登录</a><a href="reg.jsp" id="reg">注册</a>
            	</c:if>
            	
            	<c:if test="${isLogin ==1 }">
                    <p class="fl" style="padding-right: 15px;">
                    <img src="${pageContext.request.contextPath}/upload/user/${name.user_photo}" style="width: 30px; border-radius: 45px;vertical-align: middle;">
                    <b style="font-size: 14px">${name.user_name}</b>
            	
            	</c:if>
<%--            	<c:if test="${isAdminLogin ==1 }">--%>
<%--            		<a href="admin_index.jsp" id="login1">进入后台</a>--%>
<%--            	</c:if>--%>
            </p>
                <form action="searchProductServlet" method="post" class="fl"><input required type="text" name="key" placeholder="热门搜索：干花"/><input
                        type="submit" value=""/></form>
                <div class="btn fl clearfix"><a href="toUserInfoServlet"><img src="img/grzx.png"/></a><a href="#" class="er1"><img
                        src="img/ewm.png"/></a>
                        <a href="toCartServlet"><img src="img/gwc.png"/></a>
                        
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