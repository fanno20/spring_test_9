<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	var textarea = $("#messageWindow").val();
	var webSocket = new WebSocket("ws://localhost:8080/p9/chatt/broadcasting");/* 192.168.50.133 */
	//error 발생 시 호출 
	webSocket.onerror = function(event){
		onError(event);
	};
	//연결 시 호출
	webSocket.onopen = function(event){
		onOpen(event);
	};
	//message
	webSocket.onmessage = function(event){
		onMessage(event);
	}
	
	function onError(event){
		alert(event.data);
	}
	
	function onOpen(event){
		$("#messageWindow").val(textarea=textarea+"연결성공\n");
	}
	
	function onMessage(event){
		$("#messageWindow").val(textarea=textarea+"you : " + event.data + "\n");
		$("#newItem").html("test_새글등록됨");
	}
	
	$("#send").on('click',function(){
		var message = $("#inputMessage").val();
		webSocket.send(message);
		$("#messageWindow").val(textarea=textarea+"My : " + message + "\n");
		$("#inputMessage").val("");
	});
	
});
</script>
<style type="text/css">
	div{
		width: 600px;
		margin: 0 auto;
	}
</style>
</head>
<body>
	<div>
		<h2>chatting test</h2>
		<textarea rows="20" cols="60" id="messageWindow" readonly="readonly"></textarea><br>
		inputMessage: <input type="text" id="inputMessage">
		<input type="button" value="send" id="send"><br>
	</div>
	<span id="newItem"></span>
</body>
</html>