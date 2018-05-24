<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exam01</title>
</head>
<body>
<h1>JSP 주석</h1>
<pre>
JSP 엔진이 자바 소스 파일을 만들 때 무시한다.
주의!
HTML 주석과 착각하지 말라!
</pre>
<%-- 
JSP 주석이다. 이 안에 작성하는 모든 내용은 JSP 엔진이 무시한다.
<p> 오호라.. 이 태그 무시된다 </p>
--%>

<!--
HTML 주석이다. JSP 엔진은 이것도 출력 내용으로 간주한다.
따라서 클라이언트로 출력한다.
  -->
</body>
</html>







