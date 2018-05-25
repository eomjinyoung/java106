<%@page import="bitcamp.java106.pms.domain.Member"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>멤버 보기</title>
</head>
<body>

<%
out.flush();
request.getRequestDispatcher("/header.jsp").include(request, response);%>

<h1>멤버 보기(MVC)</h1>
<%
Member member = (Member)request.getAttribute("member");
%>
<form action='update' method='post'>
<table border='1'>
<tr><th>아이디</th><td>
    <input type='text' name='id' value='<%=member.getId()%>' readonly></td></tr>
<tr><th>이메일</th>
    <td><input type='email' name='email' value='<%=member.getEmail()%>'></td></tr>
<tr><th>암호</th>
    <td><input type='password' name='password'></td></tr>

</table>
<p>
<a href='list'>목록</a>
<button>변경</button>
<a href='delete?id=<%=member.getId()%>'>삭제</a>
</p>
</form>
</body>
</html>


    