<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<h3>JQuery Simple AJAX</h3>
<div>
	<button id="a">AJAX</button>
	<button id="b">AJAX</button>
</div>
<script>
	$("#a").click(function() {
		$.ajax({
			"type" : "get",	// default : "get"
			"async" : false,	// default : true
			"url" : "/jquery/dst02",
			"data" : {
				"id" : "saan",
			}
		}).done(function(r){
			console.log(r +" / " +typeof r);
			var obj = JSON.parse(r);
			window.alert(obj.name+"/"+obj.gender);
		});
	});
	
	$("#b").click(function() {
		$.ajax({
			"url" : "/jquery/dst03",
		}).done(function(r){
			console.log(r +" / " +typeof r);
			//var obj = JSON.parse(r); //객체로 받기때문에 parsing 필요없음
			window.alert(r.name+"/"+r.gender);
		});
	});
</script>