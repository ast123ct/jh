<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%request.setCharacterEncoding("utf-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>버스 시간표</title>
</head>
<body>
<table border="1">
	<thead>
		<tr>
			<th>지역</th><th>노선 번호</th><th>노선명</th>
			<th>출발 터미널</th><th>도착 지역</th><th>이동 시간</th>
			<th>성인 요금</th><th>청소년 요금</th><th>아동 요금</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="b" items="${bb}">
			<tr>
				<td><c:choose>
				<c:when test="${b.bus_area eq'Seoul'}">서울</c:when>
				<c:when test="${b.bus_area eq'Incheon'}">인천</c:when>
				<c:when test="${b.bus_area eq'Daejeon'}">대전</c:when>
				<c:when test="${b.bus_area eq'Busan'}">부산</c:when>
				<c:when test="${b.bus_area eq'Daegu'}">대구</c:when>
				<c:when test="${b.bus_area eq'Gwangju'}">광주</c:when>
				<c:when test="${b.bus_area eq'Ulsan'}">울산</c:when>
				<c:when test="${b.bus_area eq'Sejong'}">세종</c:when>
				<c:when test="${b.bus_area eq'Jeju'}">제주</c:when>
				<c:when test="${b.bus_area eq'Gyeonggi'}">경기</c:when>
				<c:when test="${b.bus_area eq'Gangwon'}">강원</c:when>
				<c:when test="${b.bus_area eq'Chungbuk'}">충북</c:when>
				<c:when test="${b.bus_area eq'Chungnam'}">충남</c:when>
				<c:when test="${b.bus_area eq'Jeonbuk'}">전북</c:when>
				<c:when test="${b.bus_area eq'Jeonnam'}">전남</c:when>
				<c:when test="${b.bus_area eq'Gyeongbuk'}">경북</c:when>
				<c:when test="${b.bus_area eq'Gyeongnam'}">경남</c:when>
				</c:choose>
				</td><td>${b.bus_no }</td><td>${b.bus_linename }</td>
				<td>${b.bus_start }</td><td>${b.bus_end }</td><td>${b.bus_traveltime }</td>
				<td>${b.bus_cost_ad }</td><td>${b.bus_cost_st }</td><td>${b.bus_cost_ch }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>