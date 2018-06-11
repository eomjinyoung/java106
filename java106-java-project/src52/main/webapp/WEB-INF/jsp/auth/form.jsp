<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<c:if test="${header.referer != null and !header.referer.endsWith('/auth/login')}">
    <c:set scope="session" var="refererUrl" value="${header.referer}"/> 
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>로그인</title>
</head>
<body>
<h1>로그인</h1>
<form action='login.do' method='post'>
<table border='1'>
<tr><th>아이디</th>
    <td><input type='text' name='id' value='${cookie.id.value}'></td></tr>
<tr><th>암호</th>
    <td><input type='password' name='password'></td></tr>
</table>
<p><input type='checkbox' name='saveId'> 아이디 저장</p>
<button>로그인</button>
</form>
</body>
</html>
    