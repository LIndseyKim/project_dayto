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
		
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.css" />
			
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/jquery.bpopup.min.js"></script>
		<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
		<link href="${pageContext.request.contextPath}/css/login/loginstyle.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/signup/signupstyle.css" rel="stylesheet" type="text/css" />
		
		<script>
			$(document).ready(function() {
				$(".login_fail").click(login_fail_alert)
				$("#logout").click(logout_alert)
				
			});
			function login_popup() {
				$('#member_popup').bPopup({
				    contentContainer:'.content',
				    loadUrl: '${pageContext.request.contextPath}/login.jsp',
				})
			};
			function mypage_popup() {
				$('#member_popup').bPopup({
				    contentContainer:'.content',
				    loadUrl: '${pageContext.request.contextPath}/mypage.jsp'
				})
			}
		</script>
		<style>
			.Pstyle {
			    opacity: 0;
			    display: none;
			    position: relative;
			    width: auto;
			    border: 5px solid #fff;
			    padding: 20px;
			    background-color: #fff;
			}
		</style>
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
		</div>
		</section>
	
		<!-- Footer -->
		<footer id="footer">
			<div class="container">
				<div class="row double">
					<div class="4u">
						<section>
							<h3>Contact Us</h3>
							<ul class="alt">
								<li><a href="${pageContext.request.contextPath}/contactUs.jsp">Tagu Kim</a></li>
								<li><a href="${pageContext.request.contextPath}/contactUs.jsp">Woojin Jang</a></li>
								<li><a href="${pageContext.request.contextPath}/contactUs.jsp">Minji Kim</a></li>
								<li><a href="${pageContext.request.contextPath}/contactUs.jsp">Jihye Shin</a></li>
							</ul>
						</section>
					</div>
					<div class="8u skel-cell-important">
						<section>
							<h2>About Us</h2>
								<p>여러분의 데이트 일정을 편하게 만들어 드립니다 ! <br> 서울의 맛집, 지역명소, 영화관 등 모든 정보를 한 곳에서 확인해보세요
							<br>오늘을 함께하세요, 외쳐봐요 Day together ♥							  
							</p>
							<p>
							<ul class="icons">
								<li><a href="https://twitter.com/" class="icon fa-twitter"><span
										class="label">Twitter</span></a></li>
								<li><a href="https://www.facebook.com/" class="icon fa-facebook"><span
										class="label">Facebook</span></a></li>
								<li><a href="https://instagram.com/" class="icon fa-instagram"><span
										class="label">Instagram</span></a></li>
								<li><a href="https://www.pinterest.com/" class="icon fa-pinterest"><span
										class="label">Pinterest</span></a></li>
							</ul>
						</section>
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
