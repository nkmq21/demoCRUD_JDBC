<%-- 
    Document   : empRemove
    Created on : Jan 14, 2025, 6:25:36 PM
    Author     : nkmq21
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/empservlet?action=insert" method="post">
            <label for="userID" >User ID: </label>
            <input type="number" id="userID" name="userID">
            <br>

            <label for="userName" >Username </label>
            <input type="text" id="userName" name="userName">
            <br>

            <label for="userEmail" >User email: </label>
            <input type="email" id="userEmail" name="userEmail">
            <br>

            <label for="userAddress" >User address: </label>
            <input type="text" id="userAddress" name="userAddress">
            <br>

            <button type="submit" value="Add">Add</button>
        </form>
    </body>
</html>
