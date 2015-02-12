<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Sign Up</title>
		<jsp:include page="top_layer.jsp" flush="false"/>
		<link href="${pageContext.request.contextPath}/css/signup/signupstyle.css" rel="stylesheet" type="text/css" />
		
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
	</head>
	<body>
		<!--WRAPPER-->
		<div id="wrapper">
			<!--SING UP FORM-->
			<form name="signup-form" class="signup-form" action="${pageContext.request.contextPath}/signup.do" method="post">
			
				<!--HEADER-->
			    <div class="header">
			    <!--TITLE--><h1>Sign Up</h1><!--END TITLE-->
			    <!--DESCRIPTION--><span>Fill out the form below to sign up.</span><!--END DESCRIPTION-->
			    </div><!--END HEADER-->
				
				<!--CONTENT-->
				<div class="content">
				    <table>
					    <tr>
					    	<th>아이디(email)</th>
					    	<td><!--USERID--><input name="userEmail" type="text" class="input username" value="ID(email) 입력" onfocus="this.value=''" /><!--END USERID--></td>
					    </tr>
					    <tr>
					    	<th>이름</th>
					    	<td><!--NAME--><input name="userName" type="text" class="input username" value="이름 입력" onfocus="this.value=''" /><!--END NAME--></td>
					    </tr>
					    <tr>
					    	<th>비밀번호</th>
					    	<td> <!--PASSWORD1--><input name="userPwd" type="password" class="input password" value="Password 입력" onfocus="this.value=''" /><!--END PASSWORD1--></td>
					    </tr>
					    <tr>
					    	<th>비밀번호 확인</th>
					    	<td><!--PASSWORD2--><input name="userPwd2" type="password" class="input password" value="Password 확인" onfocus="this.value=''" /><!--END PASSWORD2--></td>
					    </tr>
					    </table>
					</div><!--END CONTENT-->
			    
			    <!--FOOTER-->
			    <div class="footer">
			    <!--SUBMIT BUTTON--><input type="submit" name="submit" value="SUBMIT" class="button" /><!--END SUBMIT BUTTON-->
			    </div><!--END FOOTER-->
			</form><!--END SING UP FORM-->
		</div><!--END WRAPPER-->
		
		<!--GRADIENT--><div class="gradient"></div><!--END GRADIENT-->
	</body>
</html>