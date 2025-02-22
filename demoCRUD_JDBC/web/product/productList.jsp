<!-- productList.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Product List</title>
        <style>
            body {
                text-align: center;
                justify-items: center;
            }
            .bang-product {
                margin-bottom: 2%;
            }
        </style>
    </head>
    <body>
        <h2 class="tieu-de">Product List</h2>

        <h2>
            <a href="products?action=insert">Add New Product</a>
        </h2>

        <%-- Thiết lập số sản phẩm hiển thị trên mỗi trang --%>
        <c:set var="pageSize" value="10"/>
        <c:set var="currentPage" value="${param.page != null ? param.page : 1}"/>
        <c:set var="start" value="${(currentPage - 1) * pageSize}"/>
        <c:set var="end" value="${start + pageSize}"/>
        <c:set var="totalProducts" value="${products.size()}"/>
        <c:set var="totalPages" value="${Math.ceil(totalProducts / pageSize)}"/>
        <table border="1" class="bang-product">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Description</th>
                <th>Stock</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="product" items="${products}" varStatus="status">
                <c:if test="${status.index >= start && status.index < end}">
                    <tr>
                        <td>${product.id}</td>
                        <td>${product.name}</td>
                        <td>${product.price}</td>
                        <td>${product.description}</td>
                        <td>${product.stock}</td>
                        <td>
                            <a href="products?action=edit&id=${product.id}">Edit</a>
                            <a href="products?action=delete&id=${product.id}">Delete</a>
                        </td>
                    </tr>
                </c:if>
            </c:forEach>
        </table>
        <!-- Phân trang -->
        <div>
            <c:if test="${currentPage > 1}">
                <a href="products?page=${currentPage - 1}">Previous</a>
            </c:if>

            <c:forEach var="i" begin="1" end="${totalPages}">
                <a href="products?page=${i}">${i}</a>
            </c:forEach>

            <c:if test="${currentPage < totalPages}">
                <a href="products?page=${currentPage + 1}">Next</a>
            </c:if>
        </div>
    </body>