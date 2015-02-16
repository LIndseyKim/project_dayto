<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!-- Header -->
<header id="header" class="skel-layers-fixed">
	<h1 class="dayToMain">
		<a href="index.jsp">Day-To</a>
	</h1>
	<div class="topText">
		<nav id="nav">
			<ul>
				<li><a href="#">About us</a></li>
				<li><a href="search.jsp">Search</a>
				<li><c:choose>
						<c:when test="${user != null }">
							<li><a href="${pageContext.request.contextPath}/schedule.jsp">Schedule</a></li>
							<li><a href="${pageContext.request.contextPath}/getPostName.do">Day Together</a></li>
							<li><a href="${pageContext.request.contextPath}/mypage.jsp">Mypage</a></li>
							<li>
								<h5>${user.userName}님이 로그인 하셨습니다.</h5>
							</li>
							<li><a href="${pageContext.request.contextPath}/logout.do" id="logout" class="button special">Logout</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="${pageContext.request.contextPath}/login.jsp" class="login_fail">Schedule</a></li>
							<li><a href="${pageContext.request.contextPath}/login.jsp" class="login_fail">Blog</a></li>
							<li><a id="loginButton" href="${pageContext.request.contextPath}/login.jsp"
								class="button special">Login</a></li>
						</c:otherwise>
					</c:choose>
			</ul>
		</nav>
		<!-- nav -->
	</div>
</header>
<!-- Header -->