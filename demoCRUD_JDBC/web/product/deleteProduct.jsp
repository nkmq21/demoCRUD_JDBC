<%-- 
    Document   : deleteProduct
    Created on : Feb 13, 2025, 9:46:50 PM
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
    <center>
        <h1>Delete User</h1>
        <h2>
            <a href="products">Back to Product list</a>
        </h2>
    </center>

    <div align="center">
        <c:if test="${product != null}">
            <form method="post">
                <input type="hidden" name="id" value="<c:out value='${product.id}' />"/>
                <p>Are you sure you want to delete <strong><c:out value='${product.name}' /></strong>?</p>
                <input type="submit" value="Yes, Delete"/>
                <a href="products?action=delete">
                    <button type="button">Cancel</button>
                </a>
            </form>
        </c:if>
    </div>
</body>
</html>
