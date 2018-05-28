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
<h1>팀 목록(MVC + JSP 전용 태그 + EL)</h1>
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
    pageContext.setAttribute("team", team);
%>
<tr>
    <td><a href='view?name=${team.name}'>${team.name}</a></td>
    <td>${team.maxQty}</td>
    <td>${team.startDate}~${team.endDate}</td>
</tr>
<%}%>
</table>
</body>
</html>

    