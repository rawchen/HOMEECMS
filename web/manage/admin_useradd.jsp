<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/jscss/admin/design/">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="admin_user.jsp">用户管理</a><span class="crumb-step">&gt;</span><span>新增用户</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="${pageContext.request.contextPath}/manage/addUserServlet" method="post" id="myform" name="myform" enctype="multipart/form-data">
                    <table class="insert-tab" width="100%">
                        <tbody>
                            <tr>
                                <th><i class="require-red">*</i>用户名：</th>
                                <td>
                                    <input class="common-text required" name="userName" size="50" value="" type="text">
                                </td>
                            </tr>
                            
                             <tr>
                                <th>用户昵称：</th>
                                <td>
                                    <input class="common-text required" name="nickname" size="50" value="" type="text">
                                </td>
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">*</i>登录密码：</th>
                                <td>
                                    <input class="common-text required" id="title" name="passWord" size="50" value="" type="text">
                                </td>
                            </tr>
                            
                             <tr>
                                <th><i class="require-red">*</i>确认密码：</th>
                                <td>
                                    <input class="common-text required" id="title" name="rePassWord" size="50" value="" type="text">
                                </td>
                            </tr>
                            
                             <tr>
                                <th>性别：</th>
                                <td>
                                	<input type="radio" name="sex" value="男" checked="checked">男
                                	<input  type="radio" name="sex" value="女" >女
                                </td>
                            </tr>
                            
                            
                            <tr>
                                <th><i class="require-red">*</i>权限：</th>
                                <td><input class="common-text" placeholder="普通用户1/管理员2" name="status" size="50" value="" type="text"></td>
                            </tr>
                           
                              <tr>
                                <th>头像：</th>
                                <td>
                                    <input class="" id="title" name="photo" size="50" accept="image/*" value="" type="file">
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