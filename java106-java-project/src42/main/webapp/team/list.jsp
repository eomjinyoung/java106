<%@page import="bitcamp.java106.pms.domain.Team"%>
<%@page import="java.util.List"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>팀 목록</title>
</head>
<body>

<%
out.flush();
request.getRequestDispatcher("/header.jsp").include(request, response);%>

<h1>팀 목록(MVC)</h1>
<p><a href='form.html'>새 팀</a></p>
<table border='1'>
<tr>
    <th>팀명</th><th>최대인원</th><th>기간</th>
</tr>
<%
List<Team> list = (List<Team>)request.getAttribute("list");
for (Team team : list) {
%>
<tr>
    <td><a href='view?name=<%=team.getName()%>'><%=team.getName()%></a></td>
    <td><%=team.getMaxQty()%></td>
    <td><%=team.getStartDate()%>~<%=team.getEndDate()%></td>
</tr>
<%}%>
</table>
</body>
</html>

    