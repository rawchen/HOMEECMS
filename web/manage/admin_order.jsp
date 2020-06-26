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
                <form action="${pageContext.request.contextPath}/manage/orderListByKeyServlet" method="post">
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
                            <td><input class="common-text" placeholder="关键字" required name="keywords" value="${param.keywords}" id="" type="text"></td>
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
                        <a href="${pageContext.request.contextPath}/toAllOrderListServlet"><i class="icon-font"></i>所有订单</a>
                        <!--  a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a -->
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" name=""  onclick="selall(this)" type="checkbox"></th>
                            <th>订单号</th>
                            <th>用户ID</th>
                            <th>总价格</th>
                            <th>出单时间</th>
                            <th>是否支付</th>
                            <th>是否发货</th>
                            <th>是否收货</th>
                            <th>产品ID</th>
                            <th>产品数量</th>
                            <th>用户地址ID</th>
                            <th>操作</th>
                        </tr>


                        <c:forEach var="o" items="${pb.list}">
                            <tr>
                                <td class="tc"><input name="id[]" value="${o.order_id}" type="checkbox"></td>
                                <td> ${o.order_id}</td>
                                <td> ${o.user_id}</td>
                                <td> ${o.order_price}</td>
                                <td> ${o.order_time}</td>
                                <td> ${o.is_pay}</td>
                                <td> ${o.is_ship}</td>
                                <td> ${o.is_receipt}</td>
                                <td> ${o.product_id}</td>
                                <td> ${o.product_quantity}</td>
                                <td> ${o.address_id}</td>


                                <td>
                                    <c:if test="${'0'==o.is_pay && '0'==o.is_ship && '0'==o.is_receipt}">
                                        用户待支付状态

                                    </c:if>
                                    <c:if test="${'1'==o.is_pay && '0'==o.is_ship && '0'==o.is_receipt}">
                                        <a class="link-update" href="manage/updateOrderIsShipServlet?oid=${o.order_id}">点击发货</a>
                                    </c:if>

                                    <c:if test="${'1'==o.is_pay && '1'==o.is_ship && '0'==o.is_receipt}">
                                        已送达
                                    </c:if>
                                    <c:if test="${'1'==o.is_pay && '1'==o.is_ship && '1'==o.is_receipt}">
                                        已收货
                                    </c:if>


                                </td>
                            </tr>
                        </c:forEach>

                        <c:forEach var="o" items="${orders}">
                            <tr>
                                <td class="tc"><input name="id[]" value="${o.order_id}" type="checkbox"></td>
                                <td> ${o.order_id}</td>
                                <td> ${o.user_id}</td>
                                <td> ${o.order_price}</td>
                                <td> ${o.order_time}</td>
                                <td> ${o.is_pay}</td>
                                <td> ${o.is_ship}</td>
                                <td> ${o.is_receipt}</td>
                                <td> ${o.product_id}</td>
                                <td> ${o.product_quantity}</td>
                                <td> ${o.address_id}</td>


                                <td>
                                    <c:if test="${'0'==o.is_pay && '0'==o.is_ship && '0'==o.is_receipt}">
                                        用户待支付状态

                                    </c:if>
                                    <c:if test="${'1'==o.is_pay && '0'==o.is_ship && '0'==o.is_receipt}">
                                        <a class="link-update" href="manage/updateOrderIsShipServlet?oid=${o.order_id}">点击发货</a>
                                    </c:if>

                                    <c:if test="${'1'==o.is_pay && '1'==o.is_ship && '0'==o.is_receipt}">
                                        已送达
                                    </c:if>
                                    <c:if test="${'1'==o.is_pay && '1'==o.is_ship && '1'==o.is_receipt}">
                                        已收货
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
                    <c:if test="${empty orders}">
                        <div class="list-page">
                            共 ${pb.totalCount} 条记录， 当前 ${pb.currentPage}/${pb.totalPage} 页
                            <a href="${pageContext.request.contextPath}/toAllOrderListServlet?currentPage=1&row=5">首页</a>
                            <a href="${pageContext.request.contextPath}/toAllOrderListServlet?currentPage=${pb.currentPage-1<1?1:pb.currentPage-1}&row=5">上一页</a>
                            <a href="${pageContext.request.contextPath}/toAllOrderListServlet?currentPage=${pb.currentPage+1>pb.totalPage?pb.totalPage:pb.currentPage+1}&row=5">下一页</a>
                            <a href="${pageContext.request.contextPath}/toAllOrderListServlet?currentPage=${pb.totalPage}&row=5">尾页</a>
                        </div>
                    </c:if>

                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>