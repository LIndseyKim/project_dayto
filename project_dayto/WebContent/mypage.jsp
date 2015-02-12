<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <title>My Page</title>
      <jsp:include page="top_layer.jsp" flush="false"/>
      <link href="${pageContext.request.contextPath}/css/signup/signupstyle.css" rel="stylesheet" type="text/css" />
   </head>
<body>
	<!--WRAPPER-->
	<div id="wrapper">
		<!--SING UP FORM-->
		<form name="signup-form" class="signup-form" action="${pageContext.request.contextPath}/modify.do" method="post">
		
			<!--HEADER-->
		    <div class="header">
		    <!--TITLE--><h1>Modify</h1><!--END TITLE-->
		    <!--DESCRIPTION--><span>Fill out the form below to sign up.</span><!--END DESCRIPTION-->
		    <c:if test="${message != null}">
				<h6 style="color:red">${message}</h6>
			</c:if>
		    </div><!--END HEADER-->
		    
		    <!--CONTENT-->
			<div class="content">
				<table>
					<tr>
						<th>아이디(email)</th>
						<td>${user.userEmail}</td>
					</tr>
					<tr>
						<th>이름</th>
						<td>${user.userName}</td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><!--PASSWORD1--><input name="userPwd" type="password" class="input password" value="Password 입력" onfocus="this.value=''" /><!--END PASSWORD1--></td>
					</tr>
					<tr>
						<th>비밀번호 확인</th>
						<td><!--PASSWORD2--><input name="userPwd2" type="password" class="input password" value="Password 확인" onfocus="this.value=''" /><!--END PASSWORD2--></td>
					</tr>
				</table>
			</div><!-- CONTENT -->
			<!--FOOTER-->
		    <div class="footer">
		    <!--CANCLE BUTTON--><input type="reset" name="submit" value="CANCLE" class="button" /><!--END CANCLE BUTTON-->
		    <!--SUBMIT BUTTON--><input type="submit" name="submit" value="MODIFY" class="button" /><!--END SUBMIT BUTTON-->
		    </div><!--END FOOTER-->
		    <input type="hidden" name="userEmail" value="${user.userEmail}">
		</form>
	</div>
</body>
</html>