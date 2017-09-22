<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div align="center" style="line-height: 35px" >
	<h2>쪽지보내기</h2>
	<form action="/memo/send" method="post" autocomplete="off">
		<p>
			<b>받을사람</b><br /> 
			<input type="text" list="flist" name="receiver" placeholder="받을사람.." 
				autocomplete="off"/>
		</p>
		<p>
			<b>보낼내용</b><br /> 
			<textarea rows="6" cols="40" name="content" placeholder="보낼내용.."></textarea>
		</p>
		<p>
			<button type="submit">쪽지발송</button>
			<button type="reset">재작성</button>
		</p>
	</form>
</div>

