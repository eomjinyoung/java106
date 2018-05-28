<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exam01</title>
</head>
<body>

<h1>JSTL(JSP Standard Tag Library)</h1>
<pre>
- 변수, 조건문, 반복문, URL 다루기, 국제화 지원, 숫자 및 날짜 형식 변환, XML, DB 연동 등 
  다양한 기능을 제공하는 JSP 확장 태그이다.
- EL과 함께 사용하면 JSP 페이지에서 자바 코드를 최소화 할 수 있다. 

JSTL 사용
1) JSTL 라이브러리 추가
  - JSTL은 JSP에서 기본으로 제공하지 않는다.
  - JSTL 기능을 구현한 라이브러리를 추가해야 한다.
  - 보통 apache.org에서 제공하는 구현체를 사용한다.
2) 방법
  - mvnrepository.org 에서 JSTL 라이브러리를 찾는다.
  - build.gradle 설정 파일에 라이브러리 정보를 추가한다.
  - "gradle eclipse"를 실행하여 라이브러리를 가져온다.
  - 이클립스 프로젝트를 갱신한다.
3) JSP 페이지에서 사용하기 
  - taglib 지시문을 사용하여 라이브러리 정보를 가져온다.
      &lt;%@ taglib uri="JSTL 라이브러리명" prefix="접두사" %>
  - JSTL 라이브러리 접두사를 이용하여 태그를 사용한다.
      &lt;접두사:태그명 속성명="값" 속성명="값"/>

JSTL 라이브러리들
1) Core : 변수, 조건문, 반복문 등을 다루는 태그
   &lt%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
2) XML : XML을 다루는 태그
   &lt%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>   
3) I18N : 국제화 프로그래밍 지원하는 태그
   &lt%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>   
4) 데이터베이스 : DB와 연동하여 SQL을 실행하는 태그
   &lt%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
5) Functions : 함수 호출을 다루는 태그
   &lt%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
</pre>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

</body>
</html>







