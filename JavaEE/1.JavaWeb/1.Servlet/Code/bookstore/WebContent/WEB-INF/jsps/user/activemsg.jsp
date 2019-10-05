<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>激活</title>
</head>
<body>
	<h3>激活结果</h3>
	<c:if test="${not empty requestScope.errormsg}">
		<h3>激活失败，<c:out value="${requestScope.errormsg }"></c:out></h3>
	</c:if>
	<c:if test="${empty requestScope.errormsg}">
		<h3>激活成功，<a href='<c:url value="/userservlet?method=login"></c:url>'>立即登录</a></h3>
	</c:if>
	
</body>
</html>