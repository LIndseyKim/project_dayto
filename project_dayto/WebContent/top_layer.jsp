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
		<script src="js/jquery.min.js"></script>
		<script src="js/skel.min.js"></script>
		<script src="js/skel-layers.min.js"></script>
		<script src="js/init.js"></script>
		<!-- <script type="text/javascript" src="http://code.jquery.com/jquery-1.6.4.min.js"></script> -->
		
		<noscript>
			<link rel="stylesheet" href="css/main/skel.css" />
			<link rel="stylesdheet" href="css/main/style.css" />
			<link rel="stylesheet" href="css/main/style-xlarge.css" />
		</noscript>
	</head>
<body>
		<!-- Header -->
		<header id="header" class="skel-layers-fixed">
			<!-- <a href="main.html"><img src="images/logo.png" width="100px" height="50px"/></a> -->
			<h1><a href="index.jsp">Day-To</a></h1>
			<nav id="nav">
				<ul>
					<li><a href="#">About us</a></li>
					<li><a href="schedule.jsp">Schedule</a></li>
					<li><a href="blog.jsp">Blog</a></li>
					<li><a href="#">Search</a><li>
					<li><a href="#">Admin</a><li>
					<c:choose>
						<c:when test="${userId != null }">
							<li> ${sessionScope.userId}님이 로그인 하셨습니다.</li>	
							<li><a href="user/logout.do" class="button special">Logout</a></li>
						</c:when>
						<c:otherwise>
							<li><a id="loginButton" href="login.jsp" class="button special">Login</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</nav><!-- nav -->
		</header> <!-- Header -->
</body>
</html>