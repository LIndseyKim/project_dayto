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
		<!-- <script type="text/javascript" src="http://code.jquery.com/jquery-1.6.4.min.js"></script> -->
		
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.css" />
		
		<script>
			$(document).ready(function() {
				$(".login_fail").click(login_fail_alert)
				$("#logout").click(logout_alert)
			});
		</script>
		
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
				<h2 align="center">${user.userName}님의블로그글 작성하기</h2>
				<input class="field span12" name="postName" type="text"
					placeholder="블로그 제목" onfocus="this.value=''" />
	
				<textarea class="field span12" name="postContent" id="textarea"
					rows="6" placeholder="글을 입력하세요"></textarea>
	
				<div id="boxes">
					<label class="checkbox1"> <input type="checkbox" value=1 />다녀옴
					</label> <label class="radio1"> <input type="radio"
						name="postPublic" id="optionsRadios1" value=1 checked />다른 회원에게 공개
					</label> <label class="radio1"> <input type="radio"
						name="optionsRadios" id="optionsRadios2" value="N" />비공개
					</label>
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
