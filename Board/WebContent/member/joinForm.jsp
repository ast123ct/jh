<%@ page language="java" contentType="text/html; charset=euc-kr"
    pageEncoding="euc-kr"%>
<!DOCTYPE html>
<html>
<head>
<title>회원가입</title>
</head>
<script src = "http://code.jquery.com/jquery-3.3.1.js"></script>
	<script src = "./member/join.js"></script>
	<link href ="css/join.css" rel="stylesheet">
<body>
	<form name="joinform" action="joinProcess.net" method="post">
	<h1>회원가입 페이지</h1>
	<hr>
	<b>아이디</b>
	<input type="text" name="id" id="id" placeholder="Enter id" ><br>
	<b>비밀번호</b>
	<input type="password" name="pass" id="pass" placeholder="Enter password" ><br>
	<b>이름</b>
	<input type="text" name ="name" id="name" placeholder="Enter name" ><br>
	<b>나이</b>
	<input type="text" name="age" id="age" maxlength=2 placeholder="Enter age"><br>
	<b>성별</b>
	<div>
		<input type="radio" name="gender" value="남" checked><span>남자</span>
		<input type="radio" name="gender" value="여" ><span>여자</span>
	</div><br>
	<b>이메일 주소</b>
	<input type="text" name="email" id="email" placeholder="Enter email" ><br><br>
	<div class="clearfix">
		<button type="submit" class="submitbtn">회원가입</button>
		<button type="reset" class="cancelbtn">다시작성</button>
	</div>
	</form>
</body>
</html>