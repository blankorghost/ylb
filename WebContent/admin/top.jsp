<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
<link rel="stylesheet" href="../css/bootstrap-3.3.7/css/bootstrap.min.css">
<style type="text/css">
body{
	background-color: #23262E;
}
#top{
	margin-top: 15px;
}
#namelogo{
	float: right;
	margin-right: 100px;
}
#namelogo img{
	width: 30px;
	height: 30px;
	border-radius: 50%;
}
.logo-title{
	color: #EF824E;
	margin-left: 50px;
	font-size: 30px;
}
.dropdown{
	width: 140px;
}
.dropdown-content {
	display: none;
	position: absolute;
	background-color: #393D49;
	min-width: 110px;
	box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}


.dropdown:hover .dropdown-content {
	display: block;
}
</style>
</head>
<body>
<div id="top">
	<span class="logo-title">言论后台管理</span>
	<div id="namelogo">
		<div class="dropdown" style="float: right;margin-top: 10px;">
			<span class="dropbtn" id="adminname" style="color: #eea236;">${admin.adminName}</span>
			<%--<div class="dropdown-content">
				<a href="logout.action">退出</a>
			</div>--%>
		</div>
	</div>
</div>
</body>
</html>