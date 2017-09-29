<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div align="center">
	<div style="width: 380px;" align="left">
		<h3>JOIN GOGO</h3>
		<h4>The BestWay to Study Software</h4>
		<h3 style="margin-top: 50px;">CREATE YOUR ACCOUNT</h3>
		<c:if test="${!empty temp }">
			<b style="color: red">join failed..</b>
		</c:if>
		<form action="/join" method="post" autocomplete="off">
				<div class="input-group"><span class="input-group-addon"><i
					class="glyphicon glyphicon-user"></i></span>
					<p>
				<label>ID</label><input class="form-control" type="text" name="id"
					required id="id" /><span id="chk_rst"></span>
					</p>
				</div>
				<div class="input-group"><span class="input-group-addon"><i 
					class="glyphicon glyphicon-lock"></i></span>
					<p>
					<label>PASS</label><input class="form-control" type="password"
						name="pass" required />
					</p>
				
   			    </div>
					<p>
					<label>EMAIL</label><input class="form-control" id="email"
						type="email" name="email" required />
					</p>
				
			<p>
				<button id="auth" type="button" class="form-control btn-primary">CONFIRM</button>
			</p>
			<p id="auth_view" style="display: none;">
				<b>AUTHORIZED KEY</b> <small id="left"
						style="color: red; font-weight: bold"></small><br /> <input
						id="authkey" type="email" name="email" required />
			</p>
			<button id="sbt" type="submit" disabled class="form-control">CREATE</button>
		
		</form>
	</div>
</div>
<script>
	var flag1 = false;
	var flag2 = false;

	var valid = function() {
		if (flag1 && flag2)
			document.getElementById("sbt").disabled = false;
	}

	var tot;
	var time;
	document.getElementById("auth").onclick = function() {
		if (document.getElementById("email").value.length != 0) {
			var e = document.getElementById("email").value;
			var xhr = new XMLHttpRequest();
			xhr.open("post", "/join/auth", true);
			// 파라미터 방식이 아닌 post requestBody로 처리하는게 가능하기에
			xhr.send(e); // 이메일만 넘겨보는 방식
			xhr.onreadystatechange = function() {
				if (this.readyState == 4) {
					window.alert(e + "\n로 인증키가 발송되었습니다.");
					document.getElementById("auth").style.display = "none";
					document.getElementById("auth_view").style.display = "";
					tot = 180;
					time = setInterval(limit, 1000);
				}
			}
		}
	}

	document.getElementById("authkey").onchange = function(e) {
		var key = document.getElementById("authkey").value;
		var param = "key=" + key;
		var xhr = new XMLHttpRequest();
		xhr.open("post", "/join/authCheck?" + param, true);
		// 파라미터 방식이 아닌 post requestBody로 처리하는게 가능하기에
		xhr.send(); // 이메일만 넘겨보는 방식
		xhr.onreadystatechange = function() {
			if (this.readyState == 4) {
				if (this.responseText == "YYYYY") {
					window.alert("인증에 성공하였습니다.");
					clearInterval(time);
					document.getElementById("auth_view").style.display = "none";
					document.getElementById("email").readOnly = true;
					document.getElementById("sbt").disabled = false;
				} else {
					window.alert("잘못된 인증키를 입력하셨습니다.");
				}
			}
		}
	}

	var limit = function() {
		var m = Math.floor(tot / 60);
		var s = tot % 60;
		document.getElementById("left").innerHTML = m + ":"
				+ (s < 10 ? "0" + s : s);
		tot--;
		if (tot < 0) {
			window.alert("인증시간이 초과되었습니다.");
			clearInterval(time);
			document.getElementById("auth").style.display = "";
			document.getElementById("auth_view").style.display = "none";
		}
	}
</script>





