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
<h1>스크립트릿(scriptlet element)</h1>
<pre>
[스크립트릿 : script + let = 자바 코드 조각]
- 생성할 자바 소스 파일에 자바 코드를 그대로 넣고 싶을 때 사용한다. 

[JSP 코드]
  &lt;% 자바코드 %> 
[자바 코드]
  위의 태그에 안에 작성한 자바 코드는 작성한 순서대로 자바 소스 파일에 복사된다.
  _jspService() 메서드 안에 복사된다.
</pre>

aaa
<% int i = 10; %>
bbb
<% i = i * 20; %>
ccc
<% 
    if (i > 10) {
        out.println("10 이상입니다.");
    } else {
        out.println("10 이하입니다.");
    }
%>
ddd
</body>
</html>







