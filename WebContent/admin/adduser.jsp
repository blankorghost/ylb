<%--
  Created by IntelliJ IDEA.
  User: backorghost
  Date: 2017/12/28
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add</title>
    <link rel="stylesheet" href="../css/bootstrap-3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/layui/css/layui.css" media="all">
</head>
<body>
<div class="container" style="margin-top: 50px;">
    <h3 align="center">添加管理员</h3>
    <form action="admin_addAdmin.action" method="post">
        <div class="form-group">
            <span class="col-sm-2"></span>
            <label class="col-sm-2 control-label">管理员：</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" value="" name="admin.adminName">
            </div>
        </div>
        <br>
        <br>
        <br>
        <div class="form-group">
            <span class="col-sm-2"></span>
            <label class="col-sm-2 control-label">密    码：</label>
            <div class="col-sm-4">
                <input type="password" class="form-control" name="admin.password">
            </div>
        </div>
        <br>
        <br>
        <br>
        <div class="form-group">
            <span class="col-sm-2"></span>
            <span class="col-sm-2"><button class="btn btn-info" type="submit">确定</button></span>
        </div>
    </form>
    <div>
        <div style="margin-left: 60%;margin-top: -15px;">
            <a target="right" href="./admininfo.jsp"><button class="btn btn-info">取消</button></a>
        </div>
    </div>
</div>
</body>
</html>
