<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>작업 등록</title>
</head>
<body>
<h1><a href='../team/view.do?name=${param.teamName}'>'${param.teamName}'</a> 팀의 작업 등록</h1>
<form action='add.do' method='post'>
<input type='hidden' name='teamName' value='${param.teamName}'>
<table border='1'>
<tr>
    <th>작업명</th><td><input type='text' name='title'></td>
</tr>
<tr>
    <th>시작일</th><td><input type='date' name='startDate'></td>
</tr>
<tr>
    <th>종료일</th><td><input type='date' name='endDate'></td>
</tr>
<tr>
    <th>작업자</th>
    <td>
        <select name='memberId'>
            <option value=''>--선택 안함--</option>
<c:forEach items="${members}" var="member">            
            <option>${member.id}</option>
</c:forEach>
        </select>
    </td>
</tr>
</table>
<button>등록</button>
</form>
</body>
</html>




    