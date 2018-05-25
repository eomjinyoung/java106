<%@page import="jsp.Member"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exam03_4</title>
</head>
<body>
<h1>JSP 전용 태그: useBean without 객체 생성</h1>
<pre>
저장소에서 값을 꺼낸다. 만약 그 아이디에 해당하는 값이 없다면 예외 발생!
</pre>

<%
Member obj = new Member();
obj.setId("홍길동");
obj.setEmail("hong@test.com");
obj.setPassword("1111");
//pageContext.setAttribute("member", obj);
%>

<h2>PageContext 저장소에서 값 꺼내기</h2>
<jsp:useBean id="member" type="jsp.Member"></jsp:useBean>
<%-- 자바 코드: 
jsp.Member member = (jsp.Member)pageContext.getAttribute("member");
if (member == null) {
    throw new Exception();
}
--%>
아이디: <%=member.getId()%><br>
이메일: <%=member.getEmail()%><br>
암호: <%=member.getPassword()%><br>

</body>
</html>







