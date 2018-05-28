<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jsp.Team"%>
<%@page import="jsp.Member"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exam08</title>
</head>
<body>

<h1>EL: 값 꺼내기</h1>

<h2>배열 값 꺼내기</h2>
<%
pageContext.setAttribute("names", new String[]{"홍길동","임꺽정","유관순"});
%>
${names[0]}, ${names[1]}, ${names[2]}, ${names[3]}<br>

<h2>List에서 값 꺼내기</h2>
<%
ArrayList<String> names2 = new ArrayList<>();
names2.add("홍길동");
names2.add("임꺽정");
names2.add("유관순");
pageContext.setAttribute("names2", names2);
%>
${names2.get(0)}<br>
${names2[0]}, ${names2[1]}, ${names2[2]}, ${names2[3]}<br>

<h2>Map에서 값 꺼내기</h2>
<%
HashMap<String,String> names3 = new HashMap<>();
names3.put("s01", "홍길동");
names3.put("s02", "임꺽정");
names3.put("s03", "유관순");
pageContext.setAttribute("names3", names3);
%>
${names3.get("s01")}<br>
${names3["s01"]}<br>
${names3['s01']}<br>
${names3.s01}<br>

<h2>일반 자바 객체에서 값 꺼내기</h2>
<%
Team team = new Team();
team.setName("팀1");
team.setDescription("웹 개발팀");
pageContext.setAttribute("team", team);
%>
${team.getName()} <br>
${team["name"]} <br>
${team['name']} <br>
${team.name} <br>
</body>
</html>







