<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
	<div class="col-sm-3">
		<h3>WELCOME</h3>
		-login
	</div>
	
	<div class="col-sm-9">
		<div style="width: 340px;" align="left">
			<h3>LOGIN GOGO</h3>
			<c:if test="${!empty temp }">
				<b style="color: red">login failed..</b>
			</c:if>
			<form action="/login" method="post" autocomplete="off">
				<c:if test="${ !empty param.redirect }">
					<input type="hidden" name="redirect" value="${param.redirect }" />
				</c:if>
				<div class="input-group"><span class="input-group-addon"><i
					class="glyphicon glyphicon-user"></i></span>
				<p>
					<b>ID or Email Address</b><br /> <input type="text" name="idmail"
						required id="idmail" /><br /> <span id="chk_rst"></span>
				</p>
				</div>
				<div class="input-group"><span class="input-group-addon"><i 
					class="glyphicon glyphicon-lock"></i></span>
				<p>
					<b>PASS</b><br /> <input type="password" name="pass" required />
				</p>
				</div>
				<button id="sbt" type="submit" style="">L O G I N</button>
			</form>
		</div>
		<div style="width: 340px; margin-top: 20px;" align="center">
			New to HUB? <a href="/join">Create an account.</a>
		</div>
	</div>
</div>
