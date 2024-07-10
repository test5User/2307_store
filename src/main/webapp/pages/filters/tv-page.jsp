<%@ page import="by.itclass.constants.AppConst" %>
<%@ page import="by.itclass.constants.JspConst" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Tv Page</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <jsp:include page="<%=JspConst.MENU_JSP%>"/>
    <jsp:include page="/pages/filters/tv-filter.html"/>
    <c:choose>
      <c:when test="${not empty tvs}">
        <c:forEach var="tv" items="${tvs}">
          <div class="stock-item-box">
            <img class="small-image" src="/img/tv/${tv.vendor}-${tv.model}.jpg">
            <p>Vendor ${tv.vendor}</p>
            <p>Model ${tv.model}</p>
            <p>Price ${tv.price}</p>
          </div>
        </c:forEach>
      </c:when>
      <c:otherwise>
        <h1>Sorry the search returned empty result</h1>
      </c:otherwise>
    </c:choose>
</body>
</html>
