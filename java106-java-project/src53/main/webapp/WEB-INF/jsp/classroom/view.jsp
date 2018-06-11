<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>강의 보기</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<h1>강의 보기</h1>
<form action='update' method='post'>
<input type='hidden' name='no' value='${classroom.no}'>
<table border='1'>
<tr>
    <th>강의명</th>
    <td><input type='text' name='title' value='${classroom.title}'></td>
</tr>
<tr>
    <th>시작일</th>
    <td><input type='date' name='startDate' value='${classroom.startDate}'></td>
</tr>
<tr>
    <th>종료일</th>
    <td><input type='date' name='endDate' value='${classroom.endDate}'></td>
</tr>
<tr>
    <th>강의실</th>
    <td><input type='text' name='room' value='${classroom.room}'></td>
</tr>
</table>
<p>
<a href='list'>목록</a>
<button>변경</button>
<a href='delete?no=${classroom.no}'>삭제</a>
</p>
</form>
</body>
</html>

    