<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome!</title>
</head>
<body>
	Building...Please Waiting.
	<h5>stack</h5>
	<a href='<c:url value="userservlet?method=login"></c:url>'>login</a>
	<h4><c:out value="${sessionScope.user.username}"></c:out></h4>
	Cart：<a href="<c:url value='cartservlet?method=index'></c:url>">Cart页面</a><br/>
	Order:<a href="<c:url value='orderservlet?method=index'></c:url>">Order页面</a><br/>
	Admin-category:<a href="<c:url value='admincategoryservlet?method=index'></c:url>">Category页面</a><br/>
	Admin-Book:<a href="<c:url value='/adminbookservlet?method=index'></c:url>">Book页面</a><br/>
	<a href='<c:url value="userservlet?method=logout"></c:url>'>logout</a>
</body>
</html>