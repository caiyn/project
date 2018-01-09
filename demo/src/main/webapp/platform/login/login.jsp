<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>测试页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
   <script type="text/javascript" src="common/js/jquery-1.8.3.js"></script>
   <script type="text/javascript" src="common/js/json2.js"></script>
   <script type="text/javascript" src="platform/login/js/login.js"></script>
  </head>
  
  <body>
   <%--<form action="/demo/platform/registerAC.action" method="post">
    	<input type="text" name="username"/>
    	<input type="password" name="password"/>
    	<input type="submit" value="提交"/>
    </form>
  	--%>
  	
  	
  	<input type="text" id="username"/>
   	<input type="password" id="password"/>
   	<input type="button" id="registerbtn" value="提交"/>
  </body>
</html>
