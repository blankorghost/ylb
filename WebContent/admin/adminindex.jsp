<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>言论&nbsp;-&nbsp;后台管理</title>
	<link href="../image/icon.png" rel="shortcut icon" />
</head>
	<frameset rows="60px,*,45px" framespacing="0" border="0" frameborder="0">
		<frame src="./top.jsp" scrolling="no" noresize /> 
		<frameset cols="226px,*">
			<frame noresize src="./left.jsp" scrolling="yes" /> 
			<frame noresize name="right" src="./right.jsp" scrolling="yes"/>
		</frameset>
		<frame noresize name="status_bar" scrolling="no" src="./bottom.jsp" />
	</frameset>
</html>