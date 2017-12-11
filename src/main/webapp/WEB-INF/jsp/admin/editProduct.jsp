<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link href="<c:url value="/static/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/static/css/app.css" />" rel="stylesheet">

    <title>Edit product</title>
</head>
<body>
<form method="post" action="./">
    <jsp:useBean id="product" scope="request" class="org.store.webapp.model.Product"/>
    <input type="hidden" name="idProduct" value="${product.idProduct}">

    <div class="form-group row">
        <label class="col-2 col-form-label">Name</label>
        <div class="col-10">
            <input class="form-control"
                   type="text"
                   required placeholder="enter name"
                   name="nameProduct"
                   value="${product.nameProduct}">
        </div>
    </div>
    <div class="form-group row">
        <label class="col-2 col-form-label">Price</label>
        <div class="col-10">
            <input class="form-control"
                   type="text"
                   required placeholder="enter price"
                   name="priceProduct"
                   value="${product.priceProduct}">
        </div>
    </div>
    <div class="form-group row">
        <label class="col-2 col-form-label">Description</label>
        <div class="col-10">
            <input class="form-control"
                   type="text"
                   required placeholder="enter description"
                   name="descriptionProduct"
                   value="${product.descriptionProduct}">
        </div>
    </div>
    <div class="form-group row">
        <label class="col-2 col-form-label">Flag</label>
        <div class="col-10">
            <select  class="form-control" required name="flagProduct" value="${product.flagProduct}">
                <option selected>Choose...</option>
                <option value="true">true</option>
                <option value="false">false</option>
            </select>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-2 col-form-label">Subcategory</label>
        <div class="col-10">
            <select class="form-control" required name="nameSubcategory">
                <option selected>Choose...</option>
                <c:forEach var="subcategory" items="${product.valueSubcategory}">
                    <jsp:useBean id="subcategory" class="org.store.webapp.model.Subcategory"/>
                    <option value="${subcategory.idSubcategory}">${subcategory.nameSubcategory}</option>
                </c:forEach>
            </select>
        </div>
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>
