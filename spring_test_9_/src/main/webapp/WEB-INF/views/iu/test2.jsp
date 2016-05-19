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
	$(".b").on('click',function(){
		$.ajax({
			url:$(this).val()+"/123",
			type: "GET",
			success : function(data){
				var d = "<p>";
				$(data).each(function(){
					d = d + " ID : " + this.id;
					d = d + " PW : " + this.pw;
					d = d + " NAME : " + this.name;
				});
				d = d + "</p>";
				$("#result").html(d);
			},
			error:function(status){
				alert(status);
			}
		});
	});
	$("#w").on('click',function(){
		var p1 = $("#p1").val();
		var p2 = $("#p2").val();
		var p3 = $("#p3").val();
		$.ajax({
			url:"write",
			type:"POST",
			headers:{
				"Content-Type": "application/json",
				"X-HTTP-Method-Override": "POST"
			},
			dataType:'text',
			data: JSON.stringify({
				id:p1,
				pw:p2,
				name:p3
			}),
			success:function(data){
				alert(data);
			}
		});
	});
});
</script>
</head>
<body>

<input type="button" value="member" class="b">
<input type="button" value="members" id="w"> 
ID : <input type="text" name="id" id="p1"><br>
PW : <input type="text" name="pw" id="p2"><br>
NAME : <input type="text" name="name" id="p3"><br>
<div id="result"></div>

</body>
</html>