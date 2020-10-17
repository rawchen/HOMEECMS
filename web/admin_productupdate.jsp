<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>
<%@ include file="admin_checklogin.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/jscss/admin/design/">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="admin_user.jsp">商品管理</a><span class="crumb-step">&gt;</span><span>修改商品</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="${pageContext.request.contextPath}/updateProductServlet?productId=${p.product_id}" method="post"  enctype="multipart/form-data" id="myform" name="myform">
                    <table class="insert-tab" width="100%">
                        <tbody>
                          <tr>
                                <th><i class="require-red">*</i>商品名称：</th>
                                <td>
                                    <input class="common-text required" required="required" id="title" name="productName" size="50" value="${p.product_name}" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>商品分类：</th>
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
                            </tr>
                            
                             <tr>
                                <th><i class="require-red">*</i>商品图片：</th>
                                <td>
                                    <input id="title" required="required" name="photo" size="50" accept="image/*" value="" type="file">
                                </td>
                            </tr>
                              <tr>
                                <th><i class="require-red">*</i>商品价格：</th>
                                <td>
                                    <input class="common-text required" required="required" id="title" name="productPrice" size="50" value="${p.product_price}" type="text">
                                </td>
                            </tr>
                              <tr>
                                  <th><i class="require-red">*</i>商品库存：</th>
                                  <td>
                                      <input class="common-text required" required="required" id="title" name="productStock" size="50" value="${p.product_stock}" type="text">
                                  </td>
                              </tr>
                              <tr>
                                <th><i class="require-red">*</i>商品介绍：</th>
                                <td>
                                    <textarea name="productInfo" placeholder="请输入内容" required lay-verify="required" class="layui-textarea">${p.product_info}</textarea>
                                    <script>
                                        CKEDITOR.replace( 'productInfo' );
                                    </script>
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