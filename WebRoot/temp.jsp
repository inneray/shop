<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
  	<%@ include file = "/public/head.jspf" %>
  	
  	<style type="text/css">
  		#menu{
			width:200px;
  		}
  		#menu ul{
  			list-style:none;
  			padding:0px;
  			margin:0px;
  		}
  		#menu ul li{
  			border-bottom:1px solid red;
  		}
  		#menu ul li a{
  			display:block;
  			background-color: #008792;
  			color: #fff;
  			padding:5px;
  			text-decoration: none;
  		}
  		#menu ul li a:hover{
  		
  			background-color: #00a6ac;
  		}
  	</style>
  </head>
  
  <body>
		<div id = "menu">
			<ul>
				<li><a href="#">类别管理</a></li>
				<li><a href="#">商品管理</a></li>
				
			</ul>
			
		</div>
		
  </body>
</html>
