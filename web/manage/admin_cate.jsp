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
            <form action="/HOMEECMS/manage/admin_douserdel" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="/HOMEECMS/manage/admin_tocateadd"><i class="icon-font"></i>新增分类</a>
                     
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
                        
                        	 <c:if test="${cate.CATE_PARENT_ID ==0 }">
		                        <tr>
		                        	<td>${cate.CATE_ID }</td>
		                        	<td>|-${cate.CATE_NAME }</td>
		                        	<td><a href="admin_tocateupdate?id=${cate.CATE_ID }">修改</a> <a href="javascript:catedel(${cate.CATE_ID })">删除</a></td>
		                        
		                        </tr>
		                      	 <c:forEach var="zcate" items="${catelist}">
		                      	 	<c:if test="${zcate.CATE_PARENT_ID ==cate.CATE_ID }">
				                      	 <tr>
				                        	<td>${zcate.CATE_ID }</td>
				                        	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;｜-${zcate.CATE_NAME }</td>
				                        	<td><a href="admin_tocateupdate?id=${zcate.CATE_ID }">修改</a> <a href="javascript:catedel(${zcate.CATE_ID })">删除</a></td>
				                        
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