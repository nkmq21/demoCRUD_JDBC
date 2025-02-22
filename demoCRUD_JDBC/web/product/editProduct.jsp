<%-- 
    Document   : editProduct
    Created on : Feb 13, 2025, 3:54:54 PM
    Author     : nkmq21
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Page</title>
    </head>
    <body>
        <div align="center">
            <form method="post">
                <table border="1" cellpadding="5">
                    <caption>
                        <h2>
                            Edit Product
                        </h2>
                    </caption>
                    <c:if test="${product != null}">
                        <input type="hidden" name="id" value="<c:out value='${product.id}' />"/>
                    </c:if>
                    <tr>
                        <th>Product Name:</th>
                        <td>
                            <input type="text" name="name" size="45" value="<c:out value='${product.name}'/>"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Product Price:</th>
                        <td>
                            <input type="number" name="price" step="0.01" size="45" value="<c:out value='${product.price}' />" />
                        </td>
                    </tr>
                    <tr>
                        <th>Product Description:</th>
                        <td>
                            <input type="text" name="description" size="45" value="<c:out value='${product.description}' />"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Product Stock:</th>
                        <td>
                            <input type="number" name="stock" size="45" value="<c:out value='${product.stock}' />" />
                        </td>
                    </tr>
                    <tr>
                        <th>Import Date</th>
                        <td>
                            <input type="date" name="import_date" value="${product.import_date}">
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
