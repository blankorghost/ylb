<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>言论&nbsp;-&nbsp;搜索</title>
	<link rel="stylesheet" href="../css/bootstrap-3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="../css/yl.css">
	<link rel="stylesheet" href="../css/user.css">
	<link rel="stylesheet" href="../css/layui/css/layui.css" media="all">
	<script src="../css/layui/layui.js"></script>
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
            <form method="post" action="search.action">
                <div class="input-group">
                    <input type="text" placeholder="搜索" class="form-control" id="inputGroupSuccess2" name="keyword.keyword" aria-describedby="inputGroupSuccess2Status">
                    <span class="input-group-addon" style="background: #FFFFFF; border-color: #ed664c;" ><button type="submit" style="border: none; background: transparent;color: #ed664c">搜索</button></span>
                </div>
            </form>
        </div>
    </div>
    <div id="event">
        <c:if test="${not empty user}">
            <div class="box" >
                <div class="myicon" >
                    <input type="text" value="${user.userId}" style="display: none">
                    <a href="./user.jsp"><img src="../photos/user_photo.jpg" style="height: 40px;" alt="个人中心"></a>
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
	<div class="container" >
		<ul id="" style="margin-top: 110px;">
            <c:choose>
                <c:when test="${not empty searchresult}">
                <c:forEach var="result" items="${searchresult}" varStatus="vs">
                    <div class="essay-part" style="margin-top: 50px;" >
                        <li style="border-bottom:1px solid #eee; font-size: 30px; ">
                            <a href="w_getEssayByEid?essayId=${result.essayId}"><h2><strong>${result.essayname}</strong></h2></a>
                            <p style="font-size: 18px; ">&nbsp;&nbsp;&nbsp;&nbsp;${result.text}</p>
                        </li>
                    </div>

                </c:forEach>
                </c:when>
                <c:otherwise>
                    <li  style="border-bottom:1px solid #eee; font-size: 30px; ">没有结果</li>
                </c:otherwise>
            </c:choose>
			</ul>
		</div>
</body>
</html>