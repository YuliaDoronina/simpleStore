<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link href="<c:url value="/static/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/static/css/app.css" />" rel="stylesheet">

    <title>Index Admin</title>
</head>
<body>
<div class="generic-container">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>#</th>
            <th>Section name</th>
            <th>Edit</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th scope="row">1</th>
            <td>Category</td>
            <td><a href="<c:url value='/admin/categories' />"
                   class="btn btn-success custom-width">DETAILS</a></td>
        </tr>
        <tr>
            <th scope="row">2</th>
            <td>Subcategory</td>
            <td><a href="<c:url value='/admin/subcategories' />"
                   class="btn btn-success custom-width">DETAILS</a></td>
        </tr>
        <tr>
            <th scope="row">3</th>
            <td>Producer</td>
            <td><a href="<c:url value='/admin/producers' />"
                   class="btn btn-success custom-width">DETAILS</a></td>
        </tr>
        <tr>
            <th scope="row">4</th>
            <td>Product</td>
            <td><a href="<c:url value='/admin/products' />"
                   class="btn btn-success custom-width">DETAILS</a></td>
        </tr>
        </tbody>
    </table>
</div>

</body>
</html>
