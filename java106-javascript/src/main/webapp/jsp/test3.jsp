<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 클라이언트 요청을 받은 현재 스레드를 5초 동안 잠자게 하자!
Thread.currentThread().sleep(5000);

// 5초가 지난 후 깨어나서 클라이언트에게 다음을 응답할 것이다.
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test2</title>
</head>
<body>
<h1>Hello!</h1>
</body>
</html>