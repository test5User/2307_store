<%@ page import="by.itclass.constants.AppConst" %>
<%@ page import="by.itclass.constants.JspConst" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Order History</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <jsp:include page="<%=JspConst.MENU_JSP%>"/>
    <h2>Hello ${user.name}</h2>
    <c:choose>
        <c:when test="${not empty orders}">
            <c:forEach var="order" items="${orders}">
                <div class="order-list-container">
                    <h3>${order.date}, number ${order.id}, address ${order.address}</h3>
                    <form method="post" action="<%=AppConst.PRINT_ORDER_CONTROLLER%>">
                        <input type="hidden" name="<%=JspConst.ORDER_ID_ATTR%>" value="${order.id}">
                        <input type="submit" value="Print Order">
                    </form>
                </div>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <p>You have no orders at present</p>
        </c:otherwise>
    </c:choose>
</body>
</html>
