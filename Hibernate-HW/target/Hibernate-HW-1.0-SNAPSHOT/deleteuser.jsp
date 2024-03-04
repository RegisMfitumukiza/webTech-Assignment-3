<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.regis.hibernatehw.Dao.UserDao"%>
<jsp:useBean id="user" class="com.regis.hibernatehw.bean.User"></jsp:useBean>
<jsp:setProperty property="*" name="user"/>

<%
    UserDao.deleteUser(user);
    response.sendRedirect("viewusers.jsp");
%>