<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>
<%@ include file="admin_checklogin.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="#">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">商品管理</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="${pageContext.request.contextPath}/productListByCategoryServlet" method="post">
                <table class="search-tab">
                    <tbody><tr>
                        <th width="120">选择分类:</th>
                        <td>
                            <select class="common-text required" required="required" name="parentId">

                                <c:forEach var="f" items="${flist }">
                                    <option value="${f.category_id }" disabled="disabled"> |-${f.category_name } </option>
                                    <c:forEach var="c" items="${clist }">
                                        <c:if test="${c.category_parentid == f.category_id}">
                                            <option value="${f.category_id }-${c.category_id }"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|-${c.category_name } </option>
                                        </c:if>
                                    </c:forEach>
                                </c:forEach>
                            </select>
                        </td>
                        <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                    </tr>
                    </tbody></table>
            </form>
            </div>
        </div>
     
        <div id="register" class="result-wrap">
            <form action="${pageContext.request.contextPath}/admin_douserdel" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="${pageContext.request.contextPath}/toAddProductServlet"><i class="icon-font"></i>新增商品</a>
                        <a href="${pageContext.request.contextPath}/productListServlet"><i class="icon-font"></i>查看全部</a>
                        <!--  a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a -->
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
            
                            <th>ID</th>
                            <th>商品名称</th>
                            <th>商品价格</th>
                            <th>商品库存</th>
                            <th>发布时间</th>
                            <th>操作</th>
                           
                        </tr>
                        
                        <c:forEach var="p" items="${pb.list }">
                        	<tr>
                        		<td>${p.product_id }</td>
                        		<td><img src="${pageContext.request.contextPath}/upload/product/${p.product_photo}" width="60px" height="60px">
                        			${p.product_name }
                        		</td>
                                <td>￥${p.product_price}.00</td>
                                <td>${p.product_stock}</td>
                                <td>${p.product_time}</td>
                        		<td>
                        			<a href="${pageContext.request.contextPath}/toUpdateProductServlet?productId=${p.product_id}">修改</a>
                        			<a href="javascript:del(${p.product_id});">删除</a>
                        		</td>
                        	</tr>
	                    </c:forEach>
                        <c:forEach var="p" items="${plist}">
                            <tr>
                                <td>${p.product_id }</td>
                                <td><img src="${pageContext.request.contextPath}/upload/product/${p.product_photo}" width="60px" height="60px">
                                        ${p.product_name }
                                </td>
                                <td>￥${p.product_price}.00</td>
                                <td>${p.product_stock}</td>
                                <td>${p.product_time}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/toUpdateProductServlet?productId=${p.product_id}">修改</a>
                                    <a href="javascript:del(${p.product_id});">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                        
                        
                        <script>
                        	function del(id) {
                        		if(confirm("你确认要删除这个商品吗")) {
                        			location.href="${pageContext.request.contextPath}/delProductServlet?productId="+id
                        		}
                        	}
                        	
                        	
                        </script>
                        
                    </table>
                    <c:if test="${empty plist}">
                        <div class="list-page">
                            共 ${pb.totalCount} 条记录， 当前 ${pb.currentPage}/${pb.totalPage} 页
                            <a href="${pageContext.request.contextPath}/productListServlet?currentPage=1&row=5">首页</a>
                            <a href="${pageContext.request.contextPath}/productListServlet?currentPage=${pb.currentPage-1<1?1:pb.currentPage-1}&row=5">上一页</a>
                            <a href="${pageContext.request.contextPath}/productListServlet?currentPage=${pb.currentPage+1>pb.totalPage?pb.totalPage:pb.currentPage+1}&row=5">下一页</a>
                            <a href="${pageContext.request.contextPath}/productListServlet?currentPage=${pb.totalPage}&row=5">尾页</a>
                        </div>
                    </c:if>
                    
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>