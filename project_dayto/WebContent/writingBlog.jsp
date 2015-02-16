<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Writing Day Together</title>
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

		<style type="text/css">
			#boxes input[type="checkbox"], #boxes input[type="radio"] {
				-moz-appearance: checkbox;
				-webkit-appearance: checkbox;
				-o-appearance: checkbox;
				-ms-appearance: checkbox;
				appearance: checkbox;
				display: block;
				float: left;
				opacity: 1;
			}
			
			#boxes input[type="radio"] {
				-moz-appearance: radio;
				-webkit-appearance: radio;
				-o-appearance: radio;
				-ms-appearance: radio;
				appearance: radio;
				display: block;
				float: left;
				opacity: 1;
			}
		</style>
	</head>

	<body>
		<jsp:include page="/top_layer.jsp" />
	
		<form name="writing_blog-form" class="writing_blog-form"
			action="${pageContext.request.contextPath}/savePost.do"
			method="post" enctype="multipart/form-data">
	
			<div style="margin: 0 auto; width: 1000px">
				<br>
				<h2 align="center">${user.userName}님의 Day Together 작성하기</h2>
				<input class="field span12" name="postName" type="text"
					placeholder="블로그 제목" onfocus="this.value=''" />
	
				<textarea class="field span12" name="postContent" id="textarea"
					rows="6" placeholder="글을 입력하세요"></textarea>
	
				<div id="boxes">
					 
					<input type="radio"
						name="postPublic" id="optionsRadios1" value=0 checked />다른 회원에게 공개
						<br/>
					 <input type="radio"
						name="postPublic" id="optionsRadios2" value=1 />다른 회원에게 비공개
				</div>
	
				이미지선택 : <input type="file" name="image" /> <br /> 
				
				<p align="center">
	
					<input type="submit" value="입력완료" />
					<!-- <input button class="btn btn-large" type="button">미리보기</button> -->
					<input type="hidden" name="userEmail" value="${user.userEmail}" />
					<!-- </p> -->
			</div>
		</form>
	</body>
</html>
