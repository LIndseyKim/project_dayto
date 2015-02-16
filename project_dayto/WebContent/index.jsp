<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.css" />
		
		<script>
			$(document).ready(function() {
				$(".login_fail").click(login_fail_alert)
				$("#logout").click(logout_alert)
				
			});
			window.onload = function() {
				$("body").load("${pageContext.request.contextPath}/getAllPublicPost.do?flag=1")
	         }
		</script>
	</head>
	<body>
		<jsp:include page="top_layer.jsp" />
		<!-- Banner -->
		<section id="banner">
		<div class="inner">
			<h2>Day-To</h2>
			<p>
				일정관리 웹 어플리케이션 <a href="#">2528</a>
			</p>
			<ul class="actions">
				<li><a href="#" class="button big alt">Learn More</a></li>
			</ul>
		</div>
		</section>
	
		<section id="one" class="wrapper style1"> <header class="major">
		<h2>추천 일정</h2>
		</header>
		<div id="Recommend" class="container">
			<div class="row">
				<c:forEach items="${recommend}" var="r">
					<div class="4u">
						<section class="special box">
							<c:forEach items="${r.pictureList}" var="p">
								<a href="${pageContext.request.contextPath}/getPost.do?postId=${r.postId}" class="image fit"><img src="${p.postPic}"/></a>
							</c:forEach>
							<h3>${r.postName}</h3>
							<p>${r.postContent}</p>
						</section>
					</div>
				</c:forEach>
			</div>
		</div>
		</section>
	
		<!-- Footer -->
		<footer id="footer">
		<div class="container">
			<div class="row double">
				<div class="6u">
					<div class="row collapse-at-2">
						<div class="6u">
							<h3>공지사항</h3>
							<ul class="alt">
								<li><a href="#">공지사항1</a></li>
								<li><a href="#">공지사항2</a></li>
								<li><a href="#">공지사항3</a></li>
								<li><a href="#">공지사항4</a></li>
							</ul>
						</div>
						<div class="6u">
							<h3>Contact Us</h3>
							<ul class="alt">
								<li><a href="#">Tagu Kim</a></li>
								<li><a href="#">Woojin Jang</a></li>
								<li><a href="#">Minji Kim</a></li>
								<li><a href="#">Jihye Shin</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="6u">
					<h2>About Us</h2>
					<p>여러분의 데이트 일정을 편하게 짜드립니다!</p>
					<ul class="icons">
						<li><a href="#" class="icon fa-twitter"><span
								class="label">Twitter</span></a></li>
						<li><a href="#" class="icon fa-facebook"><span
								class="label">Facebook</span></a></li>
						<li><a href="#" class="icon fa-instagram"><span
								class="label">Instagram</span></a></li>
						<li><a href="#" class="icon fa-linkedin"><span
								class="label">LinkedIn</span></a></li>
						<li><a href="#" class="icon fa-pinterest"><span
								class="label">Pinterest</span></a></li>
					</ul>
				</div>
			</div>
			<ul class="copyright">
				<li>&copy; Untitled. All rights reserved.</li>
				<li>Design: <a href="#">2528</a></li>
				<li>Images: <a href="#">Unsplash</a></li>
			</ul>
		</div>
		</footer>
	</body>
</html>