<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
</style>
<h3>JQuery 연습#2</h3>
아래 선택된 항목에 따라 총 상품금액을 계산해서 출력하는 script 설정
<hr />
<div>
	<h3>삼성노트북 코어 i5</h3>
	판매가 : 656,000 <hr/>
	옵션 :
	<ul style="list-style: none;">
		<li><input type="checkbox" class="opt" data="656000"/>기본옵션가 수량추가(+656000)</li>
		<li><input type="checkbox" class="opt" data="24000" />RAM 추가 (+24,000)</li>
		<li><input type="checkbox" class="opt" data="34000" />HDD추가 (+34,000)</li>
		<li><input type="checkbox" class="opt" data="22000" />외장그래픽카드추가 (+22,000)</li>
		<li><input type="checkbox" class="opt" data="42000" />OS포함 (+42,000)</li>
	</ul>
	<hr />
	수량 :
	<button id="mbt">-</button>
	<input type="number" style="width: 50px;" value="1" min="1" id="cnt"/>
	<button id="pbt">+</button>
	<hr />
</div>
<div>전체 상품 총액 : <span id="rst">656,000</span></div>
<script>
	var tot = 656000;
	var print = function() {
		$("#rst").html(tot * parseInt($("#cnt").val()));;
	}
	$(".opt").change(function(){
		if($(this).prop("checked") ) {
			tot += parseInt($(this).attr("data"));
		}else {
			tot -= parseInt($(this).attr("data"));
		}
		$("#cnt").trigger("change");
	});
	$("#cnt").change(function(){
		print();
	});
	$("#pbt").click(function(){
		$("#cnt").val( parseInt($("#cnt").val()) +1 );
		$("#cnt").trigger("change");	// 이벤트 발생
	});
	$("#mbt").click(function(){
		if($(this).prop("val")>1){
		$("#cnt").val( parseInt($("#cnt").val()) -1 );
		$("#cnt").trigger("change");
		}
	});
	
	
</script>








