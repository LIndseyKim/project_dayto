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
				    loadUrl: '${pageContext.request.contextPath}/login.jsp'
				})
			};
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
		</style>
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
					<p>${blog.postId}</p>
				</section>
			</div>
		</section>
			<tr align="center">
      			<td colspan="2" align="center">
      				<input type=button value="Modify" >
      				<a href="${pageContext.request.contextPath}/deletePost.do?deletePostId=${blog.postId}" class="button special">Delete</a>
     		</tr>
		
	</body>
</html>