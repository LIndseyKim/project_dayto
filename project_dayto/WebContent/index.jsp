<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Day-To</title>
		<link href="css/login/loginstyle.css" rel="stylesheet" type="text/css" />
		<jsp:include page="top_layer.jsp" flush="false"/>
		
		<style type="text/css">
			#mask {
				isplay: none;
				background: #000; 
				position: fixed; left: 0; top: 0; 
				z-index: 10;
				width: 100%; height: 100%;
				opacity: 0.8;
				z-index: 999;
			}
		</style>
		
		<script type="text/javascript">
			/* $(document).ready(function() {
				 $('#loginButton').click(function() {
					//Getting the variable's value from a link 
				    var loginBox = $(this).attr('href');
					console.log(loginBox);
				    //Fade in the Popup
				   // $('#test').fadeIn(300);
				    
				    //Set the center alignment padding + border see css style
				    var popMargTop = ($(loginBox).height() + 24) / 2; 
				    var popMargLeft = ($(loginBox).width() + 24) / 2;
			    
				    $(loginBox).css({ 
				        'margin-top' : -popMargTop,
				        'margin-left' : -popMargLeft
				    });
						
				    // Add the mask to body
				    $('body').append('<div id="mask"></div>');
				    $('body').append(loginBox);
				    $(loginBox).fadeIn(300);
				    $('#mask').fadeIn(300);
					return false;
				}); */
				
				/* // When clicking on the button close or the mask layer the popup closed
				$('a.close, #mask').live('click', function() { 
						$('#mask , .login-popup').fadeOut(300 , function() {
							$('#mask').remove();  
						}); 
					return false;
				}); */
			});
	 	</script>
	</head>
<body>
	<!-- Banner -->
	<section id="banner">
		<div class="inner">
			<h2>Day-To</h2>
			<p>일정관리 웹 어플리케이션 <a href="#">2528</a></p>
			<ul class="actions">
				<!-- <li><a href="#content" class="button big special">Sign Up</a></li> -->
				<li><a href="#" class="button big alt">Learn More</a></li>
			</ul>
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