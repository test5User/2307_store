<%@ page import="by.itclass.constants.AppConst" %>
<%@ page import="by.itclass.constants.JspConst" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Laptop Page</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
<jsp:include page="<%=JspConst.MENU_JSP%>"/>
<jsp:include page="/pages/filters/laptop-filter.html"/>
<c:choose>
    <c:when test="${not empty laptops}">
        <c:forEach var="laptop" items="${laptops}">
            <div class="stock-item-box">
                <img class="small-image" src="/img/laptop/${laptop.vendor}-${laptop.model}.jpg">
                <p>Vendor ${laptop.vendor}</p>
                <p>Model ${laptop.model}</p>
                <p>Price ${laptop.price}</p>
            </div>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <h1>Sorry the search returned empty result</h1>
    </c:otherwise>
</c:choose>
</body>
</html>
