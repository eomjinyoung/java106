<%@ page import="bitcamp.java106.pms.domain.Member"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id='header'>
<% 
Member loginUser = (Member)session.getAttribute("loginUser");
if (loginUser == null) { %>
    <a href='<%=request.getContextPath()%>/auth/form.jsp'>로그인</a>
<%} else { %>
    <%=loginUser.getId()%> <a href='<%=request.getContextPath()%>/auth/logout'>로그아웃</a>
<%} %>
</div>
    