<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>멤버 목록</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<h1>멤버 목록</h1>
<p><a href='form'>새회원</a></p>
<table border='1'>
<tr>
    <th>아이디</th><th>이메일</th>
</tr>
<c:forEach items="${list}" var="member">
<tr>
    <td><a href='${member.id}'>${member.id}</a></td>
    <td>${member.email}</td>
</tr>
</c:forEach>
</table>
</body>
</html>

    