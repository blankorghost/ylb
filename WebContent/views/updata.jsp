<%--
  Created by IntelliJ IDEA.
  User: pangdahai
  Date: 1/4/18
  Time: 10:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
    <script>
        function yes(){
            alert("修改成功！");
        }
    </script>
</head>
<body>
<div id="myinfo" style="width: 800px;">
   <form action="userinfo_updata.action" method="post">
           <input type="text" name="id" value="${userinfo.userId}" style="display: none">
        <div id="updata" class="form-horizontal">
            <div class="form-group">
                <label class="col-sm-2 control-label">用户名：</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" value="${userinfo.username}" name="username">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">新密码：</label>
                <div class="col-sm-4">
                    <input type="password" class="form-control" name="password">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">邮  箱：</label>
                <div class="col-sm-4">
                    <input type="email" class="form-control" name="email" value="${userinfo.email}">
                </div>
            </div>
            <%--<div class="form-group" style="display: none;">
                <label class="col-sm-2 control-label">头  像：</label>
                <div class="col-sm-4">
                    <img id="preview" style="width: 50px;height: 50px;" src="../photos/user_photo.jpg" />
                    <br />
                    <input type="file" name="icon" onchange="imgPreview(this)" />
                </div>
            </div>--%>
            <div class="form-group" style="margin-left: 50px;">
                <input class="btn btn-info" type="submit" value="提交" onclick="yes()">
            </div>
        </div>
	</form>
    <div style="margin-top: -47px; margin-left: 80px;">
        <a target="bottom" href="./myinfo.jsp" ><button class="btn btn-info" style="margin-left: 250px;">取消</button></a>
    </div>
</div>

</body>
</html>
