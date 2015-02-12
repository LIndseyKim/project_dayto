<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Login</title>
		<jsp:include page="top_layer.jsp" flush="false"/>
		<link href="${pageContext.request.contextPath}/css/login/loginstyle.css" rel="stylesheet" type="text/css" />
		
		<script type="text/javascript" src="./js/login.js"></script>
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
	</head>
	<body>
		<!--WRAPPER-->
		<div id="wrapper">
			<!--LOGIN FORM-->
			<form name="login-form" class="login-form" action="${pageContext.request.contextPath}/user/login.do" method="post">
			
				<!--HEADER-->
			    <div class="header">
			    <!--TITLE--><h1>Login</h1><!--END TITLE-->
			    <!--DESCRIPTION--><span>Fill out the form below to login.</span><!--END DESCRIPTION-->
			     <c:if test="${message != null}">
			     	<h1>test</h1>
					<h5 style="color:red">${message}</h5>
				</c:if>
			    </div><!--END HEADER-->
				<!--CONTENT-->
			    <div class="content">
				<!--USERNAME--><input name="userEmail" type="text" class="input username" value="Username" onfocus="this.value=''"/><!--END USERNAME-->
			    <!--PASSWORD--><input name="userPwd" type="password" class="input password" value="Password" onfocus="this.value=''" /><!--END PASSWORD-->
			    </div><!--END CONTENT-->
			    
			    <!--FOOTER-->
			    <div class="footer">
			    <!--LOGIN BUTTON--><input type="submit" name="submit" value="Login" class="button" /><!--END LOGIN BUTTON-->
			    <!--REGISTER BUTTON--><a href="${pageContext.request.contextPath}/signup.jsp" class="register">Sign Up</a><!--END REGISTER BUTTON-->
			    <!-- <!--REGISTER BUTTON<input type="submit" name="submit" value="Sign Up" class="register" />END REGISTER BUTTON -->
			    </div><!--END FOOTER-->
			    
			</form><!--END LOGIN FORM-->
			
		</div><!--END WRAPPER-->

		<!--GRADIENT--><div class="gradient"></div><!--END GRADIENT-->
		
	</body>
</html>