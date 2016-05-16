<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<c:if test="${not empty sessionScope.member}">
	<a href="./board/boardList">boardList</a>
	<a href="./member/logout">LOGOUT</a>
</c:if>

<c:if test="${empty member}">
	<a href="./board/boardList">boardList</a>
	<a href="./member/loginForm">LOGIN</a>
</c:if>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
