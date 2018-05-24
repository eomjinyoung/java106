<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exam05</title>
</head>
<body>
<h1>선언문(declaration element)</h1>
<pre>
[선언문]
- 서블릿 클래스를 생성할 때 멤버(클래스/인스턴스 변수, 클래스/인스턴스 메서드, 스태틱/인스턴스 블록)를 
  추가하고 싶을 때 사용한다. 

[JSP 코드]
  &lt;%! 클래스에 삽입한 변수, 메서드, 블록 선언문 %> 
[자바 코드]
  위의 태그에 안에 작성한 자바 코드는 그래도 클래스 블록 안에 복사된다.
  _jspService() 메서드 밖에 복사된다.
</pre>

aaa
<%! int i = 10; %>
bbb
<%! public void m() {} %>
ccc
<%! 
    static {
        System.out.println("okok");
    }
%>
ddd<br>
<p>10 + 20 = <%=plus(10, 20)%></p>

</body>
</html>

<%!
private int plus(int a, int b) {
    return a + b;
}
%>






