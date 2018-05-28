<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exam02</title>
</head>
<body>

<h1>EL에서 저장소를 사용하는 방법</h1>
<pre>
EL은 다음 이름을 사용하여 저장소에 접근 할 수 있다. 

PageContext     ==> pageScope(EL), pageContext(JSP)
ServletReqeust  ==> requestScope(EL), request(JSP)
HttpSession     ==> sessionScope(EL), session(JSP)
ServletContext  ==> applicationScope(EL), application(JSP)
</pre>
<%
// JSP에서 저장소 객체를 사용하려면 pageContext, request, session, application 이름으로 된 
// 객체를 사용해야 한다.
pageContext.setAttribute("name", "홍길동");
request.setAttribute("name", "임꺽정");
session.setAttribute("name", "유관순");
application.setAttribute("name", "윤봉길");
%>
PageContext: ${pageScope.name} <br>
PageContext: <%=pageContext.getAttribute("name")%> <br>

ServletRequest: ${requestScope.name} <br>
ServletRequest: <%=request.getAttribute("name")%> <br>

HttpSession: ${sessionScope.name} <br>
HttpSession: <%=session.getAttribute("name")%> <br>

ServletContext: ${applicationScope.name} <br>
ServletContext: <%=application.getAttribute("name")%> <br>

<h2>expression element vs EL</h2>
<input type="text" value="<%=request.getAttribute("name")%>"><br>
<input type="text" value="${requestScope.name}"><br>

<%-- EL의 표기법과 자바 코드
- EL 표기법은 다음의 자바 코드와 같다.  
	${member.no} ==> member.getNo();
	${team.worker.name} ==> team.getWorker().getName();
	
	${request.name} ==> request.getName();
	${request.age} ==> request.getAge();

- 위와 같은 이유로, 
  getAttribute() 메서드를 호출하는 EL 표기법을 만들기 위해 
  xxxScope이라는 이름을 만든 것이다.
${requestScope.name} ==> request.getAttribute("name");


--%>



</body>
</html>







