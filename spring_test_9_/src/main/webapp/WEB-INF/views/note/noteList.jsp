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
	list();
	
	$(".view").on('click',function(){
		var num = $(this).attr('id');
		$.ajax({
			url:"./view/"+num,
			type:"GET",
			headers:{
				"Content-Type": "application/json",
				"X-HTTP-Method-Override": "GET"
			},
			dataType:'json',
			success: function(data){
				alert(data.num);
				alert(data.contents);
			}
		});
	});
	
	
	$("#write").on('click',function(){
		var writer = $("#writer").val();
		var title = $("#title").val();
		var contents = $("#contents").val();
		$.ajax({
			url: "./write",
			type: "POST",
			headers:{// 보낼 때
				"Content-Type": "application/json",
				"X-HTTP-Method-Override": "POST"
			},
			dataType:'text',// 받을 때 
			data : JSON.stringify({ // data를 json형식으로 보냄
				writer: writer,
				title: title,
				contents: contents
			}),
			success: function(data){
				alert(data);
				list();
			}
		});
	});
});

function list(){
	$.ajax({
		url : "./",
		type : "GET",
		headers:{
			"Content-Type": "application/json",
			"X-HTTP-Method-Override": "POST"
		},
		dataType:'json',
		success : function(data) {
			var r = "";
			$(data).each(function(){
				r = r + "<tr>";
				r = r + "<td>" + this.num + "</td>";
				r = r + '<td class="view" id="' + this.num + '">' + this.title + "</td>";
				r = r + "<td>" + this.writer + "</td>";
				r = r + "<td>" + this.reg_date + "</td>";
				r = r + "</tr>"; 
			});
			$("#t").html(r);
		}
	});
}
</script>
</head>
<body>

	<div>
		WRITER : <input type="text" id="writer"><br>
		TITLE : <input type="text" id="title"><br>
		CONTENTS : <input type="text" id="contents"><br>
		<input type="button" value="WRITE" id="write">
	</div>

	<div id="result">
		<table>
			<tr><td>NUM</td><td>TITLE</td><td>WRITER</td><td>DATE</td></tr>
		</table>
		<table id="t"></table>
	</div>
	
</body>
</html>