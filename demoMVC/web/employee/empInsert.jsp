<%-- 
    Document   : empInsert
    Created on : Jan 14, 2025, 11:34:51 AM
    Author     : nkmq21
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Page</title>
    </head>
    <body>
        <h1>Insert new employee</h1>
        <form action="empservlet?action=insert" method="post">
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

            <button type="submit" value="Save">Save user profile</button>
        </form>
    </body>
</html>
