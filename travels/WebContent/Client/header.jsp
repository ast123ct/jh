<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="header">
	<c:if test="${empty user_id }">
		<script>
			location.href="login.net";
		</script>
	</c:if>
	<c:if test="${!empty user_id }">
		<c:if test="${user_id=='admin' }">
			<span>관리자 ${user_id} 님 환영합니다.</span>
		</c:if>
		<c:if test="${user_id!='admin'}">
			<span>일반회원 ${user_id } 님 환영합니다. </span>
		</c:if>
	</c:if>
</div>
<span>(<a href="client_update.net">정보수정</a>)
(<a href="logout.net">로그아웃</a>)</span>
<hr>