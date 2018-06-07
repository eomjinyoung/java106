<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>강의 등록</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<h1>강의 등록</h1>
<form action='add' method='post'>
<table border='1'>
<tr>
    <th>강의명</th><td><input type='text' name='title'></td>
</tr>
<tr>
    <th>시작일</th><td><input type='date' name='startDate'></td>
</tr>
<tr>
    <th>종료일</th><td><input type='date' name='endDate'></td>
</tr>
<tr>
    <th>강의실</th><td><input type='text' name='room'></td>
</tr>
</table>
<button>등록</button>

</form>

</body>
</html>

    