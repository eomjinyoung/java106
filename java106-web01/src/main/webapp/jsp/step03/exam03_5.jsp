<%@page import="java.util.ArrayList"%>
<%@page import="jsp.Member"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exam03_5</title>
</head>
<body>
<h1>JSP 전용 태그: useBean + type + class </h1>
<pre>
type과 class 속성을 모두 지정했을 때의 동작 원리

type 속성
  generic 표현을 사용할 수 있다.
class 속성
  generic 표현을 사용할 수 없다.
</pre>

<%
Member obj = new Member();
obj.setId("홍길동");
obj.setEmail("hong@test.com");
obj.setPassword("1111");

Member obj2 = new Member();
obj2.setId("임꺽정");
obj2.setEmail("leem@test.com");
obj2.setPassword("2222");

ArrayList<Member> arr = new ArrayList<>();
arr.add(obj);
arr.add(obj2);

//pageContext.setAttribute("list", arr);
%>

<h2>type 과 class 속성을 동시에 설정하기</h2>
<jsp:useBean id="list"
    type="java.util.List<Member>" 
    class="java.util.ArrayList"></jsp:useBean>
<%-- 자바 코드: 
// type 속성 값은 변수를 선언할 때 사용한다.
java.util.List<Member> list = 
    (java.util.List<Member>)pageContext.getAttribute("list");
if (list == null) {
    // class 속성 값은 객체를 생성할 때 사용한다.
    list = new java.util.ArrayList<>();
    pageContext.setAttribute("list", list);
}
--%>
<%
for (Member member : list) {
%>
    <%=member.getId()%>, <%=member.getEmail()%>, <%=member.getPassword()%><br>
<%}%>
</body>
</html>







