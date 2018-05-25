<%@page import="bitcamp.java106.pms.domain.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>멤버 목록</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<h1>멤버 목록(MVC + JSP 전용 태그)</h1>
<p><a href='form.html'>새회원</a></p>
<table border='1'>
<tr>
    <th>아이디</th><th>이메일</th>
</tr>
<jsp:useBean id="list"
            type="java.util.List<Member>"
            class="java.util.ArrayList"
            scope="request"/>
<%
for (Member member : list) {
%>
<tr>
    <td><a href='view?id=<%=member.getId()%>'><%=member.getId()%></a></td>
    <td><%=member.getEmail()%></td>
</tr>
<%} %>
</table>
</body>
</html>

    