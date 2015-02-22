<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		
		<link
			href='${pageContext.request.contextPath}/css/fullcalendar/fullcalendar.css'
			rel='stylesheet' />
		<link
			href='${pageContext.request.contextPath}/css/fullcalendar/fullcalendar.print.css'
			rel='stylesheet' media='print' />
		<script src='${pageContext.request.contextPath}/js/moment.min.js'></script>
		<script
			src='${pageContext.request.contextPath}/js/jquery-ui.custom.min.js'></script>
		<script src='${pageContext.request.contextPath}/js/fullcalendar.min.js'></script>
		
		<script>
			$(document).ready(function() {
				$(".login_fail").click(login_fail_alert)
				$("#logout").click(logout_alert)
				
				/* initialize the calendar
	 			-----------------------------------------------------------------*/
	 			$('#calendar').fullCalendar({
	 				header : {
	 					left : 'prev, today',
	 					center : 'title',
	 					right : 'next'
	 				},
	 				height : 400,
	 				now: "${timetableList[0].startTime}",
	 				events : [
	 					<c:forEach var="t" items = "${timetableList}">
	 					{
	 						title : "${t.placeName}",
	 						start : '${t.startTime}',
	 						end : '${t.endTime}'
	 					},
	 					</c:forEach>
	 				]
	 			});
				$('#writing').click(function() {
					<c:forEach var="t" items = "${timetableList}">
						var title = document.createElement("input");
	 					title.type = "hidden";
	 					title.name = "title";
	 					title.value = "${t.placeName}";
	 					
	 					var start = document.createElement("input");
	 					start.type = "hidden";
	 					start.name = "start";
	 					start.value = '${t.startTime}';

	 					var end = document.createElement("input");
	 					end.type = "hidden";
	 					end.name = "end";
	 					end.value = '${t.endTime}';
	 					
	 					$("form").append(title);
	 					$("form").append(start);
	 					$("form").append(end);
 					</c:forEach>
	 			});
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
			#calendar {
				float: left;
				width: 400px;
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
		
		<h2 align="center">${user.userName}님의 Day Together 작성하기</h2>
					
		<form name="writing_blog-form" class="writing_blog-form"
			action="${pageContext.request.contextPath}/savePost.do"
			method="post" enctype="multipart/form-data">
	
			<div style="margin: 0 auto; width: 1000px">
				<br>
				
									
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
				<br/>
				<div class="row">
					<div class="6u">
						<section class="special">
							<div id='calendar' style="margin-left:-40px;"></div>
						</section>
					</div>
				</div>	
		
				<p align="center">
					<input type="hidden" name="userEmail" value="${user.userEmail}" />
					<input id="writing" type="submit" value="입력완료" />
			</div>
		</form>
	</body>
</html>
