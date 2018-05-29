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
<jsp:include page="/header.jsp"/>
<h1>게시물 보기(MVC + JSP 전용 태그 + EL + JSTL)</h1>

<form action='update.do' method='post'>
<table border='1'>
<tr><th>번호</th><td>
    <input type='text' name='no' value='${board.no}' readonly></td></tr>
<tr><th>제목</th>
    <td><input type='text' name='title' value='${board.title}'></td></tr>
<tr><th>내용</th>
    <td><textarea name='content' rows='10' cols='60'>${board.content}</textarea></td></tr>
<tr><th>등록일</th><td>${board.createdDate}</td></tr>
</table>
<p>
<a href='list.do'>목록</a>
<button>변경</button>
<a href='delete.do?no=${board.no}'>삭제</a>
</p>
</form>
</body>
</html>
    