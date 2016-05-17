<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<h2>board List</h2>
<table class="table table-bordered">
	<thead>
		<tr><th>NUM</th><th>TITLE</th><th>WRITER</th></tr>
    </thead>
    <tbody>
		<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.num}</td>
				<td><a href="?num=${dto.num}">${dto.title}</a></td>
				<td>${dto.writer}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<div>
	<c:if test="${page.curBlock > 1}">
		<a href="./boardList?curPage=${page.startNum-1}">[이전]</a>
	</c:if>
	<c:forEach begin="${page.startNum}" end="${page.lastNum}" var="i">
		<a href="./boardList?curPage=${i}">${i}</a>
	</c:forEach>
	<c:if test="${page.lastNum < page.totalBlock}">
		<a href="./boardList?curPage=${page.lastNum+1}">[다음]</a>
	</c:if>
</div>

<button type="button" class="btn btn-primary">글쓰기</button>
</body>
</html>