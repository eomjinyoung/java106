<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>작업 보기</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<h1>작업 보기</h1>
<form action='update' method='post'>
<input type='hidden' name='no' value='${task.no}'>
<table border='1'>
<tr>
    <th>팀명</th>
    <td><input type='text' value='${task.team.name}' readOnly></td>
</tr>
<tr>
    <th>작업명</th>
    <td><input type='text' name='title' value='${task.title}'></td>
</tr>
<tr>
    <th>시작일</th>
    <td><input type='date' name='startDate' value='${task.startDate}'></td></tr>
<tr>
    <th>종료일</th>
    <td><input type='date' name='endDate' value='${task.endDate}'></td></tr>
<tr>
    <th>작업자</th>
    <td>
        <select name='memberId'>
            <option value=''>--선택 안함--</option>
<c:forEach items="${members}" var="member">            
            <option ${member.id == task.worker.id ? "selected" : ""}>${member.id}</option>
</c:forEach>
        </select>
    </td>
</tr>
<tr>
    <th>작업상태</th><td><select name='state'>
        <option value='0' ${task.state == 0 ? "selected" : ""}>작업대기</option>
        <option value='1' ${task.state == 1 ? "selected" : ""}>작업중</option>
        <option value='9' ${task.state == 9 ? "selected" : ""}>작업완료</option>
    </select></td>
</tr>
</table>
<a href='list'>목록</a>
<button>변경</button> 
<a href='delete?no=${task.no}'>삭제</a>
</form>
</body>
</html>



    