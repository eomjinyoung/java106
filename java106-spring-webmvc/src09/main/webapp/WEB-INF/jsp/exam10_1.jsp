<%@ page
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
</head>
<body>
<h1>JSP로 목록 페이지 만들기</h1>
<table border="1">
<thead>
  <tr><th>번호</th><th>제목</th><th>작성자</th><th>등록일</th></tr>
</thead>
<tbody>
<c:forEach items="${boards}" var="board">
  <tr>
    <td>${board.no}</td>
    <td>${board.title}</td>
    <td>${board.user.id}</td>
    <td>${board.createdDate}</td>
  </tr>
</c:forEach>
</tbody>
</table>
</body>
</html>





