<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%-- JSTL 태그를 사용하여 다른 서버에 HTTP 요청을 할 것이다.--%>
<%-- JSTL 라이브러리를 가져온다.
     만약 프로젝트에 JSTL 라이브러리를 추가하지 않았다면 
     build.gradle에 추가하라!  
 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- www.zdnet.co.kr 사이트의 콘텐트를 요청한다.
     변수를 지정하지 않으면 응답 결과를 따로 보관하지 않고 
     c:import 태그가 있는 그 위치에서 응답 결과를 그대로 출력한다.
 --%>
<c:import url="http://m.zdnet.co.kr/news_view.asp?article_id=20180622064949"/>









