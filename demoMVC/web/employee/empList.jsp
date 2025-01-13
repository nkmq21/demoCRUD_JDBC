<%-- 
    Document   : listEmp
    Created on : Jan 13, 2025, 9:44:34 AM
    Author     : nkmq21
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee List</title>
    </head>
    <body>
        <h1>Employees List</h1>
        <table border = "1">
            <tr>
                <td>ID</td>
                <td>Name</td>
                <td>Email</td>
                <td>Address</td>
            </tr>

            <c:forEach var ="employee" items ="${employeeList}">
                <tr>
                    <td>${employee.id}</td>
                    <td>${employee.name}</td>
                    <td>${employee.email}</td>
                    <td>${employee.address}</td>
                    <td>
                        <!-- this line create a hyper to navigate user to the edit page of the specific employee -->
                        <a href="empservlet? action=edit & id=${employee.id}">Edit</a>
                    </td>
                </tr>
            </c:forEach>

        </table>
    </body>
</html>
