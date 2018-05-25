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

<%
out.flush();
request.getRequestDispatcher("/header.jsp").include(request, response);%>

<h1>멤버 목록(MVC)</h1>
<p><a href='form.html'>새회원</a></p>
<table border='1'>
<tr>
    <th>아이디</th><th>이메일</th>
</tr>
<%
List<Member> list = (List<Member>)request.getAttribute("list");
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

    