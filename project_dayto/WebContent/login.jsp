<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Login</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/skel.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/skel-layers.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/init.js"></script>
		<script src="${pageContext.request.contextPath}/js/dayto_alert.js"></script>
		<!-- <script type="text/javascript" src="http://code.jquery.com/jquery-1.6.4.min.js"></script> -->
		
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.css" />
		<link href="${pageContext.request.contextPath}/css/login/loginstyle.css"
			rel="stylesheet" type="text/css" />
		
		<script type="text/javascript"
			src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
		
		<script>
			$(document).ready(function() {
				$(".login_fail").click(login_fail_alert)
				$("#logout").click(logout_alert)
			});
		</script>
	</head>
	<body>
		<jsp:include page="top_layer.jsp" />
		<!--WRAPPER-->
		<div id="wrapper">
			<!--LOGIN FORM-->
			<form name="login-form" class="login-form"
				action="${pageContext.request.contextPath}/login.do" method="post">
	
				<!--HEADER-->
				<div class="header">
					<!--TITLE-->
					<h1>Login</h1>
					<!--END TITLE-->
					<!--DESCRIPTION-->
					<span>Fill out the form below to login.</span>
					<!--END DESCRIPTION-->
					<c:if test="${message != null}">
						<h6 style="color: red">${message}</h6>
					</c:if>
				</div>
				<!--END HEADER-->
				<!--CONTENT-->
				<div class="content">
					<!--USERNAME-->
					<input name="userEmail" type="text" class="input username"
						value="Username" onfocus="this.value=''" />
					<!--END USERNAME-->
					<!--PASSWORD-->
					<input name="userPwd" type="password" class="input password"
						value="Password" onfocus="this.value=''" />
					<!--END PASSWORD-->
				</div>
				<!--END CONTENT-->
	
				<!--FOOTER-->
				<div class="footer">
					<!--LOGIN BUTTON-->
					<input type="submit" name="submit" value="Login" class="button" />
					<!--END LOGIN BUTTON-->
					<!--REGISTER 
				    BUTTON-->
					<a href="${pageContext.request.contextPath}/signup.jsp"
						class="register">Sign Up</a>
					<!--END REGISTER BUTTON-->
					<!-- <!--REGISTER BUTTON<input type="submit" name="submit" value="Sign Up" class="register" />END REGISTER BUTTON -->
				</div>
				<!--END FOOTER-->
	
			</form>
			<!--END LOGIN FORM-->
	
		</div>
		<!--END WRAPPER-->
	
		<!--GRADIENT-->
		<div class="gradient"></div>
		<!--END GRADIENT-->
	
	</body>
</html>
