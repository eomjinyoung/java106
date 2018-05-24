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
<h1>지시문(directive element): taglib</h1>
<pre>
[지시문]
- JSP 확장 태그를 사용할 때 그 라이브러리를 가져오는 명령이다. 

[JSP 코드]
  &lt;%@ taglib uri="태그 라이브러리 이름" prefix="별명" %> 

태그 라이브러리 이름
  - JSP 확장 태그가 정의된 라이브러리 이름이다. 
  - 보통 URL 형태로 되어 있다. 
  - 라이브러리를 만든 사람이 정한대로 지정해야 한다.
별명
  - 라이브러리에 들어있는 태그를 사용할 때 앞에 붙이지는 접두어이다. 
  - JSP 기본 라이브러리나 유명 라이브러리를 사용할 때는 가능한 다른 개발자들이 
    관습적으로 사용하는 별명을 지정하라! (개성 살리지 말라!)
    
[동작]
- JSP에서 기본으로 제공하는 태그 외에 특별한 작업을 수행하는 태그를 사용할 수 있다.
- 즉 해당 태그를 사용하면 특별한 작업을 수행하는 자바 코드를 생성한다.

[JSP 확장 태그를 사용하기 위해 준비해야 할 것]
- 확장 태그가 정의된 파일과 그 태그를 처리하는 자바 클래스가 들어 있는 라이브러리를 가져와야 한다.
- 그 라이브러리를 WEB-INF/lib 폴더에 둬라!
1) mvnrepository.com 에서 "jstl" 라이브러리 검색.
2) build.gradle에 의존 라이브러리 추가
3) "gradle eclipse" 실행
4) 이클립스 프로젝트 리프래시
5) tomcat 서버 다시 실행 
6) 테스트
</pre>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:forEach begin="0" end="9" var="i">
<p>i = ${i}</p>
</c:forEach>


</body>
</html>







