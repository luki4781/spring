<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div align="center">
	<h1>SPRING WEB MVC</h1>
</div>
<script>
	var ws = new WebSocket("ws://192.168.10.88/ws/chat");
	ws.onmessage = function(e) {
		console.log(e.data + " / " + typeof e.data);
	}
</script>