<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>boardView</h2>
<P>WRITER : ${boardDTO.writer}</P>
<p>TITLE : ${boardDTO.title}</p>
<P>CONTENTS : ${boardDTO.contents}<P>
<form id="frm">
	<input type="hidden" name="num" value="">
</form>
<input type="button" value="MOD" class="b">
<input type="button" value="DELETE" class="b">
<input type="button" value="LIST" class="b">

</body>
</html>