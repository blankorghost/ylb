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
    <title>言论&nbsp;-&nbsp;登录</title>
    <link rel="stylesheet" type="text/css" href="../css/views.css">
    <link href="../image/icon.png" rel="shortcut icon" />
    <script src="../js/views.js" type="text/javascript"></script>
    <script src="../js/jquery-3.2.1.js" type="text/javascript"></script>
</head>
<body class="bgcolor">
<div class="logo"><a href="../index.jsp"><img src="../image/logo.png"></a></div>
<div class="usertip" style="clear: both; margin-top: 208px;" id="emailunused">邮箱未注册，请注册！</div>
<div class="frame">
    <div style="padding-top: 55px;">
        <div class="framlogreg log regorlog"><a href="./login.jsp">登录</a></div>
        <div class="framlogreg dot"><span>·</span></div>
        <div class="framlogreg reg"><a href="register.jsp">注册</a></div>
    </div>
    <div style="margin-top: 90px;">
        <form action="user_login.action" method="post">
            <div class="inputw">
                <div>
                    <input type="text" name="user.email" onblur="checkEmail()" class="inputb user"
                           placeholder="邮箱"/>
                </div>
                <div>
                    <input type="password" name="user.password"  class="inputb pwd"
                           placeholder="密码"/>
                </div>
            </div>
            <div class="remb"><input type="checkbox" checked>&nbsp;记住我</div>
            <div class="btndiv">
                <button class="btn log" type="submit" id="logbtn">
                    登录
                </button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
