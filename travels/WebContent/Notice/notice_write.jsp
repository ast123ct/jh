<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>MVC 게시판-write 페이지</title>
</head>
<link href ="css/form.css" rel="stylesheet">
<body>
<jsp:include page="/MainHeader.jsp"></jsp:include>
	<form action="./NoticeAddAction.no" method="post" name="boardform">
		<table>
			<tr class="center">
				<th colspan="2">공지 사항 작성</th>
			</tr>
			<tr>
				<td><div>글쓴이</div></td>
				<td><input name="admin_id" id="admin_id" readonly
				type="text" size="10" maxlength="30" value="${user_id}" ></td>
			</tr>
			<tr>
				<td><div>제  목</div></td>
				<td><input name="notice_title" id="notice_title" type="text"
				size="50" maxlength="100" value=""></td>
			</tr>
			<tr>
				<td><div>내  용</div></td>
				<td><textarea name="notice_content" id="notice_content"
				rows="15" cols="65"></textarea></td>
			</tr>
			<tr class="center">
				<td colspan="2" class="h30_lime">
					<input type="submit" value="등록">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>		
	</form>
</body>
</html>




