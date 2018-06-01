<%@ page language="java" 
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
</head>
<body>
<h1>목록</h1>
<c:forEach items="${list}" var="board">
    ${board.title} <br>
</c:forEach>
</body>
</html>