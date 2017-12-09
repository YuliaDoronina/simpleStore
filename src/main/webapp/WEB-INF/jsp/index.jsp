<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Start</title>
    <script type="text/javascript" src="<c:url value="/static/js/jquery/3.2/jquery-3.2.1.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/static/js/selectSubcategory.js" />"></script>
</head>
<body>
<h1>Hello!</h1>

<select id="category" title="Category">
    <jsp:useBean id="category" class="org.store.webapp.model.Category"/>
    <option selected disabled hidden>Choose category</option>
    <c:forEach items="${categories}" var="category1">
        <option value="${category1.id}">
                ${category1.name}
        </option>
    </c:forEach>
</select>
<input type="button" id="btnSort" Value="Sort By Category"/>
<br/><br/><br/><br/><br/>

<select id="subcategory" title="Subcategory" <%--style="display:none"--%>>
    <option selected disabled hidden>Choose here</option>
    <option value="test" onchange="getSubcategory(this)"></option>
</select>

<select id="producer" title="Producer" <%--style="display:none"--%>>
    <option selected disabled hidden>Choose here</option>
    <option value="test" onchange="getProducer(this)"></option>
</select>
<br/><br/><br/><br/><br/>

<select id="product" title="Product">
    <option selected disabled hidden>Choose here</option>
    <option value="test" onchange="getSubcategory(this)" <%--style="display:none"--%>></option>
</select>
<input type="button" id="btnSortByPriceProduct" Value="Sort By Price"/>
<input type="button" id="btnSortByFlagProduct" Value="Sort By Flag"/>

</body>
</html>
