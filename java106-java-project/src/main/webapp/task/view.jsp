<%@page import="bitcamp.java106.pms.domain.Member"%>
<%@page import="java.util.List"%>
<%@page import="bitcamp.java106.pms.domain.Task"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>작업 보기</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<h1>작업 보기(MVC + JSP 전용 태그 + EL)</h1>
<jsp:useBean id="task" class="bitcamp.java106.pms.domain.Task" scope="request"/>
<form action='update' method='post'>
<input type='hidden' name='no' value='${param.no}'>
<table border='1'>
<tr>
    <th>팀명</th>
    <td><input type='text' name='teamName' value='${task.team.name}' readOnly></td>
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
<% 
List<Member> members = (List<Member>) request.getAttribute("members");
for (Member member : members) {
    pageContext.setAttribute("member", member);
%>
            <option ${member.id == task.worker.id ? "selected" : ""}>${member.id}</option>
<%} %>
        </select>
    </td>
</tr>
<tr>
    <th>작업상태</th><td><select name='state'>
        <option value='0' ${task.state == 0 ? "selected" : ""}>작업대기</option>
        <option value='1' ${task.state == 1 ? "selected" : ""}>작업중</option>
        <option value='9' ${task.state == 2 ? "selected" : ""}>작업완료</option>
    </select></td>
</tr>
</table>
<button>변경</button> 
<a href='delete?no=${param.no}&teamName=${task.team.name}'>삭제</a>
</form>
</body>
</html>



    