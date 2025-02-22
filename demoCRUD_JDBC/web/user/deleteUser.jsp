<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Delete User</title>
    </head>
    <body>
    <center>
        <h1>Delete User</h1>
        <h2>
            <a href="users?action=users">Back to User List</a>
        </h2>
    </center>

    <div align="center">
        <c:if test="${user != null}">
            <form method="post">
                <input type="hidden" name="id" value="<c:out value='${user.id}' />"/>
                <p>Are you sure you want to delete <strong><c:out value='${user.username}' /></strong>?</p>
                <input type="submit" value="Yes, Delete"/>
                <a href="users?action=users">
                    <button type="button">Cancel</button>
                </a>
            </form>
        </c:if>
    </div>
</body>
</html>
