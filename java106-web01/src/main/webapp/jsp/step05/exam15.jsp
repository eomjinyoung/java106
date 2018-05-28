<%@page import="java.util.Date"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exam15</title>
</head>
<body>

<h1>JSTL - c:formatDate</h1>
<pre>
- java.util.Date 객체를 특정 형식의 문자열로 출력하는 태그
    &lt;fmt:formatDate 
            value="날짜 객체. 예) $ { 날짜레퍼런스 }" 
            pattern="출력 형식을 지정. 예) yyyy-mm-dd" 
            var="문자열을 저장할 때 이름"
            scope="저장소"/>

</pre>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<h2>오늘 날짜를 다양한 형식으로 출력</h2>
<%pageContext.setAttribute("today", new Date()); %>
<fmt:formatDate value="${today}" pattern="yyyy-MM-dd" var="str1" scope="page"/>
날짜: ${str1}<br>

바로 출력하고 싶다면, 저장소에 저장하지 말라!<br>
<fmt:formatDate value="${today}" pattern="yyyy-MM-dd"/><br>
<fmt:formatDate value="${today}" pattern="MM/dd/yyyy"/><br>
<fmt:formatDate value="${today}" pattern="MM/dd/yy"/><br>
</body>
</html>







