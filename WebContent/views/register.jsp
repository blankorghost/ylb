<%--
  Created by IntelliJ IDEA.
  User: pangdahai
  Date: 12/25/17
  Time: 1:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>注册&nbsp;-&nbsp;言论</title>
    <link rel="stylesheet" type="text/css" href="../css/views.css">
    <link href="../image/icon.png" rel="shortcut icon"/>
    <script src="../js/views.js" type="text/javascript"></script>
    <script src="../js/jquery-3.2.1.js" type="text/javascript"></script>
</head>
<body class="bgcolor">
<div class="logo"><a href="../index.jsp"><img style="width: 100%;" src="../image/logo.png"></a></div>
<div class="usertip" id="usernameused">昵称已被使用，换一个吧！</div>
<div class="usertip" style="clear: both; margin-top: 201px" id="usernameisnull">昵称不能为空！</div>
<div class="usertip" style="clear: both; margin-top: 253px;" id="emailused">邮箱已注册，请登录！</div>
<div class="usertip" style="clear: both; margin-top: 253px;z-index: 500" id="emailisnull">邮箱不能为空！</div>
<div class="frame">
    <div style="padding-top: 50px;">
        <div class="framlogreg log"><a href="login.jsp">登录</a></div>
        <div class="framlogreg dot"><span>·</span></div>
        <div class="framlogreg reg regorlog"><a href="register.jsp">注册</a></div>
    </div>
    <div style="margin-top: 90px;">
        <form action="user_add.action" method="post">
            <div>

                <div class="inputw">
                    <span class="inputicon"></span>
                    <input type="text" id="username" name="user.username" onblur="checkUserName()" class="inputb user"
                           placeholder="&nbsp;&nbsp;&nbsp;你的昵称"/>
                </div>

                <div class="inputw">
                    <span class="inputicon"></span>
                    <input type="text" id="email" name="user.email" onblur="checkEmail()" class="inputb email"
                           placeholder="&nbsp;&nbsp;&nbsp;邮箱"/>
                </div>

                <div class="inputw">
                    <span class="inputicon"></span>
                    <input type="password" id="txtPassword" name="user.password" class="inputb pwd"
                           placeholder="&nbsp;&nbsp;&nbsp;密码"/>
                </div>

            </div>

            <div class="btndiv">
                <button class="btn reg" type="submit">
                    注册
                </button>
            </div>
            <div>
                <p class="regagree">点击 “注册” 即表示您同意并愿意遵守言论<br/>
                    <a class="useragreementandprivacy" href="../p/useragreement.jsp">用户协议</a> 和
                    <a class="useragreementandprivacy" href="../p/userprivacy.jsp">隐私政策</a> 。</p>
            </div>
        </form>
    </div>
</div>
</body>
</html>
