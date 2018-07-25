<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>写作</title>
	<link rel="stylesheet" href="../css/bootstrap-3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="../css/yl.css">
	<link rel="stylesheet" href="../css/layui/css/layui.css" media="all">
	<script src="../css/layui/layui.js"></script>

	<link rel="stylesheet" href="../kindeditor/themes/default/default.css"/>
	<script charset="utf-8" src="../kindeditor/kindeditor-all-min.js"></script>
	<script charset="utf-8" src="../kindeditor/lang/zh-CN.js"></script>

    <script>
        kindeditor.ready(function(K) {
                window.editor = K.create('#editor_id');
        });
</script>
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
					<a href=./user.jsp><img src="../photos/user_photo.jpg" style="height: 40px;" alt="个人中心"></a>
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
	<div id="writeessay" style="width:100%; margin-left: 30%;margin-right: 30%;margin-top: 80px;">
		<form method="post" action="w_writes.action">
			<label>标题：</label>
			<div class="content">
				<textarea id="ename" name="ename"
						  style="height:40px;width:200px;">在这里输入标题...</textarea>
			</div>
			<div class="content">
            <textarea id="editor_id" name="etext"
					  style="height:300px; width:600px;">在这里输入内容...</textarea>
			</div>
			<div class="btn btn-default" style="...">
				<input type="submit" value="确定"/>
			</div>
			<div class="btn btn-default" style="...">
				<input type="reset" value="重置"/>
			</div>
		</form>
	</div>
	<hr>
	<div class="container">
		<div id="bottom">
			<span>关于言论</span>
			<span>联系我们</span>
		</div>
	</div>
</body>
</html>

<script charset="utf-8" src="../kindeditor/kindeditor-all.js"></script>
<script charset="utf-8" src="../kindeditor/lang/zh-CN.js"></script>
<script>
    KindEditor.ready(function(K) {
        window.editor = K.create('#editor_id',
		{
		    cssPath:'../kindeditor/plugins/code/prettify.css',
				uploadJson:'/upload/image/php',
				resizeType :1,
				allowPreviewEmoticons : true,
				allowImageUpload : true,
		});
    });
</script>