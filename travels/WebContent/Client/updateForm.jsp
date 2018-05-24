<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>회원 수정 페이지</title>
</head>
<script src="http://code.jquery.com/jquery-3.3.1.js"></script>
<script src = "./Client/update1.js"></script>
<link href="css/join.css" rel="stylesheet">
<script>
	$(document).ready(function(){
		var pandan = '${client.user_type}';
		if(pandan== '1'){
			$("input:radio").eq(0).attr('checked','checked');
		}else if(pandan=='2'){	
			$("input:radio").eq(1).attr('checked','checked');
		}else if(pandan=='3'){	
			$("input:radio").eq(2).attr('checked','checked');
		}else{	
			$("input:radio").eq(3).attr('checked','checked');
		}
		$(".cancelbtn").click(function(){
			location.href="main.net";
		})
	});
</script>
<body>

<form name="joinform" action="updateProcess.net" method="post">
	<h1>회원수정 페이지</h1>
	<hr>
	<b>아이디</b>
	<input type="text" name="user_id" placeholder="Enter id" value="${client.user_id }" readonly><br>
	<b>비밀번호</b>
	<input type="password" name="user_passwd" id="user_passwd" placeholder="Enter password" value="${client.user_passwd }" ><br>
	<b>이름</b>
	<input type="text" name ="user_name" id="user_name" placeholder="Enter name"  value="${client.user_name }" ><br>
	<b>이메일 주소</b>
	<input type="text" name="user_email" id="user_email" placeholder="Enter email" value="${client.user_email }" ><br><br>
	<b>성별</b>
	<div>
	<input type="radio" name="user_type"  value="1" ><span>1</span>
	<input type="radio" name="user_type"  value="2" ><span>2</span>
	<input type="radio" name="user_type"  value="3" ><span>3</span>
	<input type="radio" name="user_type"  value="4" ><span>4</span>
	
	</div><br>
	
	<div class="clearfix">
		<input type="submit" class="submitbtn" value="수정">
		<input type="button" class="cancelbtn" value="취소">
	</div>
	</form>
</body>
</html>