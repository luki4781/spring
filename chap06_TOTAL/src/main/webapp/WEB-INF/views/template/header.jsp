<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div align="center">
	<h1>SPRING WEB MVC</h1>
	<p id="alt">
	
	</p>
</div>
<script>
	var aws = new WebSocket("ws://192.168.10.88/ws/alert");
	aws.onmessage = function(e) {
	//	console.log(e.data + " / " + typeof e.data);
		document.getElementById("alt").innerHTML = e.data;
		var audio = new Audio("/join.wav");
		audio.play();
		
	}
	document.getElementById("alt").onclick = function() {
		this.innerHTML="";
	}
</script>
