<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<meta http-equiv="Refresh" content="3;url=${header.referer}">
<title>팀 회원 관리</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<h1>실행 실패!</h1>
<p>${message}</p>
</body>
</html>

    