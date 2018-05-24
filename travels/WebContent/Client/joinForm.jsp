<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>회원가입</title>
<script src="http://code.jquery.com/jquery-3.3.1.js"></script>
<script>
	$(document).ready(function(){
		var data_check = -1; //아이디 중복 확인 버튼 클릭 유무를 확인하기 위한 변수
							//아이디 존재하여 사용 불가능을 의미
		var sid, sid2;
		$("#message").css('display', 'none');//영역을 숨깁니다.
		$("#idcheck").click(function(){
			if($("input[name=user_id]").val()==''){
				alert('아이디를 입력하세요');
				$("input[name=user_id]").focus();
				return false;
			}
			sid=$("input[name=user_id]").val();
			$.ajax({
				type : "GET",
				url : "IdcheckAjax.net",
				data : {"user_id" : $("input[name=user_id]").val()},
				success : function(response){
					data_check = response;
					$("#message").empty();
					$("#message").show();
					if(response ==1){
						$("#message").append("사용 가능한 아이디 입니다.");
						$("#message").css('color','red');
					}else{
						$("#message").append("중복된 아이디 입니다.");
						$("#message").css('color','red');
						$("input[name=user_id]").val('');
						$("input[name=user_id]").focus();
					}
				},
					error:function(){
						alert("data error2");
					}
			})//ajax end
		})//click end

	$('form').submit(function(){
		sid2 = $("input[name=user_id]").val();//사용 가능한 아이디인데 변경한 경우
		//중복체크 후 사용 가능한 아이디락 메시지 나왔지만 아이디 변경하고 중복 체크하지 않은 경우
		if(data_check == -1 || sid != sid2){
			alert("ID 중복 체크 하세요");
			return false;
		}
	})//submit end
})//ready end
	
</script>
</head>
<script src = "http://code.jquery.com/jquery-3.3.1.js"></script>
	<script src = "./Client/join3.js"></script>
	<link href ="css/join.css" rel="stylesheet">
<body>
	<form name="joinform" action="joinProcess.net" method="post">
	<h1>회원가입 페이지</h1>
	<hr>
	<b>아이디&nbsp;<input type="button" id="idcheck" value="중복 검사" >
	<b id="message"></b></b>
	<input type="text" name="user_id" id="user_id" placeholder="Enter id" ><br>
	<b>비밀번호</b>
	<input type="password" name="user_passwd" id="user_passwd" placeholder="Enter password" ><br>
	<b>이름</b>
	<input type="text" name ="user_name" id="user_name" placeholder="Enter name" ><br>
	<b>이메일 주소</b>
	<input type="text" name="user_email" id="user_email" placeholder="Enter email" ><br><br>
	<b>성향</b>
	<div>
		<input type="radio" name="user_type" value="1" ><span>1</span>
		<input type="radio" name="user_type" value="2" ><span>2</span>
		<input type="radio" name="user_type" value="3" ><span>3</span>
		<input type="radio" name="user_type" value="4" ><span>4</span>
	</div><br>
	
	<div class="clearfix">
		<button type="submit" class="submitbtn">회원가입</button>
		<button type="reset" class="cancelbtn">다시작성</button>
	</div>
	</form>
</body>
</html>