<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<h2>WebSocket Alert Test</h2>

<div id="rst">
</div>
<input type="text" id="txt"/>
<script>

	var ws = new WebSocket("ws://192.168.10.88/ws/alert");
	
	ws.onopen=function(e){
		window.alert("서버측과 WS 연결 성공");
		console.log(e);
	}
	ws.onclose=function(e){
		window.alert("서버측과 WS 연결 해제");
	}
	ws.onerror=function(e){
		//window.alert("서버측과 WS 연결 에러");
	}
	ws.onmessage=function(evt){
		window.alert("서버측으로부터 메세지 전달받음");
		console.log(evt);
		window.alert(evt.data+"/"+typeof evt.data);
	}
</script>