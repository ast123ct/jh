<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>ID 찾기</title>
</head>
<script src="http://code.jquery.com/jquery-3.3.1.js"></script>
<script>
	$(function(){
		$("#close").click(function(){
			self.close();
			opener.location.reload();
		})
	})
</script>
<body>
<h3>회원님의 ID는</h3><br>
${client.user_id}입니다.
<input type="button" id="close" value="닫기">
</body>
</html>