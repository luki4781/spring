<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h3>JQuery Traversing</h3>
JQuery Dom select은 tagName, id, class 가 없더라도 찾아가는게 가능함.
parent(1),children(1+), sibling (siblings:1+, prev:1, next:1)으로도 가능
<hr />
<div style="background: silver;">
	<h4>물자선택</h4>
	<small>물자는 1이상으로 설정해주세요</small>
	<ul id="t">
		<c:forTokens items="물,식량,선원,화약" delims="," var="s">
			<li>
				<button class="mbt">-</button> <b>${s }</b> <input type="number"
				value="1" id="cnt" style="width: 45px;" />
				<button class="pbt">+</button>
			</li>
		</c:forTokens>
	</ul>
	<button id="b">확인</button>
	<button id="b2">테스트</button>
</div>
<hr />
<div>설정이 끝나면 확인을 눌러주세요</div>
<script>
	$(".pbt").click(function() {
		$(this).prev().val(parseInt($(this).prev().val()) + 1);
	});
	$(".mbt").click(function() {
		if (parseInt($(this).next().val()) > 0)
			$(this).next().val(parseInt($(this).next().val()) - 1);
	});
	//children (모든자식들), find(특정클래스를 찾는게 가능, 모든형제가 아닌 필요로 찾을수있는 형제들 1+) -> 둘다 1+하는건 매한가지
	$("#b2").click(function() {
		$("#b2").prev().prev().children().eq(1).hide();
		$("#b2").prev().prev().children().eq(1).find("b").eq(1).html("FOOD");
	});

	//$("#t").parent().css("color","red");
	$("#t").parent().css("padding", "5px");
	//window.alert($("#t").children().length);
	$("#b").click(function() {
		//window.alert($("#b").children().length);
		console.log($("#b").parent().css("background"));
		//$("#t").html("나");
		//$("#b").siblings().html("형제들!!");
		console.log($("#t").prev().html());
		console.log($("#t").next().html());
		console.log($("#b").prev().html());
		console.log($("#b").next().html());
		//preAll, nextAll
		console.log($("#t").prevAll().html());
		$("#t").prevAll().hide();
		$("#t").nextAll().hide();
		console.log($("#t").prevAll().length);
		console.log($("#t").prevAll().eq(0).html());
		console.log($("#t").prevAll().eq(1).html());
	});
</script>





