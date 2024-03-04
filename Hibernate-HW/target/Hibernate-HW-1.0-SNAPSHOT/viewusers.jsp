<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.regis.hibernatehw.Dao.UserDao, com.regis.hibernatehw.bean.User" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>View Users</title>
</head>
<body>

<h1>Users List</h1>

<%
    List<User> userList = new UserDao().getAllRecords();
    if (userList != null && !userList.isEmpty()) {
        request.setAttribute("userList", userList);
%>
<table border="1" width="90%">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Password</th>
        <th>Email</th>
        <th>Sex</th>
        <th>Country</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${userList}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.password}</td>
            <td>${user.email}</td>
            <td>${user.sex}</td>
            <td>${user.country}</td>
            <td><a href="edituser.jsp?id=${user.id}">Edit</a></td>
            <td><a href="deleteuser.jsp?id=${user.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<%
} else {
%>
<p>No users found.</p>
<%
    }
%>
<br/><a href="adduserform.jsp">Add New User</a>
</body>
</html>
