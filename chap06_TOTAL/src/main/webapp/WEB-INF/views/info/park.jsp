<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<style>
th {
	border-bottom: 1px solid;
	text-align: left;
}

th, td {
	padding: 10px;
}

input {
	font-family: 맑은 고딕;
	padding: 3px;
}
button {
	padding: 7px;
}
</style>
<div align="center">
	<h2>서울시 주차장 정보 / ${data.list_total_count }</h2>
	<p>
	<h3>주차장 검색</h3><input type="text">
	<button type="submit">검색</button>
	</p>
	<table style="width: 80%">
		<thead>
			<tr>
				<th style="width: 25%">주차장위치</th>
				<th style="width: 15%">수용공간</th>
				<th style="width: 15%">주차장종류명</th>
				<th style="width: 15%">일최고요금</th>
				<th style="width: 20%">주차장 번호</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="obj" items="${data.row }">
				<tr>
					<td>${obj.ADDR }</td>
					<td><fmt:formatNumber value="${obj.CAPACITY }" pattern="#,###" /></td>
					<td>${obj.PARKING_TYPE_NM }</td>
					<td>${obj.DAY_MAXIMUM }</td>
					<td>${obj.TEL }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
		<div>
		<c:forEach var="i" begin="1" end="${size }" varStatus="vs">
			<c:choose>
				<c:when test="${i eq param.page }">
					<b style="color: orange;">${i }</b>
				</c:when>
				<c:otherwise>
					<a href="/info/park?page=${i }"><b>${i }</b></a>	
				</c:otherwise>
			</c:choose>
			 
			<c:if test="${!vs.last }"> | </c:if>
		</c:forEach>
	</div>
</div>


