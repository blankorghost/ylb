<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>用户管理</title>
	<link rel="stylesheet" href="../css/bootstrap-3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="../css/layui/css/layui.css" media="all">
</head>
<body>
	<div class="container" style="line-height: 30px;">
		<div class="layui-container">  
			<div class="layui-row">
				<div class="layui-col-md4">
					<span >用户名ID</span>
					<hr>
				</div>
			    <div class="layui-col-md4">
			      <span >用户名</span>
			      <hr>
			    </div>
			    <div class="layui-col-md4">
			      <span >注册时间</span>
			      <hr>
			    </div>
			</div>
	  	</div>
		<c:choose>
		<c:when test="${not empty allUser}">
		<c:forEach var="result" items="${allUser}" varStatus="vs">
	  	<div class="layui-fluid">
			<div class="layui-row">
				<div class="layui-col-sm4">
					<div class="grid-demo grid-demo-bg1">
						<span id="userid">${result.userId}</span>
					</div>
				</div>
			    <div class="layui-col-sm4">
			      <div class="grid-demo grid-demo-bg1">
			      	<span id="user">${result.username}</span>
			      </div>
			    </div>
			    <div class="layui-col-sm4">
			      <div class="grid-demo">
					<span id="data">${result.registTime}</span>
			      </div>
			    </div>
			</div>
		</div>
		</c:forEach>
		</c:when>
			<c:otherwise>
				<li  style="border-bottom:1px solid #eee; font-size: 30px; ">没有结果</li>
			</c:otherwise>
		</c:choose>
		<hr>
	</div>
</body>
</html>