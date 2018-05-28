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
<title>exam09</title>
</head>
<body>

<h1>JSTL - c:forEach : List와 Map</h1>
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

<h2>List 반복하기</h2>
<%
ArrayList<String> names = new ArrayList<>();
names.add("홍길동");
names.add("임꺽정");
names.add("유관순");
names.add("안중근");
names.add("윤봉길");
names.add("김구");
names.add("신채호");
names.add("김원봉");

pageContext.setAttribute("names", names);
%>
<p>
<c:forEach items="${names}" var="name">
${pageScope.name},
</c:forEach>
</p>

<h2>Map 반복하기</h2>
<%
HashMap<String,String> names2 = new HashMap<>();
names2.put("s01", "홍길동");
names2.put("s02", "임꺽정");
names2.put("s03", "유관순");
names2.put("s04", "안중근");
names2.put("s05", "윤봉길");
names2.put("s06", "김구");
names2.put("s07", "김원봉");
pageContext.setAttribute("names2", names2);
%>

<p>
<c:forEach items="${names2}" var="name">
${pageScope.name.key}==>${pageScope.name.value},
</c:forEach>
</p>

<h2>CSV 반복하기</h2>
<c:set var="names" value="홍길동,임꺽정,유관순,안중근,윤봉길"/>
<c:forEach items="${names}" var="name">
${pageScope.name} - 
</c:forEach>

</body>
</html>







