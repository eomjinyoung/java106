<%@page import="bitcamp.java106.pms.domain.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>게시물 목록</title>
</head>
<body>

<jsp:include page="/header.jsp"/>

<h1>게시물 목록(MVC + JSP 전용 태그)</h1>
<p><a href='form.html'>새 글</a></p>
<table border='1'>
<tr>
    <th>번호</th><th>제목</th><th>등록일</th>
</tr>
<jsp:useBean id="list"
            type="java.util.List<Board>"
            class="java.util.ArrayList"
            scope="request"/>
<%
for (Board board : list) {
%>
<tr>
    <td><%=board.getNo()%></td>
    <td><a href='view?no=<%=board.getNo()%>'><%=board.getTitle()%></a></td>
    <td><%=board.getCreatedDate()%></td>
</tr>
<%}%>
</table>
</body>
</html>