<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>등록한 메시지와 이미지는 아래와 같습니다.</h1>
	<img src="${pageContext.request.contextPath}/images/${fileName}"  width="200" height="200"/>
	<br/>
	${message}
	
</body>
</html>