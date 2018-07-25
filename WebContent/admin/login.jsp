<%--
  Created by IntelliJ IDEA.
  User: pangdahai
  Date: 12/25/17
  Time: 10:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>言论&nbsp;-&nbsp;管理员登录</title>
    <link rel="stylesheet" type="text/css" href="../css/views.css">
    <link href="../image/icon.png" rel="shortcut icon" />
</head>
<body class="bgcolor">
<div class="logo"><a href="../index.jsp"><img src="../image/logo.png"></a></div>
<div class="frame">
    <div style="padding-top: 55px;">
        <div class="framlogreg log regorlog">管理员-登录</div>
    </div>
    <div style="margin-top: 90px;">
        <form action="admin_login.action" method="post" onsubmit="" class="inputlr">
            <div class="inputw">
                <div>
                    <input type="text" name="admin.adminName" class="inputb user" placeholder="邮箱">
                </div>
                <div>
                    <input type="password" name="admin.password"  class="inputb pwd" placeholder="密码">
                </div>
            </div>
            <div class="remb"><input type="checkbox" checked/>&nbsp;记住我</div>
            <div class="btndiv">
                <button class="btn log" type="submit">
                    登录
                </button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
