<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link href="${pageContext.request.contextPath}/css/signup/signupstyle.css" rel="stylesheet" type="text/css" />

<script>
	function signup_popup() {
		$('#sign_popup').bPopup({
		    contentContainer:'.content',
		    loadUrl: '${pageContext.request.contextPath}/signup.jsp'
		})
	};
</script>
		
<!--WRAPPER-->
<div id="wrapper" style="padding-top: 50px">
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
			<a onclick="signup_popup()" class="register">Sign Up</a>
			<%-- <a href="${pageContext.request.contextPath}/signup.jsp" class="register">Sign Up</a> --%>
		</div>
		<!--END FOOTER-->
	</form>
	<!--END LOGIN FORM-->
	<div id="sign_popup" class ="content"></div>
</div>