<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="index.html">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">分类管理</span></div>
        </div>
     
        <div id="register" class="result-wrap">
            <form action="${pageContext.request.contextPath}/manage/admin_douserdel" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="${pageContext.request.contextPath}/manage/toAddCategoryServlet"><i class="icon-font"></i>新增分类</a>
                     
                        <!--  a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a -->
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="40%">
                        <tr>
            
                            <th>ID</th>
                            <th>分类名称</th>
                            <th>操作</th>
                           
                        </tr>
                        
                        <c:forEach var="cate" items="${catelist}">
                        
                        	 <c:if test="${cate.category_parentid ==0 }">
		                        <tr>
		                        	<td>${cate.category_id }</td>
		                        	<td>|-${cate.category_name }</td>
		                        	<td><a href="admin_tocateupdate?id=${cate.category_id }">修改</a> <a href="javascript:catedel(${cate.category_id })">删除</a></td>
		                        
		                        </tr>
		                      	 <c:forEach var="zcate" items="${catelist}">
		                      	 	<c:if test="${zcate.category_parentid ==cate.category_id }">
				                      	 <tr>
				                        	<td>${zcate.category_id }</td>
				                        	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;｜-${zcate.category_name }</td>
				                        	<td><a href="admin_tocateupdate?id=${zcate.category_id }">修改</a> <a href="javascript:catedel(${zcate.category_id })">删除</a></td>
				                        
				                        </tr>
				                      </c:if>
		                          </c:forEach>
	                        </c:if>
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