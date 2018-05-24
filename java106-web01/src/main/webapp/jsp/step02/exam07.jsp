<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exam07</title>
</head>
<body>
<h1>지시문(directive element): include</h1>
<pre>
[지시문]
- 지시문의 특성에 따라 적절한 자바 코드를 생성한다. 

[JSP 코드]
  &lt;%@ include file="값" %> 

[동작]
- 지정한 파일의 내용물을 모두 해당 위치에 삽입한다.
- 그런 후에 JSP 파일을 가지고 서블릿 클래스 파일을 생성한다.
- 즉 서블릿 클래스 파일을 만들기 전에 먼저 a.txt 파일의 내용을 가져온다.
</pre>

<% int a = 100; %>
-------<br>
<%@ include file="a.txt" %>
-------<br>

</body>
</html>







