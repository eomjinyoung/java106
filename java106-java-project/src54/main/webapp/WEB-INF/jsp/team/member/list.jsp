<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<h2>회원 목록</h2>
<form action='member/add' method='post'>
<input type='text' name='memberId' placeholder='회원아이디'>
<input type='hidden' name='teamName' value='${team.name}'>
<button>추가</button>
</form>
<table border='1'>
<tr><th>아이디</th><th>이메일</th><th> </th></tr>
<c:forEach items="${team.members}" var="member">
<tr>
  <td>${member.id}</td>
  <td>${member.email}</td>
  <td><a href='member/delete?teamName=${team.name}&memberId=${member.id}'>삭제</a></td>
</tr>
</c:forEach>
</table>







    