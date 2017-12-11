<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link href="<c:url value="/static/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/static/css/app.css" />" rel="stylesheet">

    <title>Product</title>
</head>
<body>
<div class="generic-container">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>id</th>
            <th>Name</th>
            <th>Price</th>
            <th>Description</th>
            <th>Flag</th>
            <th colspan="2">Edit</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${productList}" var="product">
            <tr>
                <jsp:useBean id="product" class="org.store.webapp.model.Product"/>
                <td>${product.idProduct}</td>
                <td>${product.nameProduct}</td>
                <td>${product.priceProduct}</td>
                <td>${product.descriptionProduct}</td>
                <td>${product.flagProduct}</td>
                <td><a href="<c:url value='/admin/products/update?id=${product.idProduct}' />"
                       class="btn btn-info custom-width">UPDATE</a></td>
                <td><a href="<c:url value='/admin/products/delete?id=${product.idProduct}' />"
                       class="btn btn-danger custom-width">DELETE</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="7"><a href="/admin/products/create">CREATE NEW ONE</a></td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
