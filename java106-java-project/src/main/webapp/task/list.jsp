<%@page import="bitcamp.java106.pms.domain.Task"%>
<%@page import="java.util.List"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>작업 목록</title>
</head>
<body>

<%
out.flush();
request.getRequestDispatcher("/header.jsp").include(request, response);%>

<h1><a href='../team/view?name=<%=request.getParameter("teamName")%>'>team2</a>의 작업 목록(MVC)</h1>
<p><a href='add?teamName=<%=request.getParameter("teamName")%>'>새작업</a></p>
<table border='1'>
<tr>
    <th>번호</th><th>작업명</th><th>기간</th><th>작업자</th>
</tr>
<%
List<Task> list = (List<Task>)request.getAttribute("list");
for (Task task : list) {
%>
<tr>
    <td>10</td>    
    <td><a href='view?no=<%=task.getNo()%>'><%=task.getTitle()%></a></td>    
    <td><%=task.getStartDate()%> ~ <%=task.getEndDate()%></td>    
    <td><%=task.getWorker().getId()%></td>
</tr>
<%}%>
</table>
</body>
</html>


    