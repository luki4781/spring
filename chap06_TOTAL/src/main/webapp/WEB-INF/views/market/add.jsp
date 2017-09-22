<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
input {
	font-family: 맑은 고딕;
	font-size: 10pt;
	padding: 3px;
	width: 250px;
}
</style>
<div align="center">
	<div style="width: 60%; line-height: 30px;">
		<h2>경매물품등록</h2>
		<c:if test="${!empty rst }">
			<c:choose>
				<c:when test="${rst eq 1 }">
					<b style="color: blue">등록성공</b>
				</c:when>
				<c:otherwise>
					<b style="color: red">등록실패</b>
				</c:otherwise>
			</c:choose>
		</c:if>
		<hr />
		<form action="/market/add" method="post">
			<p>
				물품명 : <input type="text" name="pname" />
			</p>
			<p>
				시작가 : <input type="number" name="sprice" />
			</p>
			<p id="p">
				즉구가 설정이 필요하면
				<button type="button" id="popen">클릭</button>
			</p>
			<p id="pp">
				마감일 설정이 필요하면
				<button type="button" id="ppopen">클릭</button>
			</p>
			<hr />
			<button type="submit">물품 등록</button>
			<button type="submit"><a href="/market/all">물품 목록</a></button>
			
		</form>
	</div>
</div>
<script>
	document.getElementById("popen").onclick = function() {
		document.getElementById("p").innerHTML = "즉구가 : <input type=\"number\" name=\"iprice\">";
	}
	document.getElementById("ppopen").onclick = function() {
		document.getElementById("pp").innerHTML = "마감일 : <input type=\"date\" name=\"cdate\">";
	}
</script>



