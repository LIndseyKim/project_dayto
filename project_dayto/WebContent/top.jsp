<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


		<!-- Header -->
		<header id="header" class="skel-layers-fixed">
			<h1 class="dayToMain"><a href="index.jsp">Day-To</a></h1>
			<div class="topText">
			<nav id="nav" >
				<ul >
					<li><a href="#">About us</a></li>
					<c:choose>
						<c:when test="${user != null }">
							<li><a href="schedule.jsp">Schedule</a></li>
							<li><a href="${pageContext.request.contextPath}/board/getPostName.do">Blog</a></li>
							
							<li><a href="search.jsp">Search</a><li>
							<!-- <li><a href="#">Admin</a><li> -->
							<li> ${user.user_name}님이 로그인 하셨습니다.</li>
							<li><a href="user/logout.do" class="button special">Logout</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="login.jsp">Schedule</a></li>
							<li><a href="login.jsp"><li>Blog</a></li>
							<li><a href="login.jsp">Search</a><li>
							<li><a id="loginButton" href="login.jsp" class="button special">Login</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</nav><!-- nav -->
			</div>
		</header> <!-- Header -->



