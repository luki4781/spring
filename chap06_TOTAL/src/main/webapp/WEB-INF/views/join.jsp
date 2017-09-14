<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div align="center">
	<h2>JOIN</h2>
	<c:if test="${!empty temp }">
	</c:if>
	<form action="/index" method="post" autocomplete="off">
		<p>
			<b>ID</b><br /> <input type="text" name="id" required id="id" /><br />
			<span id="chk_rst"></span>
		</p>
		<p>
			<b>PASS</b><br /> <input type="password" name="pass" required />
		</p>
		<p>
			<b>EMAIL</b><br /> <input type="email" name="email" required />
		</p>
		<button id="sbt" type="submit">JOINING</button>
	</form>
</div>

