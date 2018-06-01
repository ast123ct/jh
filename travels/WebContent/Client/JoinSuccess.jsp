<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
	$(function(){
		$("#login").click(function(){
			window.open("./login.net","login",
					"width=500, height=500, scrollbar=no");
		})//click end
	})//ready end
</script>
<body>
<jsp:include page="/MainHeader.jsp"></jsp:include>
<h1>가입을 환영합니다.</h1><br>
<h2>회원님은&nbsp;

<c:choose>
	<c:when test="${c==1 }">
	모험 추구 여행자
	</c:when>
	<c:when test="${c==2 }">
	경험 추구 여행자
	</c:when>
	<c:when test="${c==3 }">
	안정 추구 여행자
	</c:when>
	<c:when test="${c==4 }">
	감각 추구 여행자
	</c:when>
	<c:otherwise>
	미생 여행자
	</c:otherwise>
</c:choose>
입니다.</h2><br>
<h3><a href="" id="login" >로그인</a></h3>
</body>
</html>