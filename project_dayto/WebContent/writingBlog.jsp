<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<script src="./js/jquery.min.js"></script>
		<script src="./js/skel.min.js"></script>
	    <script src="./js/skel-layers.min.js"></script>
	 	<script src="./js/init.js"></script>  
		<!-- <script type="text/javascript" src="http://code.jquery.com/jquery-1.6.4.min.js"></script> -->
		
		 <link rel="stylesheet" href="css/bootstrap/bootstrap.css" />
		<title>Insert title here</title>
		<style type="text/css">
		#boxes input[type="checkbox"],#boxes input[type="radio"]  {
 			-moz-appearance: checkbox;
			-webkit-appearance: checkbox;
			-o-appearance: checkbox;
			-ms-appearance: checkbox;
			appearance: checkbox ; 
			display: block;
			float: left; 
			opacity: 1; 
		}
		
		#boxes input[type="radio"]  {
 			-moz-appearance: radio;
			-webkit-appearance: radio;
			-o-appearance: radio;
			-ms-appearance: radio;
			appearance: radio ; 
			display: block;
			float: left; 
			opacity: 1; 
		}		
		</style>
</head>

<body>
<jsp:include page="/top.jsp" />
<jsp:include page="top_layer.jsp" flush="false" />

  <link rel="stylesheet" href="css/bootstrap/bootstrap.css" />
  <!--     <jsp:include page="top_layer.jsp" flush="false"/> -->


<style>
	
</style>		
			
			
</head>
<body>
		    
	<form name="writing_blog-form" class="writing_blog-form" action="${pageContext.request.contextPath}/board/savePost.do" method="post">
		    
			<div style="margin: 0 auto; width: 1000px">
						<br> 
			
	
			
      		<h2 align="center">${user.user_email}님의 블로그 글 작성하기</h2>
      		<input class = "field span12" name = "postName" type="text" placeholder="블로그 제목" onfocus="this.value=''"/>
      		
      		  <textarea class="field span12" name = "postContent" id="textarea" rows="6" placeholder="글을 입력하세요"></textarea>
 			  			
			<p>
			<label class="checkbox">
			<input type="checkbox" value="">
				  다녀옴
			</label>
				 
				<label class="radio">
				  <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>
				   다른 회원에게 공개
				</label>
				<label class="radio">
				  <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
				  비공개
				</label>
				
					<form method="post" enctype="multipart/form-data"
					action="${pageContext.request.contextPath}/message/register.do">
						이미지선택 : <input type="file" name="image"/> <br/>
								<input type="submit" value="등록"/>
						</form>
				
			<p align="center"> 
			
					   
		 	
			
				<input type="submit" class="btn btn-large" type="button"  value="입력완료" > 
				<button class="btn btn-large" type="button">미리보기</button>
				<input type="hidden" name="userEmail" value="${user.user_email}">  
			<!-- </p> -->
			 </div>
			
</form>
</body>
</html>
