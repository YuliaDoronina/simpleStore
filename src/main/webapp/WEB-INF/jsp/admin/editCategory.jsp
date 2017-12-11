<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link href="<c:url value="/static/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/static/css/app.css" />" rel="stylesheet">

    <title>Edit category</title>
</head>
<body>
<form method="post" action="./">
    <jsp:useBean id="category" scope="request" class="org.store.webapp.model.Category"/>
    <input type="hidden" name="idCategory" value="${category.idCategory}">

    <div class="form-group row">
        <label for="example-text-input" class="col-2 col-form-label">Name</label>
        <div class="col-10">
            <input class="form-control" id="example-text-input"
                   type="text"
                   required placeholder="enter name"
                   name="typeCategory"
                   value="${category.typeCategory}">
        </div>
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>
