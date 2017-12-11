<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link href="<c:url value="/static/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/static/css/app.css" />" rel="stylesheet">

    <title>Categories</title>
</head>
<body>
<div class="generic-container">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>id</th>
            <th>Name</th>
            <th colspan="2">Edit</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${categoryList}" var="category">
            <tr>
                <jsp:useBean id="category" class="org.store.webapp.model.Category"/>
                <td>${category.idCategory}</td>
                <td>${category.typeCategory}</td>
                <td><a href="<c:url value='/admin/categories/update?id=${category.idCategory}' />"
                       class="btn btn-info custom-width">UPDATE</a></td>
                <td><a href="<c:url value='/admin/categories/delete?id=${category.idCategory}' />"
                       class="btn btn-danger custom-width">DELETE</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="4"><a href="/admin/categories/create">CREATE NEW ONE</a></td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>