<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<link rel="stylesheet" href="../css/bootstrap-3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="../css/admin.css">
</head>
<body onload="loadFun()">  
    <form id="form1" runat="server">  
<div id="menu">  
    <ul>  
        <li><a href="#" onclick="Show('shop')">文章管理</a>  
                <ul id="shop">  
                    <li><a target="right" href="w_getAll.action">所有文章</a></li>
                </ul>  
        </li>  
       <li><a href="#" onclick="Show('user')">信息管理</a>  
            <ul id="user">  
                <li><a target="right" href="admin_getAll.action">用户信息</a></li>
                <li><a target="right" href="admin_getAllAdmin.action">管理员信息</a></li>
            </ul>  
        </li>  
        <li><a href="#" onclick="Show('speak')">评论管理</a>
            <ul id="speak">
            	<li><a target="right" href="selectCommentAction">评论管理</a></li>
            </ul>
        </li> 
        <li><a href="#" onclick="Show('info')">公告管理</a>  
            <ul id="info">  
            	<li><a target="right" href="./notice.jsp">公告修改</a></li>
            </ul>  
        </li>   
    </ul>  
</div>  
    </form>  
    <script>
function loadFun() {  
       //获取<ul></ul>的所有子节点<li>节点  
       var array = document.getElementsByTagName("ul").item(0).childNodes;  
       //遍历子节点  
       for (var i = 0; i < array.length; i++) {  
           //获取<li></li>标签的子节点  
           var childnodes = array[i].childNodes;  
           for (var j = 0; j < childnodes.length; j++) {  
               //如果碰到主菜单中的<ul>标签就隐藏该子菜单的下拉菜单  
               if (childnodes[j].tagName == "UL") {  
                   childnodes[j].style.display = "none";  
               }  
           }  
       }  
   }  
    var arrays = new Array("shop","user","info","speak");  
    function Show(tagId) {  
        for (var i = 0; i < arrays.length; i++) {  
            if (arrays[i] == tagId) {  
                //设置新的背景颜色  
                document.getElementById(arrays[i]).parentNode.style.backgroundColor = "RGB(237,237,237)";  
                document.getElementById(arrays[i]).style.display = "block";  
            }  
            else {  
                //将背景颜色还原  
                document.getElementById(arrays[i]).parentNode.style.backgroundColor = "RGB(216,216,216)";  
                document.getElementById(arrays[i]).style.display = "none";  
            }  
        }  
    } 
    </script>
</body>
</html>