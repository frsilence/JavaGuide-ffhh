<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册成功</title>
</head>
<body>
	<h3>注册成功，激活链接已发往注册邮箱，请打开注册邮箱点击激活</h3>
	<h3>激活后即可登录使用本系统，<a href='<c:url value="/userservlet?method=login"></c:url>'>立即登录</a></h3>
</body>
</html>