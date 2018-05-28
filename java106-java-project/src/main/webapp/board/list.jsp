<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>      
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>게시물 목록</title>
</head>
<body>

<jsp:include page="/header.jsp"/>

<h1>게시물 목록(MVC + JSP 전용 태그 + EL + JSTL)</h1>
<p><a href='form.html'>새 글</a></p>
<table border='1'>
<tr>
    <th>번호</th><th>제목</th><th>등록일</th>
</tr>
<c:forEach items="${list}" var="board">            
<tr>
    <td>${board.no}</td>
    <td><a href='view?no=${board.no}'>${board.title}</a></td>
    <td>${board.createdDate}</td>
</tr>
</c:forEach>
</table>
</body>
</html>