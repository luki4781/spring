<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div align="right">
	<c:choose>
		<c:when test="${empty auth }">
			<b><a href="/login">login</a></b> | <b><a href="/join">join</a></b>
		</c:when>
		<c:otherwise>
			<p>
				<b>${auth.ID } <i>(${auth.NAME })</i>, LOG ON</b>
			</p>
			<p>
				<a href="/my/info">내정보</a> | <a href="/my/profile">프로필</a> | <a href="/my/logout">로그아웃</a> 
			</p>
			<p>
				<a href="/board/list">게시판</a> |  <a href="/info/mlist">회원리스트</a> 
		</c:otherwise>
	</c:choose>
</div>