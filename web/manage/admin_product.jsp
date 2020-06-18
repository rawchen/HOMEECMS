<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="index.html">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">商品管理</span></div>
        </div>
     
        <div id="register" class="result-wrap">
            <form action="${pageContext.request.contextPath}/manage/admin_douserdel" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="${pageContext.request.contextPath}/manage/toAddProductServlet"><i class="icon-font"></i>新增商品</a>
                     
                        <!--  a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a -->
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="60%">
                        <tr>
            
                            <th>ID</th>
                            <th>商品名称</th>
                            <th>操作</th>
                           
                        </tr>
                        
                        <c:forEach var="p" items="${plist }">
                        	<tr>
                        		<td>${p.product_id }</td>
                        		<td><img src="${pageContext.request.contextPath}/upload/product/${p.product_photo}" width="80" height="80">
                        			${p.product_name }
                        		
                        		</td>
                        		<td>
                        			<a href="">修改</a>
                        			<a href="">删除</a>
                        		</td>
                        	</tr>
	                    </c:forEach>
                        
                        
                        <script>
                        	function catedel(id) {
                        		if(confirm("你确认要删除这个分类吗")) {
                        			location.href="admin_docatedel?id="+id;
                        			
                        		}
                        	}
                        	
                        	
                        </script>
                        
                    </table>
                    
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>