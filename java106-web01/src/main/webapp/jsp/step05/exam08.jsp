<%@page import="jsp.Member"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exam08</title>
</head>
<body>

<h1>JSTL - c:forEach</h1>
<pre>
- 반복문 기능을 하는 자바 코드를 만든다.
    &lt;c:forEach items="배열|java.util.Collection|java.util.Iterator|java.util.Enumeration|java.util.Map|csv 문자열"
                  var="목록에서 꺼낸 항목을 가리키는 이름"
                  begin="시작인덱스"
                  end="끝인덱스"
                  step="증가치">콘텐트&lt;/c:forEach>
- 목록에서 꺼낸 값은 PageContext 보관소에 저장된다. 
- step의 기본 값은 1이다.                   
</pre>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>14에서 20까지 반복하기</h2>
<p>
<c:forEach begin="14" end="20" var="no" >
${pageScope.no},
</c:forEach>
</p>

<p>
<c:forEach begin="14" end="20" var="no" step="3">
${pageScope.no},
</c:forEach>
</p>

<h2>배열 반복하기</h2>
<%pageContext.setAttribute("names", 
    new String[]{"홍길동","임꺽정","유관순","안중근","윤봉길","김구","신채호","김원봉"});%>
<p>
<c:forEach items="${names}" begin="2" end="5" var="name">
${pageScope.name},
</c:forEach>
</p>

<p>
<c:forEach items="${names}" begin="2" var="name">
${pageScope.name},
</c:forEach>
</p>

<p>
<c:forEach items="${names}" end="5" var="name">
${pageScope.name},
</c:forEach>
</p>

<p>
<c:forEach items="${names}" var="name">
${pageScope.name},
</c:forEach>
</p>


</body>
</html>







