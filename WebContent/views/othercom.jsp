<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pangdahai
  Date: 1/4/18
  Time: 10:46 AM
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
<div id="othercom">
    <ul>
        <c:if test="${not empty commentList}">
            <c:forEach var="Comment" items="${commentList}" varStatus="vs">
                <li>
                    <h5>${Comment.cdate}评论了</h5>
                    <h4><span></span>《${Comment.cessay}》<span></span></h4>
                    <br>
                    <p style="font-size: 18px;">${Comment.ccontent}</p>
                </li>
            </c:forEach>
        </c:if>
        <c:if test="${empty commentList}">
            <li>
                <h4><span>您还没有评论</span></h4>
            </li>
        </c:if>
    </ul>
</div>
</body>
</html>
