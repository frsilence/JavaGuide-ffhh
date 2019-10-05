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
<title>图书列表</title>
</head>
<body style="margin-left: 10%;margin-right: 10%" >
	图书：
	<hr>
	消息提示：<c:out value="${sessionScope.updatemsg }"></c:out><br/>
	<table border="1"  width="100%"  cellspacing="0" background="black">
			<tr bgcolor="gray" bordercolor="gray">
				<td colspan="11">
					图书列表
				</td>
			</tr>
			<tr>
				<td>编号</td>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>图片</td>
				<td>分类</td>
				<td>删除</td>
				<td>创建时间</td>
				<td>更新时间</td>
				<td colspan="2">操作</td>
			</tr>
		<c:forEach items="${requestScope.books }"  var="book" >
			<tr bordercolor="gray" align="center">
				<form class="form" action="<c:url value='/adminbookservlet'></c:url>">
					<input name="method" value="update" hidden/>
					<input name="bid" value="${book.bid}" hidden/>
					<td>${book.bid}</td>
					<td><input value="${book.bname }" class="form-control" name="bname"></td>
					<td><input value="${book.price }" class="form-control" name="price"> </td>
					<td><input value="${book.author }" class="form-control" name="author"> </td>
					<td width="15%">
						<div><img alt="" src="${book.image }"  height="75"> </div>
					</td>
					<td>${book.category.cname }</td>
					<td>${book.del }</td>
					<td>${book.create_time }</td>
					<td>${book.update_time }</td>
					
					<td><input type="submit" value="保存"/></td>
				</form>
				<td><button><a href="<c:url value='/adminbookservlet?method=delete&bid=${book.bid }'></c:url>">删除</a></button></td>
					
				</tr>
		</c:forEach>
	</table>
	<hr/>
	消息提示：<c:out value="${sessionScope.addmsg }"></c:out><br/>
	<table border="1"  width="100%"  cellspacing="0" background="black" style="margin-bottom: 10%;">
			<tr bgcolor="gray" bordercolor="gray">
				<td colspan="10">
					添加图书
				</td>
			</tr>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>图片</td>
				<td>分类</td>
				<td>操作</td>
			</tr>
			<tr bordercolor="gray" align="center">
				<form class="form" action="<c:url value='/adminaddbookservlet'></c:url>" method="post" enctype="multipart/form-data">
					<td><input class="form-control" name="bname"/></td>
					<td><input class="form-control" name="price"/> </td>
					<td><input class="form-control" name="author"/> </td>
					<td><input type="file" class="form-control" name="image"/></td>
					<td>
					<select class="form-control" name="cid">
						<c:forEach items="${requestScope.categories }" var="category">
							<option value="${category.cid }">${category.cname }</option>
						</c:forEach>
					</select>
					</td>
					<td>
						<input type="submit" value="添加" />
					</td>
				</form>
			</tr>
	</table>

</body>
</html>