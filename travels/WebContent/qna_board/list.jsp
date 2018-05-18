<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>�����ϱ� �Խ���</title>
<link href="css/list.css" rel="stylesheet">
</head>
<body>
<%@ include file="/qna_board/header.jsp" %>

<h1>�����ϱ� �Խ���</h1>
<table>
<!-- ���ڵ尡 ������ -->
<c:if test="${listcount ==0 }">
	<tr>
		<td colspan="4">�����ϱ� �Խ���</td>
		<td style="text-align:right">
			<font size=2>��ϵ� ���� �����ϴ�.</font>
		</td>
	</tr>
</c:if>




<!-- ���ڵ尡 ������ -->
<c:if test="${listcount !=0 }">
	<tr>
		<th colspan="3">�����ϱ� �Խ��� - list</th>
		<th colspan="2">
			<font size=2>�� ���� : ${listcount}</font>
		</th>
	</tr>
	<tr>
	<th width="8%"><div>�۹�ȣ</div></th>
	<th width="50%"><div>������</div></th>
	<th width="14%"><div>�۳���</div></th>
	<th width="17%"><div>�ۼ���</div></th>
	<th width="11%"><div>ȸ����ȣ</div></th>
	</tr>
	
<c:set var="num" value="${listcount-(page-1)*10}"/>
<c:forEach var="list" items="${boardlist}">
	<tr>
		<td>
			<c:out value="${num}"/><%-- num ��� --%>
			<c:set var="num" value="${num-1}"/> <%-- num = num-1 --%>
		</td>
	<td>
			<div>
				�亯�� ����տ� ���� ó�� �κ�
					BOARD_RE_LEV, BOARD_RE_LEV, BOARD_NUM,
					BOARD_SUBJECT, BOARD_NAME, BOARD_DATE,
					BOARD_READCOUNT : property �̸�
				<c:if test="${list.BOARD_RE_LEV !=0}">
				<!-- ����� ��� -->
					<c:forEach var="a" begin="0" end="${list.BOARD_RE_LEV*2}" step="1">
					&nbsp;
					</c:forEach>
				��
				<a href="DetailAction.bo?num=${list.BOARD_NUM}">${list.BOARD_SUBJECT}</a>
				</c:if>
				</div>
				<div>
				<c:if test="${list.BOARD_RE_LEV ==0}">
				<!-- ������ ��� -->
				&nbsp; ��
				<a href="DetailAction.bo?num=${list.BOARD_NUM}">${list.BOARD_SUBJECT}</a>
				</c:if>
				
			</div>
		</td>	 
		
			
		<td><div>${list.BOARD_NAME}</div></td>
		<td><div>${list.BOARD_DATE}</div></td>
		<td><div>${list.BOARD_READCOUNT}</div></td>
	</tr>
	</c:forEach>
	
	<tr class="h30 lime center btn">
		<td colspan="5">
			<c:if test="${page<=1}">
				����&nbsp;
			</c:if>
			<c:if test="${page>1}">
				<a href="./List.bo?page=${page-1}">����</a>
			</c:if>
			
			<c:forEach var="a" begin="${startpage}" end="${endpage}">
				<c:if test="${a==page}">
					${a}
				</c:if>
				<c:if test="${a!=page}">
				<a href="./List.bo?page=${a}">${a}</a>
				</c:if>
			</c:forEach>
		
		
		

			<c:if test="${page>=maxpage}">
				����&nbsp;
			</c:if>
			<c:if test="${page<maxpage}">
				<a href="./List.bo?page=${page+1}">����</a>
			</c:if>
		</td>		
		
		
		
		
		
		
		
		
		
	</tr>

</c:if>


	<tr>
		<td colspan="5" style="text-align:right">
			<a href="./Write.bo">���۾��⡽</a>
		</td>
	</tr>
</table>

</body>
</html>