<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<title>페이지 뷰</title>
</head>
<link href ="css/form.css" rel="stylesheet">
<body>
<jsp:include page="/MainHeader.jsp"></jsp:include>
	<form name="boardform">
		<table>
			<tr class="center">
				<th colspan="2">공지 사항</th>
			</tr>
			<tr>
				<td><div>글쓴이</div></td>
				<td><div>${nb.admin_id}</div></td>
			</tr>
			<tr>
				<td><div>제  목</div></td>
				<td><div>${nb.notice_title}</div></td>
			</tr>
			<tr>
				<td><div>내  용</div></td>
				<td><div>${nb.notice_content}</div></td>
			</tr>
			<tr class="center">
				<td colspan="2" class="center">
					<c:if test="${nb.admin_id == user_id || user_id == 'admin'}">
					<a href="./NoticeModifyView.no?num=${nb.notice_no}">
					수정</a>&nbsp;&nbsp;
					<a href="./NoticeDeleteAction.no?num=${nb.notice_no}">
					삭제</a>&nbsp;&nbsp;
					</c:if>					
					<a href="./NoticeList.no">
					목록</a>					
				</td>
			</tr>
		</table>		
	</form>
</body>
</html>