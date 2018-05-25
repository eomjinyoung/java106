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
<jsp:include page="/header.jsp"/>
<h1>팀 목록(MVC + JSP 전용 태그)</h1>
<p><a href='form.html'>새 팀</a></p>
<table border='1'>
<tr>
    <th>팀명</th><th>최대인원</th><th>기간</th>
</tr>
<jsp:useBean id="list"
            type="java.util.List<Team>"
            class="java.util.ArrayList"
            scope="request"/>
<%
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

    