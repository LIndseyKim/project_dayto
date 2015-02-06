<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>메시지와 이미지를 등록합니다</h1>
	<form method="post" enctype="multipart/form-data"
			action="${pageContext.request.contextPath}/message/register.do">
		메시지 : <input type="text" name="message"/> <br/>
		이미지 : <input type="file" name="image"/> <br/>
		<input type="submit" value="등록"/>
	</form>
</body>
</html>