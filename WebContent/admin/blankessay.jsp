<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pangdahai
  Date: 1/5/18
  Time: 2:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文章</title>
</head>
<body>
<c:choose>
    <c:when test="${not empty etxt}">
        <c:forEach var="etxt" items="${etxt}" varStatus="vs">
            <h1 style="text-align: center;">${etxt.essayname}</h1>
            <p>
                    ${etxt.text}
            </p>
            <h4><span>${etxt.time}</span></h4>
        </c:forEach>
    </c:when>
</c:choose>
</body>
</html>
