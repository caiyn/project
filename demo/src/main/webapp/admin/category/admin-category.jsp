<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>后台分类管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="common/js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="common/js/json2.js"></script>
    <script type="text/javascript" src="platform/login/js/login.js"></script>
    <script type="text/javascript" src="common/js/bootstrap.js"></script>
    <script type="text/javascript" src="admin/category/js/admin-category.js"></script>
    
    <link rel="stylesheet" href="common/css/bootstrap.css" type="text/css"></link>
	<link rel="stylesheet" href="common/css/common.css" type="text/css"></link>
    <link rel="stylesheet" href="admin/category/css/admin-catogory.css" type="text/css"></link>
    
    </head>
  
  <body>
    <div class="navitagorDiv">
	  	<nav class="navbar nav-default navbar-fixed-top navbar-inverse">
	  		<img style="margin-left:10px;margin-right:0px" class="pull-left" src="common/img/tmallbuy.png" height="45px"/>
	  		<a class="navbar-brand" href="#">天猫后台</a>
	  	    <a class="navbar-brand" href="#">分类管理</a>
	  	    <a class="navbar-brand" href="#">用户管理</a>
	  	    <a class="navbar-brand" href="#">订单管理</a>
	  	</nav>
  	</div>
  	<div class="workingArea">
  		<h1 class="label label-info">分类管理</h1>
  		<br/>
  		<br/>
  		<div class="listDataTableDiv">
  			<table class="table table-striped table-bordered table-hover table-condensed">
  				<thead>
  					<tr class="success">
  					<th>ID</th>
  					<th>图片</th>
  					<th>分类名称</th>
  					<th>属性管理</th>
  					<th>产品管理</th>
  					<th>编辑</th>
  					<th>删除</th>
  					</tr>
  				</thead>
  				<tbody id="adminCategoryList">
  				</tbody>
  			</table>
  		</div>
  	</div>
  </body>
</html>
