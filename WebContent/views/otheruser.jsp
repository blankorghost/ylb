<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
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
<body class="bgcolor">
<div id="head" class="form-horizontal">
    <a href="../index.jsp">
        <div id="toplogo">
            <img src="../image/toplogo.png">
        </div>
    </a>
    <div id="search" class="form-group has-success has-feedback" style="margin-top: 10px;">
        <div class="input-group">
            <div class="input-group">
                <input type="text" placeholder="搜索" class="form-control" id="inputGroupSuccess2" name="keyword.keyword" aria-describedby="inputGroupSuccess2Status">
                <span class="input-group-addon" style="background: #FFFFFF; border-color: #ed664c;" ><button style="border: none; background: transparent;color: #ed664c">搜索</button></span>
            </div>
        </div>
    </div>
    <div id="event">
        <c:if test="${not empty user}">
            <div class="box" >
                <div class="myicon" >
                    <input type="text" value="${user.userId}" style="display: none">
                    <a href="userinfo_getEssay.action?id=${user.userId}"><img src="../photos/user_photo.jpg" style="height: 40px;" alt="个人中心"></a>
                </div>
                <div id="write"><a href="../views/write.jsp"><button class="btn btn-default">写文章</button></a></div>
            </div>
        </c:if>
        <c:if test="${empty user}">
        <div  style="margin-top: -28px;margin-right: 30px;">
            <a href="login.jsp"><button id="log" class="btn-default" style="border:none; font-size: 19px;margin-right: 20px;">登录</button></a>
            <a href="register.jsp"><button class="btn btn-info" style="font-size: 19px;width: 83px;-webkit-border-radius: 2em;moz-border-radius: 2em;border-radius: 2em;">注册</button></a>
            </c:if>
        </div>

    </div>
</div>
<div class="container">
    <div id="user">
        <div id="info">
            <a href="#" style="float: left;"><img src="../photos/user_photo.jpg" alt=""></a>
            <br>
            <div>
                <h3 style="float: left;">${otheruser.username}</h3>
                <br>
                <br>
                <br>
                <br>
            </div>
        </div>
    </div>
    <div id="nav">
        <ul class="layui-nav">
            <li class="layui-nav-item">
                <a href="#">他的文章</a>
            </li>
        </ul>
    </div>
    <div id="myessay">
        <ul>
            <c:choose>
            <c:when test="${not empty oessayList }">
                <c:forEach var="oessayList" items="${oessayList }" varStatus="vs">
                    <li>
                        <a target="_blank" href="w_getEssayByEid?essayId=${oessayList.essayId}"><h4><span>《</span>${oessayList.essayname}<span>》</span></h4></a><br>
                            <%--<a href="#"><button class="btn btn-default">删除</button></a>--%>
                    </li>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <li>
                    <h4><span>他还没发表过文章</span></h4><br>
                </li>
            </c:otherwise>
            </c:choose>
        </ul>
    </div>
</div>
</body>
</html>