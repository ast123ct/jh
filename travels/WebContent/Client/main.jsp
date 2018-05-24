<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<title>메인 페이지</title>
</head>

<body>
	<%@ include file="/Client/header.jsp" %>
	<c:if test="${user_id=='admin' }">
	<a href="client_list.net">관리자 모드 접속(회원 목록 보기)</a>
	</c:if>
</body>
</html>