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
        <td>Id category</td>
        <td>Category name</td>
    </tr>
    </thead>

    <c:forEach items="${subcategoryList}" var="subcategory">
        <tr>
            <jsp:useBean id="subcategory" class="org.store.webapp.model.Subcategory"/>
            <td>${subcategory.id}</td>
            <td>${subcategory.name}</td>
            <td>${subcategory.idCategory.}</td>
            <td>${subcategory.category.name}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
