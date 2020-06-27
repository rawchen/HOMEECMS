<%@ page language="java" contentType="text/html; charset=UTF-8"
                pageEncoding="UTF-8"%>
<%@ include file="admin_menu.jsp" %>
<!--/sidebar-->
<div class="main-wrap">

    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font">
        </i><a href="${pageContext.request.contextPath}/manage/admin_index.jsp">首页</a>
            <span class="crumb-step">&gt;</span>
            <a class="crumb-name" href="${pageContext.request.contextPath}/manage/admin_douserselect">用户管理</a>
            <span class="crumb-step">&gt;</span><span>修改用户</span></div>
    </div>
    <div class="result-wrap">
        <div class="result-content">
            <form action="${pageContext.request.contextPath}/manage/updateUserListServlet?userId=${u.user_id}" enctype="multipart/form-data" method="post" id="myform" name="myform">
                <input type="hidden" name="userStatus" value="${u.user_status }">

                <input type="hidden" name="cpage" value="${cpage }">
                <table class="insert-tab" width="100%">
                    <tbody>
                        <tr>
                            <th><i class="require-red">*</i>用户名：</th>
                            <td>
                                <input class="common-text required" id="title1" readonly name="name" size="50" value="${u.user_name}" type="text">
                            </td>
                        </tr>

                        <tr>
                            <th><i class="require-red">*</i>昵称：</th>
                            <td>
                                <input class="common-text required" id="title3" name="nickName" size="50" value="${u.user_nickname }" type="text">
                            </td>
                        </tr>



                        <tr>
                            <th><i class="require-red">*</i>登录密码：</th>
                            <td>
                                <input class="common-text required" id="title2" name="passWord" size="50" value="${u.user_password }" type="text">
                            </td>
                        </tr>



                        <tr>
                            <th>性别：</th>
                            <td>
                                <input type="radio" name="sex" value="男" ${u.user_sex=='男'?"checked":"" }>男
                                <input  type="radio" name="sex" value="女" ${u.user_sex=='女'?"checked":"" }>女
                            </td>
                        </tr>


                        <tr>
                            <th><i class="require-red">*</i>头像：</th>
                            <td>
                                <input id="title5" name="mobile" size="50" value="${u.user_photo }" type="file">
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