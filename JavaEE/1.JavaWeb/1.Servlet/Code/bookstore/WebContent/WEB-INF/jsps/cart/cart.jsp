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
<title>Cart</title>
</head>
<body style="margin-left: 10%;margin-right: 10%" >
	<c:choose>
		<c:when test="${sessionScope.user!=null }">
			用户：<c:out value="${sessionScope.user }"></c:out><br/>
		</c:when>
		<c:otherwise>
			登录：<a href="<c:url value='/userservlet?method=login'></c:url>">Login</a><br/>
		</c:otherwise>
	</c:choose>
	错误信息：<c:out value="${requestScope.error }"></c:out><br>
	错误信息（session）：<c:out value="${sessionScope.error }"></c:out><br/>
	<hr>
	<h3>Index&Delete</h3>
	CartInformation:<br>
	<div>
		<table class="table table-bordered" style="float: inherit;">
		<thead>
			<tr>
			<th>ID</th>
			<th>Picture</th>
			<th>Book_Name</th>
			<th>Price</th>
			<th>Count</th>
			<th>Subtotal</th>
			<th>Option</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.cart.cartitems}" var="cartitem">
				<tr>
				<td><c:out value="${cartitem.iid}"></c:out></td>
				<td width="15%">
						<div><img alt="" src="${cartitem.book.image }"  height="75"> </div>
					</td>
				<td><c:out value="${cartitem.book.bname}"></c:out></td>
				<td><c:out value="${cartitem.book.price}"></c:out></td>
				<td><c:out value="${cartitem.count}"></c:out></td>
				<td><c:out value="${cartitem.subtotal}"></c:out></td>
				<td><a href="<c:url value='/cartservlet?method=delete&iid=${cartitem.iid}'></c:url>">删除</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	总计：<c:out value="${requestScope.cart.total }"></c:out>
	<button class="btn btn-default" style="float: right;"><a href='<c:url value="/cartservlet?method=clear"></c:url>'>清空</a></button>
	<br />
	</div>
	<div style="float: right;margin-top: 10px;">
		<form action="<c:url value='/orderservlet?method=add'></c:url>" >
		<input name="method" value="add"  hidden/>
		地址：<input name="address" />
		<input type="submit" />
	</form>
	</div>
	
	<hr>
	<h3>Add</h3>
	<table class="table table-bordered">
		<thead>
			<tr>
				<td>BookId</td>
				<th>Price</th>
				<td>BookName</td>
				<td>Price</td>
				<td>Author</td>
				<td>Category</td>
				<td>Option</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.books }"  var="book">
				<tr>
					<td><c:out value="${book.bid }"></c:out> </td>
					<td width="15%">
						<div><img alt="" src="${book.image }"  height="75"> </div>
					</td>
					<td><c:out value="${book.bname }"></c:out> </td>
					<td><c:out value="${book.price }"></c:out> </td>
					<td><c:out value="${book.author }"></c:out> </td>
					<td><c:out value="${book.category.cname }"></c:out> </td>
					<td><form action='<c:url value="/cartservlet?method=add&bid=${book.bid }"></c:url>'>
						<input name="method" value="add" hidden="hidden">
						<input name="bid" value="${book.bid }" hidden="hidden">
						<input  name="count">
						<input type="submit" value="添加">
					</form>
					</td>


					
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>