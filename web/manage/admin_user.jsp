<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="#">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">用户管理</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="${pageContext.request.contextPath}/manage/admin_douserselect" method="get">
                    <table class="search-tab">
                        <tr>
                            <!--   th width="120">选择分类:</th>
                            <td>
                                <select name="search-sort" id="">
                                    <option value="">全部</option>
                                    <option value="19">精品界面</option><option value="20">推荐界面</option>
                                </select>
                            </td-->
                            <th width="70">关键字:</th>
                            <td><input class="common-text" placeholder="关键字" name="keywords" value="${param.keywords}" id="" type="text"></td>
                            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div id="register" class="result-wrap">
            <form action="${pageContext.request.contextPath}/manage/admin_douserdel" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="manage/admin_useradd.jsp"><i class="icon-font"></i>新增用户</a>
                        <a id="batchDel" href="javascript:delmore('你确定删除这些用户吗？', 'myform')"><i class="icon-font"></i>批量删除</a>
                        <!--  a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a -->
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" name=""  onclick="selall(this)" type="checkbox"></th>
                            <th>ID</th>
                            <th>用户名</th>
                            <th>昵称</th>
                            <th>密码</th>
                            <th>性别</th>
                            <th>是否vip</th>
                            <th>vip剩余时间(Day)</th>
                            <th>头像</th>
                            <th>操作</th>
                        </tr>
                        
                        <c:forEach var="u" items="${pb.list}">
	                        <tr>
	                        	
	                        	
	                            <td class="tc"><input name="id[]" value="${u.user_id}" type="checkbox"></td>
	                            <td> ${u.user_id  }</td>
	                             <td> ${u.user_name  }</td>
	                             <td> ${u.user_nickname  }</td>
	                             <td> ${u.user_password  }</td>
	                              <td> ${'男'.equals(u.user_sex)?'男':'女' }</td>
	                               <td> ${u.user_vip  }</td>
	                                <td> ${u.user_viptime  }</td>
                                <td><img src="${pageContext.request.contextPath}/upload/user/${u.user_photo}" style="width: 40px;"></td>

	                            <td>
	                                <a class="link-update" href="manage/updateUserServlet?uid=${u.user_id}">修改</a>
	                              
	                              <c:if test="${u.user_status ==1 }">
	                                <a class="link-del" href="javascript:Delete('你确定要删除用户【${u.user_name} }】吗？', '${pageContext.request.contextPath}/manage/admin_douserdel?id=${u.user_id}&cpage=${cpage }')">删除</a>
	                              </c:if>
	                            
	                            </td>
	                        </tr>
	                    </c:forEach>
                        
                        
                        <script>
                        	function Delete(mess, url) {
                        		if(confirm(mess)) {
                        			location.href=url;
                        			
                        		}
                        	}
                        	
                        	function selall(o) {
                        		var a = document.getElementsByName('id[]');
                        	
                        	
                        		
                        		for(var i=0; i<a.length; i++) {
                        			a[i].checked = o.checked;
                        		}
                        	}
                        	
                        	function delmore(mess, formname) {
                        		if(confirm(mess)) {
                        			var form = document.getElementById(formname);
                        			form.submit();
                        		}
                        	}
                        </script>
                        
                    </table>
                    <div class="list-page"> 
                    	共 ${pb.totalCount} 条记录， 当前 ${pb.currentPage}/${pb.totalPage} 页
                    	<a href="${pageContext.request.contextPath}/userListServlet?currentPage=1&row=5">首页</a>
                    	<a href="${pageContext.request.contextPath}/userListServlet?currentPage=${pb.currentPage-1<1?1:pb.currentPage-1}&row=5">上一页</a>
                    	<a href="${pageContext.request.contextPath}/userListServlet?currentPage=${pb.currentPage+1>pb.totalPage?pb.totalPage:pb.currentPage+1}&row=5">下一页</a>
                    	<a href="${pageContext.request.contextPath}/userListServlet?currentPage=${pb.totalPage}&row=5">尾页</a>
                  
                    
                    
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>