<%-- 
    Document   : insertProduct
    Created on : Feb 13, 2025, 3:32:32 PM
    Author     : nkmq21
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Page</title>
    </head>
    <body>
        <div align="center">
            <form method="post">
                <table border="1" cellpadding="5">
                    <caption>
                        <h2>Add New Product</h2>
                    </caption>
                    <tr>
                        <th>Product Name:</th>
                        <td>
                            <input type="text" name="name" id="name" size="45"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Product Price:</th>
                        <td>
                            <input type="number" step="0.01" name="price" id="price" size="45"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Description:</th>
                        <td>
                            <input type="text" name="description" id="description" size="15"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Stock:</th>
                        <td>
                            <input type="number" name="stock" id="stock" size="15"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Import Date:</th>
                        <td>
                            <input type="date" name="import_date" id="import_date" size="15"/>
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
