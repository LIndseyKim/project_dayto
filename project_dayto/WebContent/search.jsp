<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Test</title>
		
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
		
		<style>
			.form-wrapper {
				width: 450px;
				padding: 8px;
				margin: 50px auto;
				overflow: hidden;
				border-width: 1px;
				border-style: solid;
				border-color: #dedede #bababa #aaa #bababa;
				box-shadow: 0 3px 3px rgba(255, 255, 255, .1), 0 3px 0 #bbb, 0 4px 0
					#aaa, 0 5px 5px #444;
				border-radius: 10px;
				background-color: #f6f6f6;
				background-image: linear-gradient(top, #f6f6f6, #eae8e8);
			}
			
			.form-wrapper #search {
				width: 330px;
				height: 50px;
				padding: 5px 5px;
				float: left;
				font: bold 16px 'lucida sans', 'trebuchet MS', 'Tahoma';
				border: 1px solid #ccc;
				box-shadow: 0 1px 1px #ddd inset, 0 1px 0 #fff;
				border-radius: 3px;
			}
			
			.form-wrapper #search:focus {
				outline: 0;
				border-color: #aaa;
				box-shadow: 0 1px 1px #bbb inset;
			}
			
			.form-wrapper #search::-webkit-input-placeholder {
				color: #999;
				font-weight: normal;
			}
			
			.form-wrapper #search:-moz-placeholder {
				color: #999;
				font-weight: normal;
			}
			
			.form-wrapper #search:-ms-input-placeholder {
				color: #999;
				font-weight: normal;
			}
			
			.form-wrapper #submit {
				float: right;
				border: 1px solid #00748f;
				height: 48px;
				width: 100px;
				padding: 0;
				cursor: pointer;
				font: bold 15px Arial, Helvetica;
				color: #fafafa;
				text-transform: uppercase;
				background-color: #0483a0;
				background-image: linear-gradient(top, #31b2c3, #0483a0);
				-moz-border-radius: 3px;
				-webkit-border-radius: 3px;
				border-radius: 3px;
				text-shadow: 0 1px 0 rgba(0, 0, 0, .3);
				box-shadow: 0 1px 0 rgba(255, 255, 255, 0.3) inset, 0 1px 0 #fff;
			}
			
			.form-wrapper #submit:hover, .form-wrapper #submit:focus {
				background-color: #31b2c3;
				background-image: linear-gradient(top, #0483a0, #31b2c3);
			}
			
			.form-wrapper #submit:active {
				outline: 0;
				box-shadow: 0 1px 4px rgba(0, 0, 0, 0.5) inset;
			}
			
			.form-wrapper #submit::-moz-focus-inner {
				border: 0;
			}
		</style>
	</head>
<body>
	<jsp:include page="top_layer.jsp" flush="false" />
	<!-- Main -->
	<section id="main" class="blog-wrapper blog-style1">
	<form class="form-wrapper">
		<input type="text" id="search" placeholder="장소, 일정, 테마..." required>
		<input type="submit" value="go" id="submit">
	</form>
	</section>

	<div class="container">
		<div class="row">
			<div class="4u">
				<section class="special box"> <a href="#"
					class="image fit"><img src="images/blog/pic01.jpg" /></a>
				<h3>블로그 제목1</h3>
				<p>블로그 글1</p>
				</section>
			</div>
			<div class="4u">
				<section class="special box"> <a href="#"
					class="image fit"><img src="images/blog/pic02.jpg" /></a>
				<h3>블로그 제목2</h3>
				<p>블로그 글2</p>
				</section>
			</div>
			<div class="4u">
				<section class="special box"> <a href="#"
					class="image fit"><img src="images/blog/pic03.jpg" /></a>
				<h3>블로그 제목3</h3>
				<p>블로그 글3</p>
				</section>
			</div>
		</div>
	</div>
</body>
</html>