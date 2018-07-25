<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="../css/bootstrap-3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/yl.css">
    <link rel="stylesheet" href="../css/user.css">
    <link rel="stylesheet" href="../css/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="../css/essay.css">
    <script src="../css/layui/layui.js"></script>
    <script src="../js/jquery-3.2.1.min.js"></script>
    <link href="../image/icon.png" rel="shortcut icon"/>
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
            <form method="post" action="search.action">
                <div class="input-group">
                    <input type="text" placeholder="搜索" class="form-control" id="inputGroupSuccess2"
                           name="keyword.keyword" aria-describedby="inputGroupSuccess2Status">
                    <span class="input-group-addon" style="background: #FFFFFF; border-color: #ed664c;"><button
                            style="border: none; background: transparent;color: #ed664c" type="submit">搜索</button></span>
                </div>
            </form>
        </div>
    </div>
    <div id="event">
        <c:if test="${not empty user}">
            <div class="box">
                <div class="myicon">
                    <input type="text" value="${user.userId}" style="display: none">
                    <a href="./user.jsp"><img src="../photos/user_photo.jpg"
                                                                              style="height: 40px;" alt="个人中心"></a>
                </div>
                <div id="write"><a href="../views/write.jsp">
                    <button class="btn btn-default">写文章</button>
                </a></div>
            </div>
        </c:if>
        <c:if test="${empty user}">
        <div style="margin-top: -28px;margin-right: 30px;">
            <a href="login.jsp">
                <button id="log" class="btn-default" style="border:none; font-size: 19px;margin-right: 20px;">登录
                </button>
            </a>
            <a href="register.jsp">
                <button class="btn btn-info"
                        style="font-size: 19px;width: 83px;-webkit-border-radius: 2em;moz-border-radius: 2em;border-radius: 2em;">
                    注册
                </button>
            </a>
            </c:if>
        </div>

    </div>
</div>
<div class="container">
    <div id="essay-toall" style="margin-top: 30px;">
        <c:choose>
            <c:when test="${not empty etxt}">
                <c:forEach var="etxt" items="${etxt}" varStatus="vs">
                    <h1 style="text-align: center;"><strong>${etxt.essayname}</strong></h1>
                    <h4 style="text-align: right;"><a href="otheruser.action?id=${euser.userId}"><span
                            id="username">${euser.username}</span></a>
                        <span id="day">${etxt.time}</span></h4>
                    <p id="essayall" style="font-size: 22px;margin-top: 40px;margin-bottom: 22px;">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${etxt.text}
                    </p>
                </c:forEach>
            </c:when>
        </c:choose>
    </div>

    <div id="wcomment">
        <form action="addCommentAction" method="post">
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">
                    <a href="#" style="float: left;"><img src="../photos/user_photo.jpg" alt=""></a>
                </label>
                <div class="layui-input-block">
                    <textarea name="aaa" placeholder="写下您的评论" class="layui-textarea"></textarea>

                </div>
                <%--<input type="button" name="essayId" value="${etxt.essayId}" style="display: none;">
                <input type="button" name="essayname" value="${etxt.essayname}" style="display: none;">--%>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" type="submit">发表</button>
                        <button type="reset" class="layui-btn layui-btn-primary">取消</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
    <div id="comment">
        <h3 id="cCount">评论</h3>
        <div id="comments">
            <ul>
                <c:choose>
                    <c:when test="${not empty user_allComment}">
                        <c:forEach var="result" items="${user_allComment}" varStatus="vs">
                            <li>
                                <h4><span id="user">${result.username}</span></h4>
                                <h5><span id="time">${result.cdate}</span></h5>
                                <p><span id="info">${result.ccontent}</span></p>
                            </li>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <li style="border-bottom:1px solid #eee; font-size: 23px; ">没有结果</li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
    <div id="bottom">
        <span>关于言论</span>
        <span>联系我们</span>
    </div>
</div>
</body>
</html>