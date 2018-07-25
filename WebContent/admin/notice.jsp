<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>公告管理</title>
	<link rel="stylesheet" href="../css/bootstrap-3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="../css/layui/css/layui.css" media="all">
</head>
<body>
	<div class="container">
		<div class="layui-container">  
			<div class="layui-row">
			    <div class="layui-col-md6">
			      <span >公告内容</span>
			      <hr>
			    </div>
			    <div class="layui-col-md6">
			      <span >发布时间</span>
			      <hr>
			    </div>
			</div>
	  	</div>
	  	<div class="layui-fluid">
			<form action="writeNoticeAction" method="post">
			<div class="layui-row">
			    <div class="layui-col-sm6">
			      <div class="grid-demo grid-demo-bg1">
			      	<span id="info"><textarea name="bbb">请写下你的公告</textarea></span>
			      </div>
			    </div>
			    <%--<div class="layui-col-sm4">
			      <div class="grid-demo">
					<span id="data">2017-1-1</span>
			      </div>
			    </div>--%>
			    <div class="layui-col-sm6">
			      <div class="grid-demo">
					<button class="layui-btn" lay-submit lay-filter="formDemo">发布</button>
			      </div>
			    </div>
			</div>
			</form>
		</div>
		<hr>
	</div>
</body>
</html>