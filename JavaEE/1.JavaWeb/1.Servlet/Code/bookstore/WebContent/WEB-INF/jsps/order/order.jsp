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
<title>订单</title>
</head>
<body style="margin-left: 10%;margin-right: 10%" >
	订单：
	<hr>
	<table border="1"  width="100%"  cellspacing="0" background="black">
		<c:forEach items="${requestScope.orders }"  var="order" >
			<tr bgcolor="gray" bordercolor="gray">
				<td colspan="6">
					订单编号：${order.oid }		成交时间：${order.create_time }		金额：<font color="red"><b>${order.total }</b></font> &nbsp
					<c:choose>
						<c:when test="${order.state eq 1 }">
							未支付 &nbsp<a href="<c:url value='/orderservlet?method=detail&oid=${order.oid }'></c:url>" ><font color="blue"><b>付款</b></font></a>
						</c:when>
						<c:when test="${order.state eq 2 }">等待发货 &nbsp <a href="<c:url value='/orderservlet?method=detail&oid=${order.oid }'></c:url>" ><font color="blue"><b>查看详细</b></font></a></c:when>
						<c:when test="${order.state eq 3 }">已经发货 &nbsp <a href="<c:url value='/orderservlet?method=detail&oid=${order.oid }'></c:url>" ><font color="blue"><b>确认收货</b></font></a></c:when>
						<c:when test="${order.state eq 4 }">订单完成 &nbsp <a href="<c:url value='/orderservlet?method=detail&oid=${order.oid }'></c:url>" ><font color="blue"><b>查看详细</b></font></a></c:when>
					</c:choose>
				</td>
			</tr>
			<c:forEach items="${order.orderItem }"  var="orderitem">
				<tr bordercolor="gray" align="center">
					<td width="15%">
						<div><img alt="" src="${orderitem.book.image }"  height="75"> </div>
					</td>
					<td>书名：${orderitem.book.bname }</td>
					<td>单价：${orderitem.book.price }</td>
					<td>作者：${orderitem.book.author }</td>
					<td>数量：${orderitem.count }</td>
					<td>小计：${orderitem.subtotal }</td>
				</tr>
			</c:forEach>
		</c:forEach>
	</table>
</body>
</html>