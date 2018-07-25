<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>言论</title>
	<link rel="stylesheet" href="./css/bootstrap-3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="./css/yl.css">
	<link rel="stylesheet" href="./css/layui/css/layui.css" media="all">
	<link rel="stylesheet" href="./css/views.css">
	<script src="./css/layui/layui.js"></script>
    <link href="./image/icon.png" rel="shortcut icon" />
</head>
<body class="bgcolor">
<div id="head" class="form-horizontal">
	<a href="./index.jsp">
        <div id="toplogo">
		    <img src="image/toplogo.png">
	    </div>
    </a>
	<div id="search" class="form-group has-success has-feedback" style="margin-top: 10px;">
		<div class="input-group">
            <a href="/ylb/views/search.jsp">
                <div class="input-group">
                    <input type="text" placeholder="搜索" class="form-control" id="inputGroupSuccess2" name="keyword.keyword" aria-describedby="inputGroupSuccess2Status">
                    <span class="input-group-addon" style="background: #FFFFFF; border-color: #ed664c;" ><button style="border: none; background: transparent;color: #ed664c">搜索</button></span>
                </div>
            </a>
		</div>
	</div>
	<div id="event">
        <c:if test="${not empty user}">
		<div class="box" >
            <div class="myicon" >
				   <input type="text" value="${user.userId}" style="display: none">
				<a href="userinfo_getEssay.action?id=${user.userId}"><img src="./photos/user_photo.jpg" style="height: 40px;" alt="个人中心"></a>
			</div>
            <div id="write"><a href="./views/write.jsp"><button class="btn btn-default">写文章</button></a></div>
        </div>
        </c:if>
        <c:if test="${empty user}">
        <div  style="margin-top: -28px;margin-right: 30px;">
            <a href="views/login.jsp"><button id="log" class="btn-default" style="border:none; font-size: 19px;margin-right: 20px;">登录</button></a>
            <a href="views/register.jsp"><button class="btn btn-info" style="width: 83px;-webkit-border-radius: 2em;moz-border-radius: 2em;border-radius: 2em;">注册</button></a>
        </c:if>
    </div>

	</div>
</div>
<div class="container">
    <%--phtoto：${user.userPhoto}--%>
	<div id="lunbo">
		<div class="layui-carousel" id="test1">
			<div carousel-item>
				<div><img src="./image/index1.png" alt=""></div>
				<div><img src="./image/index2.jpg" alt=""></div>
				<div><img src="./image/index3.jpg" alt=""></div>
				<div><img src="./image/index4.jpg" alt=""></div>
			</div>
		</div>
	</div>
	<div id="main">
		<div id="essay" style="width: 66%;">
	<c:choose>
		<c:when test="${not empty allEssay}">
		<c:forEach var="result" items="${allEssay}" varStatus="vs">
			<div class="essay-all">
					<input name="essayId" value="${result.essayId}" style="display: none">
					<a href="w_getEssayByid.action?essayId=${result.essayId}"><strong>${result.essayname}</strong></a>
				<p class="essay-part">&nbsp;&nbsp;&nbsp;&nbsp;${result.text}</p>
			</div>
		</c:forEach>
		</c:when>
		<c:otherwise>
			<li  style="border-bottom:1px solid #eee; font-size: 30px; ">没有结果</li>
		</c:otherwise>
	</c:choose>
		</div>
		<div id="other">
			<div class="otherall">
				<p><strong>言论公告</strong></p>
				<p id="notice" style="line-height: 20px;"><span>&nbsp;&nbsp;${notice}</span></p>
			</div>
		</div>
	</div>
	<div id="bottom">
		<span>关于言论</span>
		<span>&nbsp;&nbsp;</span>
		<span>联系我们</span><br>
		<span>QQ326456</span><br>
		<span>@yl版权所有</span>
	</div>
</div>
<script>
    layui.use('carousel', function(){
        var carousel = layui.carousel;
        //建造实例
        carousel.render({
            elem: '#test1'
            ,width: '100%'
            ,arrow: 'hover'
        });
    });
</script>
</body>
</html>
