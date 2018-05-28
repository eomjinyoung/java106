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

<h1>JSTL - c:out</h1>
<pre>
- 출력 코드를 만드는 태그 
&lt;c:out value="출력할 값" default="출력할 값이 없을 때 사용할 값"/>
&lt;c:out value="출력할 값">출력할 값이 없을 때 사용할 값&lt;/c:out> 
</pre>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
이름: <c:out value="홍길동"></c:out><br>
나이: <c:out value="20"/><br>
전화: <%="1111-1111"%><br>
우편번호: ${"11011"}<br>

<h2>저장소의 등록된 값 출력하기</h2>
<%
pageContext.setAttribute("name", "홍길동");
%>
이름: ${pageScope.name}<br>
이름: ${name}<br>
이름: <c:out value="${name}"></c:out><br>

EL은 해당 이름의 값을 찾을 수 없을 때 빈 문자열을 리턴한다.<br>
나이: ${age}<br><br>

c:out 태그는 해당 이름의 값을 찾을 수 없을 때 기본 값을 제공한다.<br>
나이: <c:out value="${age}">20</c:out><br>
나이: <c:out value="${age}" default="20"/><br>
</body>
</html>







