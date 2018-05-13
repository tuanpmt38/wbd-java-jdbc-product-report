<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: minhtuan
  Date: 5/13/18
  Time: 9:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Products Sales Report</h1>

<table border="1">
    <tr>
        <td>Product Line</td>
        <td>Product Vendor</td>
        <td>Product Code</td>
        <td>ProductName</td>
        <td>Quantity Ordered</td>
        <td>Price Each</td>
        <td>Order Status</td>
        <td>Order From City</td>
    </tr>
    <c:forEach items='${requestScope["salesReport"]}' var="reportItem">
        <tr>
            <td>${reportItem.getGetProductLine()}</td>
            <td>${reportItem.getProductVendor()}</td>
            <td><a href="/products?action=view&code=${reportItem.getProductCode()}">${reportItem.getProductCode()}</a></td>
            <td>${reportItem.getProductName()}</td>
            <td>${reportItem.getQuantityOrdered()}</td>
            <td>${reportItem.getPriceEach()}</td>
            <td>${reportItem.getOrderStatus()}</td>
            <td>${reportItem.getOrderFromCity()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</body>
</html>
