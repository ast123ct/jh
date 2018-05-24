<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:include page="/Client/header.jsp"></jsp:include>

<%--<c:set var="m" value="${memberinfo}"/> --%>
<!DOCTYPE html>
<html>
<head>
<title>회원 정보</title>
</head>

<body>
	<form>
		<table>
			<tr>
				<td colspan="2">회원 정보</td>
			</tr>
			<tr>
				<td>회원번호</td>
				<td>${info.user_no}</td>
			</tr>
			<tr>
				<td>ID</td>
				<td>${info.user_id}</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>${info.user_passwd}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${info.user_name}</td>
			</tr>
			<tr>
				<td>Email</td>
				<td>${info.user_email}</td>
			</tr>
			<tr>
				<td>성향</td>
				<td>${info.user_type}</td>
			</tr>
			<tr>
				<td colspan="2"><a href="client_list.net">리스트로 돌아가기</a></td>			
			</tr>
		</table>
	</form>
</body>
</html>