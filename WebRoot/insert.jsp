<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
   

  </head>
  
  <body>
   <form action="insert" method="post">  
   		UserName:<input type="text"  name="username">
   		PassWord:<input type="text" name="password">
		<input type="submit" value="Submit">
   </form>
  </body>
</html>
