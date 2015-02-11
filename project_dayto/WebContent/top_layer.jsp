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
			/* }); */
	 	</script>
	 	
	</head>
<body>
		<!-- Header -->
		<header id="header" class="skel-layers-fixed">
			<h1><a href="index.jsp">Day-To</a></h1>
			<nav id="nav">
				<ul>
					<li><a href="#">About us</a></li>
					<c:choose>
						<c:when test="${user != null }">
							<li><a href="schedule.jsp">Schedule</a></li>
							<li><a href="blog.jsp">Blog</a></li>
							<li><a href="search.jsp">Search</a><li>
							<!-- <li><a href="#">Admin</a><li> -->
							<li> ${user.user_name}님이 로그인 하셨습니다.</li>
							<li><a href="user/logout.do" class="button special">Logout</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="login.jsp">Schedule</a></li>
							<li><a href="login.jsp">Blog</a></li>
							<li><a href="login.jsp">Search</a><li>
							<li><a id="loginButton" href="login.jsp" class="button special">Login</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</nav>
		</header> <!-- Header -->
</body>
</html>



