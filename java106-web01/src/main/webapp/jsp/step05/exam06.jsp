<%@page import="jsp.Member"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exam06</title>
</head>
<body>

<h1>JSTL - c:if</h1>
<pre>
- 조건문을 만드는 태그
    &lt;c:if test="true or false" var="변수명" scope="page|request|session|application">
        콘텐츠
    &lt;/c:if>
- test 속성
    true 또는 false 값을 리턴하는 EL 태그가 온다. 
- var 속성
    조건의 결과, true 또는 false,를 저장할 때 사용하는 이름.
- scope 속성
    조건의 결과를 저장할 저장소.  
</pre>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${20 < 25}" var="r1" scope="page"/>
r1 = ${pageScope.r1}<br> 

<c:set var="age" value="17"/>

<c:if test="${age < 19}">
    미성년입니다.
</c:if>

<c:if test="${age >= 19}">
    성년입니다.
</c:if>

</body>
</html>







