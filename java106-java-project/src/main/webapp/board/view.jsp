<%@page import="bitcamp.java106.pms.domain.Board"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>게시물 보기</title>
</head>
<body>

<%
out.flush();
request.getRequestDispatcher("/header.jsp").include(request, response);%>

<h1>게시물 보기(MVC)</h1>
<%
Board board = (Board)request.getAttribute("board");
%>
<form action='update' method='post'>
<table border='1'>
<tr><th>번호</th><td>
    <input type='text' name='no' value='<%=board.getNo()%>' readonly></td></tr>
<tr><th>제목</th>
    <td><input type='text' name='title' value='<%=board.getTitle()%>'></td></tr>
<tr><th>내용</th>
    <td><textarea name='content' rows='10' cols='60'><%=board.getContent()%></textarea></td></tr>
<tr><th>등록일</th><td><%=board.getCreatedDate()%></td></tr>
</table>
<p>
<a href='list'>목록</a>
<button>변경</button>
<a href='delete?no=<%=board.getNo()%>'>삭제</a>
</p>
</form>
</body>
</html>
    