<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.bh.oneproject.pojo.Customer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>客户列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
<h3 align="center">客户列表</h3>
<table border="1" width="70%" align="center">
	<tr>
		<th>客户姓名</th>
		<th>性别</th>
		<th>生日</th>
		<th>手机</th>
		<th>邮箱</th>
		<th>描述</th>
		<th>操作</th>
	</tr>

	<c:forEach var="item" items="${list }">
		<tr>
			<td>${item.cname}</td>
			<td>${item.gender}</td>
			<td>${item.birthday}</td>
			<td>${item.cellphone}</td>
			<td>${item.email}</td>
			<td>${item.description}</td>
			<td>
				<a href="<c:url value='edit.jsp'/>">编辑</a>
				<a href="<c:url value='msg.jsp'/>">删除</a>
			</td>
		</tr>
	</c:forEach>

	<%--<tr>
		<td>张三</td>
		<td>男</td>
		<td>2013-05-05</td>
		<td>13899996666</td>
		<td>zhangSan@163.com</td>
		<td>张三是谁？</td>
		<td>
			<a href="<c:url value='edit.jsp'/>">编辑</a>
			<a href="<c:url value='msg.jsp'/>">删除</a>
		</td>
	</tr>
	<tr>
		<td>张三</td>
		<td>男</td>
		<td>2013-05-05</td>
		<td>13899996666</td>
		<td>zhangSan@163.com</td>
		<td>张三是谁？</td>
		<td>
			<a href="<c:url value='edit.jsp'/>">编辑</a>
			<a href="<c:url value='msg.jsp'/>">删除</a>
		</td>
	</tr>--%>
</table>
  </body>
</html>