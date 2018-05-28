<%@page import="jsp.Member"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exam05</title>
</head>
<body>

<h1>JSTL - c:remove</h1>
<pre>
- 저장소에 저장된 객체 제거하기
    &lt;c:remove var="변수명" scope="page|request|session|application"/>
</pre>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
Member member = new Member();
member.setId("user01");
member.setEmail("user01@test.com");
member.setPassword("1111");
pageContext.setAttribute("member", member);
%>
id: ${member.id}<br>
email: ${member.email}<br>
password: ${member.password}<br>
<hr>

<c:remove var="member" scope="page"/>
id: ${member.id}<br>
email: ${member.email}<br>
password: ${member.password}<br>
</body>
</html>







