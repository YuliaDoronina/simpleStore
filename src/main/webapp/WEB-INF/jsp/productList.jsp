<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table cellspacing="0" cellpadding="5" border="1">
    <thead>
    <tr>
        <td>id</td>
        <td>Name</td>
        <td>Price</td>
        <td>Description</td>
        <td>Flag</td>
    </tr>
    </thead>

    <c:forEach items="${productList}" var="product">
        <tr>
            <jsp:useBean id="product" class="org.store.webapp.model.Product"/>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.description}</td>
            <td>${product.flag}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
