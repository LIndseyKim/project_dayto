<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Blog</title>
		
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
		<link href="${pageContext.request.contextPath}/css/signup/signupstyle.css" rel="stylesheet" type="text/css" />
		
		<script>
			$(document).ready(function() {
				$(".login_fail").click(login_fail_alert)
				$("#logout").click(logout_alert)
				
			});
			function mypage_popup() {
				$('#member_popup').bPopup({
				    contentContainer:'.content',
				    loadUrl: '${pageContext.request.contextPath}/mypage.jsp'
				})
			};
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
			.blog-wrapper {
				padding: 20px 0 0 0;
			}
			
			.blog-wrapper.blog-style1 {
				background: #fff;
				color: #555f66;
			}
			
			.blog-image {
				padding-top: -196px;
				padding-bottom: -96px;
				margin-left: 130px;
				display: block;
				width: 80%;
				height: 100px;
			}
		</style>
	</head>
	<body>
		<jsp:include page="top_layer.jsp" />
		<!-- One -->
		
		<section id="one" class="wrapper style1"> 
			<header class="major">
				<h2>${user.userName} DAY TOGETHER </h2>
			</header>
			<div class="container">
				<div class="row">
					<c:forEach items="${blog}" var="b">
						<div class="4u">
							<section class="special box">
								<a href="${pageContext.request.contextPath}/getPost.do?postId=${b.postId}" class="image fit"><img src="${b.pictureList[0].postPic}"/></a>
								<h3>${b.postName}</h3>
								<p>${b.postContent}</p>
								<p>${b.userEmail}</p>
								<p>${b.postDate}</p>
							</section>
						</div>
					</c:forEach>
				</div>
			</div>
		</section>
		<!-- One -->
	
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
							<h3>Faucibus</h3>
							<ul class="alt">
								<li><a href="#">Nascetur nunc varius</a></li>
								<li><a href="#">Vis faucibus sed tempor</a></li>
								<li><a href="#">Massa amet lobortis vel</a></li>
								<li><a href="#">Nascetur nunc varius</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="6u">
					<h2>Aliquam Interdum</h2>
					<p>Blandit nunc tempor lobortis nunc non. Mi accumsan. Justo
						aliquet massa adipiscing cubilia eu accumsan id. Arcu accumsan
						faucibus vis ultricies adipiscing ornare ut. Mi accumsan justo
						aliquet.</p>
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
				<li>Design: <a href="http://templated.co">TEMPLATED</a></li>
				<li>Images: <a href="http://unsplash.com">Unsplash</a></li>
			</ul>
		</div>
		</footer>
	</body>
</html>