<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>User Management Application</title>
    </head>
    <body>
    <center>
        <h1>User Management</h1>
        <h2>
            <a href="users?action=users">List All Users</a>
        </h2>
    </center>
    <div align="center">
        <form method="post">
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        Edit User
                    </h2>
                </caption>
                <c:if test="${user != null}">
                    <input type="hidden" name="id" value="<c:out value='${user.id}' />"/>
                </c:if>
                <tr>
                    <th>User Name:</th>
                    <td>
                        <input type="text" name="name" size="45" value="<c:out value='${user.username}'/>"/>
                    </td>
                </tr>
                <tr>
                    <th>User Email:</th>
                    <td>
                        <input type="text" name="email" size="45" value="<c:out value='${user.email}' />" />
                    </td>
                </tr>
                <tr>
                    <th>Country:</th>
                    <td>
                        <input type="text" name="country" size="15" value="<c:out value='${user.country}' />"/>
                    </td>
                </tr>
                <tr>
                    <th>Role:</th>
                    <td>
                        <input type="radio" name="role" value="admin"
                               ${user.role == 'Admin' ? 'checked' : ''}> Admin
                        <input type="radio" name="role" value="user"
                               ${user.role == 'User' ? 'checked' : ''}>User
                    </td>
                </tr>
                <tr>
                    <th>Status:</th>
                    <td>
                        <input type="radio" name="status" value="1" checked> Active
                        <input type="radio" name="status" value="0"> Inactive
                    </td>
                </tr>
                <tr>
                    <th>Password:</th>
                    <td>
                        <input type="password" name="password" size="15" value="<c:out value='${user.password}' />"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
