<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("admin") == null) {
%>
        <jsp:forward page="admin_login.jsp"></jsp:forward>
<%
    }
%>
