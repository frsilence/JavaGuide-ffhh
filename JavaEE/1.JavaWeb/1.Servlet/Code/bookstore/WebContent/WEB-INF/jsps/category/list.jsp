
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Shoppy Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<link href="assets/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
<!-- Custom Theme files -->
<link href="assets/css/login-style.css" rel="stylesheet" type="text/css" media="all"/>
<link rel="icon" href="/assets/logo.ico" type="img/x-ico" />
<!--js-->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script> 
<!--icons-css-->
<link href="assets/css/font-awesome.css" rel="stylesheet">
<script src="assets/js/bootstrap.min.js"> </script>
<title>分类列表</title>
</head>
<body style="margin-left: 10%;margin-right: 10%" >
	分类：
	<hr>
	消息提示：<c:out value="${sessionScope.msg }"></c:out><br/>
	<table border="1"  width="100%"  cellspacing="0" background="black">
			<tr bgcolor="gray" bordercolor="gray">
				<td colspan="6">
					分类列表
				</td>
			</tr>
			<tr>
				<td>编号</td>
				<td>名称</td>
				<td>创建时间</td>
				<td>更新时间</td>
				<td colspan="2">操作</td>
			</tr>
		<c:forEach items="${requestScope.categories }"  var="category" >
			<tr bordercolor="gray" align="center">
				<form class="form" action="<c:url value='/admincategoryservlet'></c:url>">
					<input name="method" value="update" hidden/>
					<input name="cid" value="${category.cid}" hidden/>
					<td>${category.cid }</td>
					<td><input value="${category.cname }" class="form-control" name="cname"></td>
					<td>${category.create_time } </td>
					<td>${category.update_time }</td>
					<td><input type="submit" value="保存"/></td>
				</form>
				<td><button><a href="<c:url value='/admincategoryservlet?method=delete&cid=${category.cid }'></c:url>">删除</a></button></td>
					
				</tr>
		</c:forEach>
	</table>
	<hr/>
	消息提示：<c:out value="${requestScope.msg }"></c:out><br/>
	<table border="1"  width="100%"  cellspacing="0" background="black">
			<tr bgcolor="gray" bordercolor="gray">
				<td colspan="5">
					<b>添加分类：</b>
				</td>
			</tr>
			<tr>
				<form class="form" action="<c:url value='/admincategoryservlet'></c:url>">
					<input name="method" value="add" hidden/>
					<td colspan="4"><label form="cname">名称：&nbsp;</label><input id="cname" name="cname"/></td>
					<td colspan="2"><input type="submit" value="保存"/></td>
				</form>
			</tr>
	</table>

</body>
</html>