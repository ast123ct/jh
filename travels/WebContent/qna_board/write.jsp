<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<title>�����ϱ� �Խ���</title>
<link href="css/form.css" rel="stylesheet">
</head>
<body>
	<%@ include file="/qna_board/header.jsp"%>
	<form action="./AddAction.bo" method="post"
		enctype="multipart/form-data" name="boardform">
		<table>
			<tr class="center">
				<th colspan="2">�����ϱ� �Խ���-write ������</th>
			</tr>
			<tr>
				<td><div>�� ��</div></td>
				<td><input name="QNA_TITLE" id="qna_board_title" type="text"
					size="105" maxlength="100" value=""></td>
			</tr>
			<tr>
				<td><div>�� ��</div></td>
				<td><textarea name="QNA_CONTENT" id="qna_board_content"
						cols="100" rows="10">
			</textarea></td>
			</tr>
			<tr class="center">
				<td colspan="2" class="h30 lime"><input type="submit"
					value="�۾���"> <input type="reset" value="���"
					onClick="history.go(-1)"></td>
			</tr>
		</table>
	</form>
</body>
</html>