<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font">&#xe06b;</i><span>这是一条未实现的公告哦。</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>快捷操作</h1>
            </div>
            <div class="result-content">
                <div class="short-wrap">
                    <a href="toAddProductServlet"><i class="icon-font">&#xe001;</i>新增商品</a>
                    <a href="${pageContext.request.contextPath}/productListServlet"><i class="icon-font">&#xe005;</i>查看商品</a>
                    <a href="${pageContext.request.contextPath}/userListServlet"><i class="icon-font">&#xe048;</i>查看用户</a>
                    <a href="#"><i class="icon-font">&#xe041;</i>查看订单</a>
                    <a href="#"><i class="icon-font">&#xe01e;</i>查看评论</a>
                </div>
            </div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>系统基本信息</h1>
            </div>
            <div class="result-content">
                <ul class="sys-info-list">
                    <li>
                        <label class="res-lab">操作系统</label><span class="res-info"><%= System.getProperty("os.name") %></span>
                    </li>
                    <li>
                        <label class="res-lab">操作系统架构</label><span class="res-info"><%= System.getProperty("os.arch") %></span>
                    </li>
                    <li>
                        <label class="res-lab">运行环境</label><span class="res-info"><%= application.getServerInfo() %></span>
                    </li>
                    <li>
                        <label class="res-lab">Java版本</label><span class="res-info"><%= System.getProperty("java.version") %></span>
                    </li>
                    <li>
                        <label class="res-lab">Servlet Version</label><span class="res-info"><%= application.getMajorVersion() %>.<%= application.getMinorVersion() %></span>
                    </li><li>
                        <label class="res-lab">JSP Version</label><span class="res-info"><%= JspFactory.getDefaultFactory().getEngineInfo().getSpecificationVersion() %></span>
                    </li>
                    <li>
                        <label class="res-lab">北京时间</label><span class="res-info"><%= new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date()) %></span>
                    </li>
<%--                    <li>--%>
<%--                        <label class="res-lab">服务器IP</label><span class="res-info"><%= request.getLocalAddr() %></span>--%>
<%--                    </li>--%>
                </ul>
            </div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>使用帮助</h1>
            </div>
            <div class="result-content">
                <ul class="sys-info-list">
                    <li>
                        <label class="res-lab">更多：</label><span class="res-info"><a href="#" target="_blank">这是帮助文档哦</a></span>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>