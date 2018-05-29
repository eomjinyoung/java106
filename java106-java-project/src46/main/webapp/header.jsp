<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<div id='header'>
<c:choose>
    <c:when test="${empty sessionScope.loginUser}">
        <a href='${pageContext.request.contextPath}/auth/form.jsp'>로그인</a>
    </c:when>
    <c:otherwise>
        ${loginUser.id} <a href='${pageContext.request.contextPath}/auth/logout.do'>로그아웃</a>
    </c:otherwise>
</c:choose>
</div>
    