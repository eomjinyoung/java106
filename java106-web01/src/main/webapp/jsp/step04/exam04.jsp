<%@page import="jsp.Team"%>
<%@page import="jsp.Member"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exam04</title>
</head>
<body>

<h1>EL: 객체의 프로퍼티 값 꺼내기</h1>
<pre>
- 객체 안에 객체가 들어 있는 경우 그 프로퍼티 값을 꺼내는 예
</pre>
<%
Member member1 = new Member();
member1.setId("user01");
member1.setEmail("user01@test.com");
member1.setPassword("1111");

Member member2 = new Member();
member2.setId("user02");
member2.setEmail("user02@test.com");
member2.setPassword("1111");

Team team = new Team();
team.setName("팀1");
team.setDescription("웹 개발팀");
team.setMembers(new Member[]{member1, member2});

pageContext.setAttribute("team", team);
%>
${team.name} <br>
${team.description} <br>
${team.members[0].email} <br>
${team.members[1].email} <br>

</body>
</html>







