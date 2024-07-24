<%@ page import="by.itclass.constants.AppConst" %>
<%@ page import="by.itclass.constants.JspConst" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home Page</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <jsp:include page="<%=JspConst.MENU_JSP%>"/>
    <c:if test="${not empty message}">
        <h2>${message}</h2>
    </c:if>
    <jsp:include page="/pages/slider/slider.html"/>
    <script src="/js/slider.js"></script>
</body>
</html>
