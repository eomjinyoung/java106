<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<meta http-equiv='Refresh' 
      content='5;url=<%=request.getHeader("Referer")%>'>
<title>실행 오류</title>
</head>
<body>
<h1><%=request.getAttribute("title")%>(MVC)</h1>
<pre>
<%=request.getAttribute("error")%>
</pre>
</body>
</html>
    