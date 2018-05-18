<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>문의하기 게시판</title>
<link href="css/list.css" rel="stylesheet">
</head>
<body>
<%@ include file="/qna_board/header.jsp" %>

<h1>문의하기 게시판</h1>
<table>
<!-- 레코드가 없으면 -->
<c:if test="${listcount ==0 }">
	<tr>
		<td colspan="4">문의하기 게시판</td>
		<td style="text-align:right">
			<font size=2>등록된 글이 없습니다.</font>
		</td>
	</tr>
</c:if>




<!-- 레코드가 있으면 -->
<c:if test="${listcount !=0 }">
	<tr>
		<th colspan="3">문의하기 게시판 - list</th>
		<th colspan="2">
			<font size=2>글 개수 : ${listcount}</font>
		</th>
	</tr>
	<tr>
	<th width="8%"><div>글번호</div></th>
	<th width="50%"><div>글제목</div></th>
	<th width="14%"><div>글내용</div></th>
	<th width="17%"><div>작성일</div></th>
	<th width="11%"><div>회원번호</div></th>
	</tr>
	
<c:set var="num" value="${listcount-(page-1)*10}"/>
<c:forEach var="list" items="${boardlist}">
	<tr>
		<td>
			<c:out value="${num}"/><%-- num 출력 --%>
			<c:set var="num" value="${num-1}"/> <%-- num = num-1 --%>
		</td>
	<td>
			<div>
				답변글 제목앞에 여백 처리 부분
					BOARD_RE_LEV, BOARD_RE_LEV, BOARD_NUM,
					BOARD_SUBJECT, BOARD_NAME, BOARD_DATE,
					BOARD_READCOUNT : property 이름
				<c:if test="${list.BOARD_RE_LEV !=0}">
				<!-- 답글인 경우 -->
					<c:forEach var="a" begin="0" end="${list.BOARD_RE_LEV*2}" step="1">
					&nbsp;
					</c:forEach>
				▶
				<a href="DetailAction.bo?num=${list.BOARD_NUM}">${list.BOARD_SUBJECT}</a>
				</c:if>
				</div>
				<div>
				<c:if test="${list.BOARD_RE_LEV ==0}">
				<!-- 원문인 경우 -->
				&nbsp; ▶
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
				이전&nbsp;
			</c:if>
			<c:if test="${page>1}">
				<a href="./List.bo?page=${page-1}">이전</a>
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
				다음&nbsp;
			</c:if>
			<c:if test="${page<maxpage}">
				<a href="./List.bo?page=${page+1}">다음</a>
			</c:if>
		</td>		
		
		
		
		
		
		
		
		
		
	</tr>

</c:if>


	<tr>
		<td colspan="5" style="text-align:right">
			<a href="./Write.bo">【글쓰기】</a>
		</td>
	</tr>
</table>

</body>
</html>