<%@ page import="by.itclass.constants.AppConst" %>
<%@ page import="by.itclass.constants.JspConst" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Cart Page</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <jsp:include page="<%=JspConst.MENU_JSP%>"/>
    <h2>Hello ${user.name}</h2>
    <c:choose>
        <c:when test="${not empty orderItems}">
            <h2>Your cart:</h2>
            <c:forEach var="item" items="${orderItems}">
                <div class="cart-item-container">
                    <img class="cart-img" src="/img/${item.itemType eq 1 ? 'tv' : 'laptop'}/${item.itemVendor}-${item.itemModel}.jpg">
                    <h3 class="cart-text">${item.itemVendor} ${item.itemModel} by ${item.itemPrice} byn.</h3>
                </div>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <p>You have no items in the order</p>
        </c:otherwise>
    </c:choose>
</body>
</html>
