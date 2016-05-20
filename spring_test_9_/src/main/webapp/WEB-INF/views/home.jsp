<%@page import="javax.xml.ws.handler.soap.SOAPHandler"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script type="text/javascript">
	<%-- $(function(){
		$("#btn").click(function(){
			$.ajax({
				url:"http://openapi.foodsafety.go.kr/webservice/soap/RecipeService?wsdl",
				data:{
					
				},
				succsses:function(){
					<%
						SOAPHandler header = envelope.getHeader();
					%>
				}
			});
		});
	}) --%>
</script>	
</head>
<body>
<h1>
	Hello world!  
</h1>

<c:if test="${not empty sessionScope.member}">
	<a href="./member/logout">LOGOUT</a>
	<a href="./chat/chat">chatting</a>
</c:if>

<c:if test="${empty member}">
	<a href="./member/loginForm">LOGIN</a>
</c:if>
<a href="./board/boardList">FreeBoard</a>
<a href="./board/boardList?type=q">QnaBoard</a>
	
<P>  The time on the server is ${serverTime}. </P>

<div id="d1"></div>
</body>
</html>
