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
				<div class="myicon" style="margin-right: 150px;">
					<input type="text" value="${user.userId}" style="display: none">
					<a href="./user.jsp"><img src="../photos/user_photo.jpg" style="height: 40px;" alt="个人中心"></a>
				</div>
				<div id="write"><a href="../views/write.jsp"><button class="btn btn-default" style="margin-right: 30px;margin-top: 10px; font-size: 19px; color: #FFF; background-color: #ed664c; height: 45px;">写文章</button></a></div>
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
					<h3 style="float: left;">${user.username}</h3>
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
					<span><a target="bottom" href="./myessay.jsp">我的文章</a></span>
				</li>
				<li class="layui-nav-item" >
					<a target="bottom" href="userinfo_getComment.action?id=${user.userId}">评论</a>
				</li>
				<li class="layui-nav-item">
					<div class="dropdown">
						<span class="dropbtn">我</span>
						<div class="dropdown-content">
							<a target="bottom" href="userinfo_getMyinfo.action?id=${user.userId}">我的信息</a>
							<a href="logout.action">退出</a>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</div>
	<div style="margin-left: 25%;">
	<iframe src="./myessay.jsp"
			id="all" name="bottom" scrolling="no" frameborder="0" style="width: 100%;height: 800px;"></iframe>
	</div>
</body>
</html>