<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<!DOCTYPE html>
<html>
<head>
<title>계정 찾기</title>
</head>
<script src="http://code.jquery.com/jquery-3.3.1.js"></script>
<script>
	$(function(){
		$("#findid").on("click",function(){
			var form = document.findidform;
			var url = "./FindIDAction.net";
			window.open("","popup_window", "width=500, height=500");
			form.action = url;
			form.method = "post";
			form.target = "popup_window";
			$("#findidform").submit();
		})
		$("#findpw").on("click",function(){
			var form = document.findpwform;
			var url = "./FindPasswdAction.net";
			window.open("","popup_window", "width=500, height=500");
			form.action = url;
			form.method = "post";
			form.target = "popup_window";
			$("#findpwform").submit();
		})	
	
	})
</script>
<body>
<jsp:include page="/MainHeader.jsp"></jsp:include>
<br>
<fieldset>
<form name="findidform" id="findidform">
	<div>
		<h3>아이디 찾기</h3>
	</div>
	<p>이름 : <input type="text" name="user_name"> </p>
	<p>이메일 : <input type="text" name="user_email"> </p>
	<input type="button" id="findid" value="찾기" >
</form>
<hr>
<form name="findpwform" id="findpwform" >
	<div>
		<h3>비밀번호 찾기</h3>
	</div>
	<p>아이디 : <input type="text" name="user_id"></p>
	<p>이름 : <input type="text" name="user_name"></p>
	<p>이메일 : <input type="text" name="user_email"></p>
	<input type="button" id="findpw" value="찾기">
</form>
</fieldset>
</body>
</html>