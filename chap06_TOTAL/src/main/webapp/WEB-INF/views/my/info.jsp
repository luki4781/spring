<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div align="center" style="line-height: 25px;">
	<h2>${auth_id }'s INFO</h2>

	<div>
		<h3>세부정보</h3>
		<form action="/my/info" method="get">
			<p>
				<b>NAME : </b> ${auth.NAME }<br />
			</p>
			<p>
				<b>GENDER</b><br /> <input type="radio" name="gender" value="남" required />남
								    <input type="radio" name="gender" value="여" required />여
			</p>
			<p>
				<b>BIRTH : </b><br /> ${auth.BIRTH }
			</p>
			<p>
				<b>ADDRESS</b><br /> <input type="text" name="address" size="50" align="right"
					value="${auth.ADDRESS }" required />
			</p>
			<button type="submit">정보변경</button>
		</form>
	</div>
</div>