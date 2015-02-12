<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <title>Day-To</title>
      
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <meta name="description" content="" />
      <meta name="keywords" content="" />
      <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
      <script src="${pageContext.request.contextPath}/js/skel.min.js"></script>
      <script src="${pageContext.request.contextPath}/js/skel-layers.min.js"></script>
      <script src="${pageContext.request.contextPath}/js/init.js"></script> 
      <script src="${pageContext.request.contextPath}/js/dayto_alert.js"></script>
      <!-- <script type="text/javascript" src="http://code.jquery.com/jquery-1.6.4.min.js"></script> -->
      
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.css" />
      
   <!--    <noscript>
         <link rel="stylesheet" href="css/main/skel.css" />
         <link rel="stylesdheet" href="css/main/style.css" />
         <link rel="stylesheet" href="css/main/style-xlarge.css" />
      </noscript> -->
      
      <script>
			$(document).ready(function () {
				$(".login_fail").click(login_fail_alert)
				$("#logout").click(logout_alert)
			});
		</script>
   </head>

      <!-- Header -->
      <header id="header" class="skel-layers-fixed">
         <h1 class="dayToMain"><a href="index.jsp">Day-To</a></h1>
         <div class="topText">
         <nav id="nav" >
           	<ul>
				<li><a href="#">About us</a></li>
				<li><a href="search.jsp">Search</a><li>
				<c:choose>
					<c:when test="${user != null }">
						<li><a href="/project_dayto/schedule.jsp">Schedule</a></li>
						<li><a href="/project_dayto/board/getPostName.do">Blog</a></li>
						<li><a href="/project_dayto/mypage.jsp">Mypage</a></li>
						<li> <h5>${user.userName}님이 로그인 하셨습니다.</h5></li>
						<li><a href="/project_dayto/logout.do" id="logout" class="button special">Logout</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="/project_dayto/login.jsp" class="login_fail">Schedule</a></li>
						<li><a href="/project_dayto/login.jsp" class="login_fail">Blog</a></li>
						<li><a id="loginButton" href="/project_dayto/login.jsp" class="button special">Login</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
         </nav><!-- nav -->
         </div>
      </header> <!-- Header -->