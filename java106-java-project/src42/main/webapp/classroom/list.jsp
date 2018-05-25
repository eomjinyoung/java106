<%@page import="bitcamp.java106.pms.domain.Classroom"%>
<%@page import="java.util.List"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>강의 목록</title>
</head>
<body>

<%
out.flush();
request.getRequestDispatcher("/header.jsp").include(request, response);%>

<h1>강의 목록(MVC)</h1>
<p><a href='form.html'>새 강의</a></p>
<table border='1'>
<tr>
    <th>번호</th><th>강의명</th><th>기간</th><th>강의실</th>
</tr>
<%
List<Classroom> list = (List<Classroom>)request.getAttribute("list");
for (Classroom classroom : list) {
%>
<tr>
    <td><%=classroom.getNo()%></td>
    <td><a href='view?no=<%=classroom.getNo()%>'><%=classroom.getTitle()%></a></td>
    <td><%=classroom.getStartDate()%>~<%=classroom.getEndDate()%></td>
    <td><%=classroom.getRoom()%></td>
</tr>
<%}%>
</table>
</body>
</html>
    