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
		<th>�����ϱ� - view������</th>
	<tr>
		<th>�۹�ȣ	${boarddata.qna_no}</th> 
	
		<th>������ ${boarddata.qna_title}</th> 
		
	
		<th>�� �� ${boarddata.qna_content}</th> 
	
		<th>�ۼ��� ${boarddata.qna_date}</th> 
		
	
		<th>ȸ����ȣ ${boarddata.user_no}</th> 
		
	</tr>

	
	<tr>
		<th>
		<a href="./ReplyView.bo?num=${boarddata.BOARD_NUM}">�亯</a>&nbsp;&nbsp;
			
		<c:if test="${boarddata.BOARD_NAME == id || sessionScope.id=='admin'}">
		<a href="./ModifyView.bo?num=${boarddata.BOARD_NUM}">����</a>&nbsp;&nbsp;
		<a href="./Delete.bo?num=${boarddata.BOARD_NUM}">����</a>&nbsp;&nbsp;
		</c:if>
		<a href="./List.bo">���</a>
		
		

		</th> 
	</tr>

</table>
</body>
</html>