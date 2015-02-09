<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

  <link rel="stylesheet" href="css/bootstrap/bootstrap.css" />


<style>
	
</style>		
			
			
</head>
<body>
		    
			<div style="margin: 0 auto; width: 1000px">
      		<h2 align="center">블로그 글 작성하기</h2>
      		<input class = "field span12" type="text" placeholder="블로그 제목">
      		
      		  <textarea class="field span12" id="textarea" rows="6" placeholder="글을 입력하세요"></textarea>
 			  			
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
			
			  <button class="btn btn-large" type="button">입력완료</button>
			  <button class="btn btn-large" type="button">미리보기</button>
			  
			</p>
			 </div>
			


</body>
</html>
