<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit User</title>
</head>
<body>
<%@page import="com.regis.hibernatehw.Dao.UserDao, com.regis.hibernatehw.bean.User" %>

<%
    String idParam = request.getParameter("id");
    if (idParam != null && !idParam.isEmpty()) {
        int id = Integer.parseInt(idParam);
        User user = new UserDao().getRecordById(id);
        if (user != null) {
%>

<h1>Edit User</h1>
<form action="editUser" method="post">
    <input type="hidden" name="id" value="<%= user.getId() %>"/>
    <table>
        <tr><td>Name:</td><td><input type="text" name="name" value="<%= user.getName() %>"/></td></tr>
        <tr><td>Password:</td><td><input type="password" name="password" value="<%= user.getPassword() %>"/></td></tr>
        <tr><td>Email:</td><td><input type="email" name="email" value="<%= user.getEmail() %>"/></td></tr>
        <tr><td>Sex:</td><td>
            <input type="radio" name="sex" value="male" <%= user.getSex().equals("male") ? "checked" : "" %>/>Male
            <input type="radio" name="sex" value="female" <%= user.getSex().equals("female") ? "checked" : "" %>/>Female
        </td></tr>
        <tr><td>Country:</td><td>
            <select name="country">
                <option <%= user.getCountry().equals("India") ? "selected" : "" %>>India</option>
                <option <%= user.getCountry().equals("Pakistan") ? "selected" : "" %>>Pakistan</option>
                <option <%= user.getCountry().equals("Afghanistan") ? "selected" : "" %>>Afghanistan</option>
                <option <%= user.getCountry().equals("Berma") ? "selected" : "" %>>Berma</option>
                <option <%= user.getCountry().equals("Other") ? "selected" : "" %>>Other</option>
            </select>
        </td></tr>
        <tr><td colspan="2"><input type="submit" value="Edit User"/></td></tr>
    </table>
</form>

<%
} else {
%>
<p>User not found.</p>
<%
    }
} else {
%>
<p>Invalid user ID.</p>
<%
    }
%>

</body>
</html>
