<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link href="<c:url value="/static/css/select.css" />" rel="stylesheet">
    <script type="text/javascript" src="<c:url value="/static/js/jquery/3.2/jquery-3.2.1.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/static/js/editorSelectRootController.js" />"></script>

    <title>Start</title>
</head>
<body>
<div class="vend-iframe">
    <div class="vd-modal-container">
        <div class="vd-modal-top">
            <h2>Store</h2>
            <div class="vd-field">
                <div class="vd-label">Select Category</div>
                <div class="vd-select-container">
                    <select class="vd-select" id="category">
                        <jsp:useBean id="category" class="org.store.webapp.model.Category"/>
                        <c:forEach items="${categories}" var="categories">
                            <option value="${categories.idCategory}">
                                    ${categories.typeCategory}
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <div class="vd-modal-bottom">
                    <button class="vd-button-small vd-color-primary" id="btnSortByCategory">Sort By Category
                    </button>
                </div>
            </div>

            <div class="vd-field">
                <div class="vd-label">Select Subcategory</div>
                <div class="vd-select-container">
                    <select class="vd-select" id="subcategory">
                        <option value="">-----Select-----</option>
                    </select>
                </div>
                <div class="vd-modal-bottom">
                    <button class="vd-button-small vd-color-primary" id="btnSortByPriceProduct">Sort By Price
                    </button>
                    <button class="vd-button-small vd-color-primary" id="btnSortByFlagProduct">Sort By Flag
                    </button>
                </div>
            </div>

            <div class="vd-field">
                <div class="vd-label">Select Producer</div>
                <div class="vd-select-container">
                    <select class="vd-select" id="producer">
                        <option value="">-----Select-----</option>
                    </select>
                </div>
                <%--TODO: sor product for producer--%>
                <div class="vd-modal-bottom">
                    <button class="vd-button-small vd-color-primary" id="test1">Sort By Price
                    </button>
                    <button class="vd-button-small vd-color-primary" id="test2">Sort By Flag
                    </button>
                </div>
            </div>

            <div class="vd-field">
                <div class="vd-label">Select Product</div>
                <div class="vd-select-container">
                    <select class="vd-select" id="product">
                        <option value="">-----Select-----</option>
                    </select>
                </div>
            </div>
        </div>
    </div>
</div>

<%--TODO: create new login page for admin--%>
<div class="vend-iframe2">
    <div class="vd-modal-container">
        <div class="vd-modal-top">
            <h2>For security</h2>
            <div class="vd-field">
                <div class="vd-label">Login</div>
                <div class="vd-select-container">
                    <div class="vd-value">
                        <input class="vd-input" placeholder="Enter login">
                    </div>
                </div>
            </div>
            <div class="vd-field">
                <div class="vd-label">Password</div>
                <div class="vd-select-container">
                    <div class="vd-value">
                        <input class="vd-input" placeholder="Enter password">
                    </div>
                </div>
            </div>
        </div>
        <div class="vd-modal-bottom">
            <button class="vd-button-small vd-color-primary">Next</button>
        </div>
    </div>
</div>

<input type="button" id="btnSort" Value="Sort By Category"/>
</body>
</html>