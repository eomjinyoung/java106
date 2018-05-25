<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exam02</title>
</head>
<body>
<h1>JSP 전용 태그: forward</h1>
<pre>
jsp:forward
  RequestDispatcher의 forward() 와 같다. 
  
포워딩 테스트 
  error 라는 파라미터가 있을 때 다른 JSP 페이지로 포워딩시켜보자!
</pre>

<%if (request.getParameter("error") != null) {%>
  <jsp:forward page="exam02_error.jsp"></jsp:forward>
<%}%>
</body>
</html>







