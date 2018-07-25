<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>评论管理</title>
	<link rel="stylesheet" href="../css/bootstrap-3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="../css/layui/css/layui.css" media="all">
</head>
<body>
	<div class="container" style="line-height: 50px;">
		<div class="layui-container">  
			<div class="layui-row">
			    <div class="layui-col-md2">
			      <span >评论编号</span>
			      <hr>
			    </div>
			    <div class="layui-col-md2">
			      <span >评论人</span>
			      <hr>
			    </div>
			    <div class="layui-col-md2">
			      <span >评论文章</span>
			      <hr>
			    </div>
			    <div class="layui-col-md2">
			      <span >评论内容</span>
			      <hr>
			    </div>
			    <div class="layui-col-md2">
			      <span >评论时间</span>
			      <hr>
			    </div>
			    <div class="layui-col-md2">
			      <span >操作</span>
			      <hr>
			    </div>
			</div>
	  	</div>
		<c:choose>
		<c:when test="${not empty allComment}">
		<c:forEach var="result" items="${allComment}" varStatus="vs">
	  	<div class="layui-fluid">
			<div class="layui-row">
				<div class="layui-col-sm2">
			      <div class="grid-demo grid-demo-bg1">
			      	<span id="cid">${result.cid}</span>
			      </div>
			    </div>
			    <div class="layui-col-sm2">
			      <div class="grid-demo grid-demo-bg1">
			      	<span id="username">${result.username}</span>
			      </div>
			    </div>
			    <div class="layui-col-sm2">
			      <div class="grid-demo">
					《<span id="essays">${result.cessay}</span>》
			      </div>
			    </div>
			    <div class="layui-col-sm2">
			      <div class="grid-demo">
					<span id="ccontent">${result.ccontent}</span>
			      </div>
			    </div>
			    <div class="layui-col-sm2">
			      <div class="grid-demo">
					<span id="data">${result.cdate}</span>
			      </div>
			    </div>
				<form action="delCommentAction" method="post">
			    <div class="layui-col-sm2">
			      <div class="grid-demo">
					  <input type="text" name="ccid" value="${result.cid}" style="display: none;">
					<button class="btn" type="submit">删除</button>
			      </div>
			    </div>
				</form>
			</div>
		</div>
		</c:forEach>
		</c:when>
			<c:otherwise>
				<li  style="border-bottom:1px solid #eee; font-size: 30px; ">没有结果</li>
			</c:otherwise>
		</c:choose>

	</div>
</body>
</html>