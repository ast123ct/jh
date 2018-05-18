<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link href="css/form.css" rel="stylesheet">
</head>
<body>
<%@ include file="header.jsp" %>
<c:set var="boarddata" value="${boarddata}"/>
<br><br>
<table border='1'>
	<tr>
		<th>문의하기 - view페이지</th>
	<tr>
		<th>글번호	${boarddata.qna_no}</th> 
	
		<th>글제목 ${boarddata.qna_title}</th> 
		
	
		<th>내 용 ${boarddata.qna_content}</th> 
	
		<th>작성일 ${boarddata.qna_date}</th> 
		
	
		<th>회원번호 ${boarddata.user_no}</th> 
		
	</tr>

	
	<tr>
		<th>
		<a href="./ReplyView.bo?num=${boarddata.BOARD_NUM}">답변</a>&nbsp;&nbsp;
			
		<c:if test="${boarddata.BOARD_NAME == id || sessionScope.id=='admin'}">
		<a href="./ModifyView.bo?num=${boarddata.BOARD_NUM}">수정</a>&nbsp;&nbsp;
		<a href="./Delete.bo?num=${boarddata.BOARD_NUM}">삭제</a>&nbsp;&nbsp;
		</c:if>
		<a href="./List.bo">목록</a>
		
		

		</th> 
	</tr>

</table>
</body>
</html>