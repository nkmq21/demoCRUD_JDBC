<%-- 
    Document   : empEdit
    Created on : Jan 13, 2025, 9:20:40 PM
    Author     : nkmq21
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Page</title>
    </head>
    <body>
        <h1>Employee update</h1>
        
        <c:if test="${not empty employee}">
            <form action="empservlet?action=update" method="post">
                <label for="userID" >User ID: </label>
                <input type="number" id="userID" name="userID" value="${employee.id}">
                <br>

                <label for="userName" >Username </label>
                <input type="text" id="userName" name="userName" value="${employee.name}">
                <br>

                <label for="userEmail" >User email: </label>
                <input type="email" id="userEmail" name="userEmail" value="${employee.email}">
                <br>

                <label for="userAddress" >User address: </label>
                <input type="text" id="userAddress" name="userAddress" value="${employee.address}">
                <br>

                <button type="submit" value="Save">Save user profile</button>
            </form>
        </c:if>


    </body>
</html>
