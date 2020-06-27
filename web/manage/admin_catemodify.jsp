<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/jscss/admin/design/">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="">分类管理</a><span class="crumb-step">&gt;</span><span>修改分类</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="${pageContext.request.contextPath}/manage/updateCategoryServlet" method="post" id="myform" name="myform">
                	<input type="hidden" name="id" value="${cate1.CATE_ID }">
                    <table class="insert-tab" width="100%">
                        <tbody>
                            <tr>
                                <th><i class="require-red">*</i>分类id：</th>
                                <td>
                                    <input class="common-text required" id="title" readonly name="categoryId" size="50" value="${c.category_id}" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>分类名：</th>
                                <td>
                                    <input class="common-text required" id="title" readonly name="catename" size="50" value="${c.category_name}" type="text">
                                </td>
                            </tr>
                            
                             <tr>
                                <th><i class="require-red">*</i>更改后名称：</th>
                                <td>
                                    <input class="common-text required" id="title" name="categoryName" size="50" value="" type="text">
                                </td>
                            </tr>
                            
                           
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="修改" type="submit">
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