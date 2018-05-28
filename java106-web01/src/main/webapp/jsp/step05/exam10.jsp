<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="jsp.Member"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exam10</title>
</head>
<body>

<h1>JSTL - c:forToken</h1>
<pre>
- 특정 식별자로 구분된 문자열을 반복할 때 사용한다.
    &lt;c:forTokens items="문자열"
                  var="목록에서 꺼낸 항목을 가리키는 이름"
                  delims="식별자">콘텐트&lt;/c:forTokens>
- 목록에서 꺼낸 값은 PageContext 보관소에 저장된다. 
</pre>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>콤마로 구분된 문자열 반복하기</h2>
<p>
<c:forTokens items="${'홍길동,임꺽정,유관순,안중근,윤봉길'}" var="name" delims=",">
${pageScope.name},
</c:forTokens>
</p>

<h2>다른 문자로 구분된 문자열 반복하기</h2>
<p>
<c:forTokens items="${'홍길동^^임꺽정^^유관순^^안중근^^윤봉길'}" var="name" delims="^^">
${pageScope.name},
</c:forTokens>
</p>

</body>
</html>







