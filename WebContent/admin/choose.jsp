<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<link rel="stylesheet" href="../css/bootstrap-3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="../css/yl.css">
	<link rel="stylesheet" href="../css/layui/css/layui.css" media="all">
	<script src="../css/layui/layui.js"></script>
</head>
<body>
	<div class="container">
		<div id="lunbo">
			<div class="layui-carousel" id="test1">
			  <div carousel-item>
			    <div><img src="../imgs/gufeng0.jpg" alt=""></div>
			    <div><img src="../imgs/gufeng1.jpg" alt=""></div>
			    <div><img src="../imgs/gufeng2.jpg" alt=""></div>
			    <div><img src="../imgs/gufeng3.jpg" alt=""></div>
			    <div><img src="../imgs/gufeng4.jpg" alt=""></div>
			  </div>
			</div>
		</div>
		<div id="choose">
			<a href=""><input type="button" value="修改轮播图片" class="btn"></a>
			<a href=""><input type="button" value="发布" class="btn"></a>
		</div>
	</div>
	<script>
		layui.use('carousel', function(){
		  var carousel = layui.carousel;
		  //建造实例
		  carousel.render({
		    elem: '#test1'
		    ,width: '100%' 
		    ,arrow: 'hover' 
		  });
		});
	</script>
</body>
</html>