<%-- 
    Document   : empRemove
    Created on : Jan 14, 2025, 6:25:36 PM
    Author     : nkmq21
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <c:if test="${not empty errorMes}">
            <div style="color: red">
                <strong>
                    <c:out value="${errorMes}"/>
                </strong>
            </div>
        </c:if>

        <form action="${pageContext.request.contextPath}/empservlet?action=remove" method="post">
            <label for="userID" >User ID: </label>
            <input type="number" id="userID" name="userID">
            <br>
            <button type="submit" value="remove">Remove</button>
        </form>
    </body>
</html>
