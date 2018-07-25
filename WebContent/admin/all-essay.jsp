<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>文章管理</title>
	<link rel="stylesheet" href="../css/bootstrap-3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="../css/layui/css/layui.css" media="all">
</head>
<body>
	<div class="container">
		<div class="layui-container">  
			<div class="layui-row">
			    <div class="layui-col-md4">
			      <span >作者</span>
			      <hr>
			    </div>
			    <div class="layui-col-md4">
			      <span >文章名</span>
			      <hr>
			    </div>
			    <div class="layui-col-md4">
			      <span >操作</span>
			      <hr>
			    </div>
			</div>
	  	</div>
        <c:choose>
            <c:when test="${not empty allEssay}">
                <c:forEach var="result" items="${allEssay}" varStatus="vs">
        <div class="layui-fluid">
            <div class="layui-row">
                    <div class="layui-col-md4">
                        <span >${uuser.username}</span>
                        <hr>
                    </div>

                    <div class="layui-col-md4">
                        <a target="_blank" href="w_getEssay?essayId=${result.essayId}">《<span >${result.essayname}</span>》</a>
                        <hr>
                    </div>

                    <div class="layui-col-sm4">
                        <div class="grid-demo">
                        <form method="post" action="w_dele">
                            <input name="essayId" value="${result.essayId}" style="display: none">
                            <button class="btn" type="submit">删除</button>
                        </form>
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
			</div>
		</div>
		<hr>
	</div>
</body>
</html>