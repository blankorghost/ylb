<%--
  Created by IntelliJ IDEA.
  User: pangdahai
  Date: 1/4/18
  Time: 10:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<body>
<div id="myinfo">
    <div id="binfo">
        <div class="form-group">
            <label class="col-sm-2 control-label">用户名：</label>
            <div class="col-sm-10">
                <p class="form-control-static">${userinfo.username}</p>
            </div>
            <label class="col-sm-2 control-label">邮  箱：</label>
            <div class="col-sm-10">
                <p class="form-control-static">${userinfo.email}</p>
            </div>
        </div>
        <a target="bottom" href="./updata.jsp" ><button class="btn btn-info">修改信息</button></a>
    </div>
</div>
</body>
</html>
