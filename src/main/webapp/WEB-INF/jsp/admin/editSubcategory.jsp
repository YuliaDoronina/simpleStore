<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link href="<c:url value="/static/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/static/css/app.css" />" rel="stylesheet">

    <title>Edit subcategory</title>
</head>
<body>
<form method="post" action="./">
    <jsp:useBean id="subcategory" scope="request" class="org.store.webapp.model.Subcategory"/>
    <input type="hidden" name="idSubcategory" value="${subcategory.idSubcategory}">

    <div class="form-group row">
        <label for="example-text-input" class="col-2 col-form-label">Text</label>
        <div class="col-10">
            <input class="form-control" id="example-text-input"
                   type="text"
                   required placeholder="enter name"
                   name="nameSubcategory"
                   value="${subcategory.nameSubcategory}">
        </div>
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>
