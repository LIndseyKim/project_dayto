<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Day Together</title>

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
		
		<script>
					$(document).ready(function() {
						$(".login_fail").click(login_fail_alert)
						$("#logout").click(logout_alert)
					});
		</script>
	</head>
	<body>
		<jsp:include page="top_layer.jsp" />
		
		<section id="main" class="wrapper style1">
			<header class="major">
				<h2>${blog.postName}</h2>
			</header>
			<div class="container" align="center">
				<section>
					<c:forEach items="${blog.pictureList}" var="p">
						<img src="${p.postPic}" width="50%" height="50%"/>
					</c:forEach>
					<p>${blog.postContent}</p>
					<p>2</p>
				</section>
			</div>
		</section>
	</body>
</html>