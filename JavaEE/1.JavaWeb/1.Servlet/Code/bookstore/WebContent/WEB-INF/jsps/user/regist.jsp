<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<title>注册</title>
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
<link href="assets/css/font-awesome.css" rel="stylesheet"> 
</head>
<body>  
<div class="login-page">
    <div class="login-main">    
         <div class="login-head">
                <h1>Regist</h1>
            </div>
            <div class="login-block">
                <form method="POST" action="<c:url value='/userservlet?method=regist'/>">
                	<h2><c:out value="${requestScope.errorMsg.errormsg }"></c:out></h2>   
                    <div class="form-group row">
                            <label for="name" class="col-md-2 col-sm-2" style="margin-left: 5%">用户名</label>
                            <div class="col-md-6 col-sm-6">
                                <input id="name" type="text" class="form-control" name="username" value="<c:out value='${requestScope.form.username}'></c:out>"  autofocus>
                            </div>
                            <div class="col-md-3 col-sm-3" style="color:red">
                            	<c:out value="${requestScope.errorMsg.username }"></c:out>
                            </div>        
                    </div>
                    <div class="form-group row">
                            <label for="email" class="col-md-2 col-sm-2" style="margin-left: 5%">邮箱</label>
                            <div class="col-md-6 col-sm-6">
                                <input id="email" type="text" class="form-control" name="email" value="<c:out value='${requestScope.form.email}'></c:out>" >
                            </div>
                            <div class="col-md-3 col-sm-3" style="color:red">
                            	<c:out value="${requestScope.errorMsg.email }"></c:out>
                            </div>
                    </div>
                    <div class="form-group row">
                            <label for="password" class="col-md-2 col-sm-2" style="margin-left: 5%">密码</label>
                            <div class="col-md-6 col-sm-6">
                                <input id="password" type="password" class="form-control" name="password">
                            </div>
                            <div class="col-md-3 col-sm-3" style="color:red">
                            	<c:out value="${requestScope.errorMsg.password }"></c:out>
                            </div>
                    </div>
                    <div class="form-group row">
                            <label for="password" class="col-md-2 col-sm-2" style="margin-left: 5%">确认密码</label>
                            <div class="col-md-6 col-sm-6">
                                <input id="password" type="password" class="form-control" name="password_confirmation">
                            </div>
                            <div class="col-md-3 col-sm-3" style="color:red">
                            	<c:out value="${requestScope.errorMsg.password_confirmation }"></c:out>
                            </div>
                    </div>
                    <input type="submit" value="注册">  
                    <h3>已有账号?<a href="<c:url value='/userservlet?method=login'></c:url>">  点击登录</a></h3>                
                </form>
            </div>
      </div>
</div>
<!--inner block end here-->
<!--copy rights start here-->
<div class="copyrights">
     <p>Copyright &copy; 2018.Company name All rights reserved.</p>
</div>  
<!--COPY rights end here-->

<!--scrolling js-->
<script src="assets/js/jquery.nicescroll.js"></script>
<script src="assets/js/scripts.js"></script>
<!--//scrolling js-->
<script src="assets/js/bootstrap.min.js"> </script>
<!-- mother grid end here-->
</body>
</html>