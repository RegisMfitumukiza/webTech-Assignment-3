<%@page import="com.regis.hibernatehw.Dao.UserDao"%>
<jsp:useBean id="user" class="com.regis.hibernatehw.bean.User"></jsp:useBean>
<jsp:setProperty property="*" name="user"/>

<%
    int i=UserDao.saveUser(user);
    if(i>0){
        response.sendRedirect("adduser-success.jsp");
    }else{
        response.sendRedirect("adduser-error.jsp");
    }
%>