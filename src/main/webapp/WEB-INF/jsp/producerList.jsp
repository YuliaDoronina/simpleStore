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
    </tr>
    </thead>

    <c:forEach items="${producerList}" var="producer">
        <tr>
            <jsp:useBean id="producer" class="org.store.webapp.model.Producer"/>
            <td>${producer.id}</td>
            <td>${producer.name}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
