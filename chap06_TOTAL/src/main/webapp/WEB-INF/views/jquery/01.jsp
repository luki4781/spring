<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h3>
	<span id="jq">JQuery</span> <small id="ch"></small>
</h3>
jquery의 기본 사용형태는
<b>$(selector).action();</b>
이런식으로 되어있음.
<br />
javascript랑은 다르게, 선택된 요소(들)에 어떤 특정한 액션이 발생함.
<p>
	<c:forTokens items="월,화,수,목,금" delims="," var="str">
		<button class="wk">${str }</button>
	</c:forTokens>
	<button id="r">리셋</button>
</p>
<script>
	//id 설정된 건 #, class는. , tag는 태그이름
	$("button").click(function() {
		console.log("button에 click 액션 설정함");
	});
	$(".wk").click(function(){
		//window.alert(this.innerHTML);
		document.getElementById("ch").innerHTML=this.innerHTML;
	});
	$("#r").click(function(){
		//document.getElementById("ch").innerHTML="";
		$("#ch").innerHTML="";	//jquery로 얻어낸 element(s)들은 기존에 사용하던 방식으로 제어하는게 아님.
	});
	
	
	$("#jq").click(function(){
		//$("#r").fadeToggle(); jquery사용
		//document.getElementById("r").fadeToggle();
		$(document.getElementById("r")).fadeToggle();
	});
	
	
	console.log(document.getElementById("jq"));	//javascript로 얻은 상태
	console.log("================================");
	console.log($("#jq")); //jquery로 얻은 상태
	console.log("================================");
	console.log($(document.getElementById("jq")));
	/*
	 var ar = document.getElementsByClassName("wk");
	 for(var i=0;i<ar.length;i++){
	 ar[i].onclick=function(){
	 document.getElementById("ch").innerHTML = this.innerHTML;
	 }
	 }
	 document.getElementById("r").onclick=function(){
	 document.getElementById("ch").innerHTML=this.innerHTML="";
	 }


	 document.getElementsByClassName("wk").onclick=function(){
	 document.getElementById("ch").innerHTML=this.innerHTML;
	 }
	 */
</script>
