<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<style>
th {
	border-bottom: 3px solid;
	text-align: left;
}
th, td {
	padding: 10px;
}
</style>
<div align="center" style="line-height: 35px">
	<h2>게시판</h2>
	<p align="right" style="margin-right: 30px;">
		총 <b>${cnt }</b> 개의 글이 등록되어있습니다.
	</p>
	<table style="width: 80%">
		<thead>
			<tr>
				<th style="width: 10%">글번호</th>
				<th style="width: 60%">글제목</th>
				<th style="width: 20%">작성자</th>
				<th style="width: 10%">조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="obj" items="${list }">
				<tr>
					<td>${obj.num }</td>
					<td><a href="/board/view/${obj.num}">${fn:substring(obj.title, 0, 12) }
					</a></td>
					<td>${obj.writer }</td>
					<td><fmt:formatNumber value="${obj.count }" pattern="#,###" />
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p align="right" style="margin-right: 30px;">
		<a href="/board/add"><button type="button" style="padding: 5px;">글작성</button></a>
	</p>
</div>