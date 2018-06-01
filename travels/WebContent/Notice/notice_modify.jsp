<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html>
<html>
<head>
<title>공지 사항 수정</title>
</head>
<link href ="css/form.css" rel="stylesheet">
<body>
<jsp:include page="/MainHeader.jsp"></jsp:include>
	<form action="./NoticeModifyAction.no" method="post" name="modifyform">
		<input type="hidden" name="notice_no" value="${nb.notice_no }">
		<table>
			<tr class="center">
				<th colspan="2">공지 사항 수정</th>
			</tr>
			<tr>
				<td><div>글쓴이</div></td>
				<td><input name="admin_id" id="admin_id" readonly
				type="text" size="10" maxlength="30" value="${sessionScope.user_id}" ></td>
			</tr>
			<tr>
				<td><div>제  목</div></td>
				<td><input name="notice_title" id="notice_title" type="text"
				size="50" maxlength="100" value="${nb.notice_title}"></td>
			</tr>
			<tr>
				<td><div>내  용</div></td>
				<td><textarea name="notice_content" id="notice__content"
				rows="15" cols="65" >${nb.notice_content}
				</textarea></td>
			</tr>
			<tr class="center">
				<td colspan="2" class="h30_lime">
					<input type="submit" value="수정">
					<input type="button" value="취소" onClick="history.back()">
				</td>
			</tr>
		</table>		
	</form>
</body>
</html>




