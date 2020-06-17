<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/jscss/admin/design/">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="admin_user.jsp">图书管理</a><span class="crumb-step">&gt;</span><span>新增图书</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="${pageContext.request.contextPath}/manage/admin_doproductadd" method="post"  enctype="multipart/form-data" id="myform" name="myform">
                    <table class="insert-tab" width="100%">
                        <tbody>
                          <tr>
                                <th><i class="require-red">*</i>图书名称：</th>
                                <td>
                                    <input class="common-text required" id="title" name="productName" size="50" value="" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>图书分类：</th>
                                <td>
                                    <select class="common-text required"  name="parentId">
                                    	
                                    	<c:forEach var="f" items="${flist }">
                                    		<option value="${f.CATE_ID }" disabled="disabled"> |-${f.CATE_NAME } </option>
                                    		<c:forEach var="c" items="${clist }">
                                    			<c:if test="${c.CATE_PARENT_ID == f.CATE_ID}">
                                    				<option value="${f.CATE_ID }-${c.CATE_ID }"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|-${c.CATE_NAME } </option>
                                    			</c:if>
                                    		</c:forEach>
                                    	</c:forEach>
                                    </select>
                                </td>
                            </tr>
                            
                             <tr>
                                <th><i class="require-red">*</i>图书图片：</th>
                                <td>
                                    <input class="common-text required" id="title" name="photo" size="50" value="" type="file">
                                </td>
                            </tr>
                              <tr>
                                <th><i class="require-red">*</i>图书价格：</th>
                                <td>
                                    <input class="common-text required" id="title" name="productPrice" size="50" value="" type="text">
                                </td>
                            </tr>
                              <tr>
                                <th><i class="require-red">*</i>图书介绍：</th>
                                <td>
                                    <input class="common-text required" id="title" name="productDesc" size="50" value="" type="text">
                                </td>
                            </tr>
                              <tr>
                                <th><i class="require-red">*</i>图书库存：</th>
                                <td>
                                    <input class="common-text required" id="title" name="productStock" size="50" value="" type="text">
                                </td>
                            </tr>
                            
                            
                           
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                                    <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
                        </tbody></table>
                </form>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
</body>
</html>