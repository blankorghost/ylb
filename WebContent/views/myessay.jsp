<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pangdahai
  Date: 1/4/18
  Time: 10:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>个人主页</title>
    <link rel="stylesheet" href="../css/bootstrap-3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/yl.css">
    <link rel="stylesheet" href="../css/user.css">
    <link rel="stylesheet" href="../css/layui/css/layui.css" media="all">
    <script src="../css/layui/layui.js"></script>
    <script src="../js/jquery-3.2.1.min.js"></script>
    <script src="../js/user.js"></script>
    <link href="../image/icon.png" rel="shortcut icon" />
</head>
<body>
<div id="myessay">
    <ul>
        <c:if test="${not empty essayList}">
            <c:forEach var="Essay" items="${sessionScope.essayList}" varStatus="vs">
                <li>
                    <a target="_blank" href="w_getEssayByEid?essayId=${Essay.essayId}"><h3><span>《</span>${Essay.essayname}<span>》</span></h3></a><br>
                    <%--<a href="#"><button class="btn btn-default">删除</button></a>--%>
                </li>
            </c:forEach>
        </c:if>
        <c:if test="${empty essayList}">
            <li>
                <h4><span>您还没发表过文章，写一篇吧</span></h4><br>
            </li>
        </c:if>
    </ul>
</div>
</body>
</html>
