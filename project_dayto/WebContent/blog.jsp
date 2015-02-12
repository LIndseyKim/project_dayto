<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Blog</title>
		<jsp:include page="top_layer.jsp" flush="false"/>
	</head>
	
	<style>
	.blog-wrapper {
		padding: 20px 0 0 0;
	}

		.blog-wrapper.blog-style1 {
			background: #fff;
			color: #555f66;
		}
		
	.blog-image {
		padding-top : -196px;
		padding-bottom : -96px;
		margin-left : 130px;
		display: block;
		width: 80%;
		height: 100px;
	}
	</style>
</head>
	<body>
		<!-- One -->
		<section id="one" class="wrapper style1">
			<header class="major">
				<h2>나의${user.user_email} DAY TOGETHER 일정</h2>
			</header>
			<div class="container">
				<div class="row">
					<div class="4u">
						<section class="special box">
							<a href="#" class="image fit"><img src="images/blog/pic01.jpg"/></a>
							<h3>${blog.blogName}</h3>
							<p>블로그 글1</p>
						</section>
					</div>
					<div class="4u">
						<section class="special box">
							<a href="#" class="image fit"><img src="images/blog/pic02.jpg"/></a>
							<h3>블로그 제목2</h3>
							<p>블로그 글2</p>
						</section>
					</div>
					<div class="4u">
						<section class="special box">
							<a href="#" class="image fit"><img src="images/blog/pic03.jpg"/></a>
							<h3>블로그 제목3</h3>
							<p>블로그 글3</p>
						</section>
					</div>
				</div>
			</div>
		</section><!-- One -->
	
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
						<p>Blandit nunc tempor lobortis nunc non. Mi accumsan. Justo aliquet massa adipiscing cubilia eu accumsan id. Arcu accumsan faucibus vis ultricies adipiscing ornare ut. Mi accumsan justo aliquet.</p>
						<ul class="icons">
							<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
							<li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
							<li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
							<li><a href="#" class="icon fa-linkedin"><span class="label">LinkedIn</span></a></li>
							<li><a href="#" class="icon fa-pinterest"><span class="label">Pinterest</span></a></li>
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