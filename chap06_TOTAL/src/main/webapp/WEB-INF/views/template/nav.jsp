<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div align="right" class="navbar navbar-inverse">
	<c:choose>
		<c:when test="${empty auth }">
			<b><a href="/login">login</a></b> | <b><a href="/join">join</a></b>
		</c:when>
		<c:otherwise>
			<p>
				<b>${auth.ID } <i>(${auth.NAME })</i>, LOG ON
				</b>
			</p>
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">Le zebre</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="/index">HOME</a></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">MY <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="/my/info">내 정보</a></li>
							<li><a href="/my/profile">프로필</a></li>
							<li><a href="/my/logout">로그아웃</a></li>
						</ul></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">MENU <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="/chat">채팅</a></li>
							<li><a href="/memo/send">쪽찌보내기</a></li>
							<li><a href="/board/list">게시판</a></li>
							<li><a href="/market/add"> 경매</a></li>
							<li><a href="/info/mlist">회원리스트</a></li>
							<li><a href="/info/park">주차장</a></li>
							
						</ul></li>
				</ul>
			</div>
		</c:otherwise>
	</c:choose>
</div>
<c:if test="${!empty auth }">
	<script>
		var lsw = new WebSocket("ws://192.168.10.88/ws/login");

		lsw.onmessage = function(e) {
			console.log(e.data);
			var obj = JSON.parse(e.data);
			switch (obj.mode) {
			case "memo":
				var m = obj.sender + "의 새 메시지가 도착하였습니다.\n확인하시겠습니까?";
				if (window.confirm(m)) {
					location.href = "/memo/list";
				}
			}
		}
	</script>
</c:if>