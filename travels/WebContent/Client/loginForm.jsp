<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>로그인 페이지</title>
</head>
<script src="http://code.jquery.com/jquery-3.3.1.js"></script>
<script src = "Client/login2.js"></script>
<link href ="css/login.css" rel="stylesheet">
<script>
	$(function(){
		$(".join").click(function(){
			location.href="join.net";
		})
	})
</script>
<body>
<h1>로그인</h1>
<hr>
	<form name ="loginform.jsp" action="loginProcess.net" method="post">
		아이디 : <input type="text" name="user_id" id="user_id" placeholder="Enter id..." >
		<br>
		비밀번호 : <input type="password" name="user_passwd" id="user_passwd" ><br>
	<hr>
		<div class="clearfix">
			<button type="submit" class="submitbtn">로그인</button>
			<input type="button" class="join" value="회원가입">
		</div>
	</form>
</body>
</html>