<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.3.1.js"></script>
<script>
	$(document).ready(function(){
		$("#bus_area").change(function(event){
			event.preventDefault();
			$('#select_start').empty();
			var area = "area=" + $(this).val();
			output='';		
			$.getJSON('select_start.bus', area, function(data){
				output +='<option></option>'
				$(data).each(function(index){
					output += '<option value=\"' + this.bus_start + '\">';
					output += this.bus_start +'</option>';
				})//each end
				$("#select_start").append(output);
			})//JSON end
		})//change end
		$("#select_start").change(function(){
			$("#bus_start").val($("#select_start").val());
			var startdata = "bus_start=" + $(this).val();	
			output='';
			$.getJSON('select_end.bus', startdata,function(data){
				$("#select_end").empty();
				output +='<option></option>'
				$(data).each(function(index){					
					output += '<option value=\"' + this.bus_end + '\">';
					output += this.bus_end +'</option>';
				})//function end
				$('#select_end').append(output);
			})//JSON end
		})//change end
		$("#select_end").change(function(){
			$("#bus_end").val($("#select_end").val());
		})//change end
		$("#addline").click(function(){
			output='';
			output +='<tr>';
			output += '<td><input type=\"text\" name=\"bus_seq"></td>';
			output += '<td><input type=\"text\" name=\"bus_departure"></td>';
			output += '<td><input type=\"text\" name=\"bus_arrival"></td>';
			output +='</tr>';
			$("#tbody").append(output);
		})//click end
		$("#deleteline").click(function(){
			$('#addschedule > tbody:last > tr:last').remove();
		})//click end
		
	})//ready end
</script>
</head>
<body>
<jsp:include page="/MainHeader.jsp"></jsp:include>
<h3>${bus.bus_no }번 버스 노선 수정</h3>

<form name="BusModify" action="BusModifyProcess.bus" method="post">
<input type="hidden" name="bus_no" value="${bus.bus_no }">
	<table>
		<tr>
			<th>지역</th>
			<td>
			<input type="text" name="bus_area" value="${bus.bus_area }">
			<select id="bus_area" name="bus_area">
				<option></option>
				<option value="Seoul">서울</option>
				<option value="Incheon">인천</option>
				<option value="Daejeon">대전</option>
				<option value="Busan">부산</option>
				<option value="Daegu">대구</option>
				<option value="Gwangju">광주</option>
				<option value="Ulsan">울산</option>
				<option value="Sejong">세종</option>
				<option value="Jeju">제주</option>
				<option value="Gyeonggi">경기</option>
				<option value="Gangwon">강원</option>
				<option value="Chungbuk">충북</option>
				<option value="Chungnam">충남</option>
				<option value="Jeonbuk">전북</option>
				<option value="Jeonnam">전남</option>
				<option value="Gyeongbuk">경북</option>
				<option value="Gyeongnam">경남</option>
			</select></td>
		</tr>
		<tr>
			<th>노선 이름</th>
			<td><input type="text" name="bus_linename" value="${bus.bus_linename }"></td>
		</tr>
		<tr>
			<th>출발지</th>
			<td><input type="text" id="bus_start" name="bus_start" value="${bus.bus_start }">
			<select id="select_start" name="select_start">
			</select></td>
		</tr>
		<tr>
			<th>도착지</th>
			<td><input type="text" id="bus_end" name="bus_end" value="${bus.bus_end }">
			<select id="select_end" name="select_end">
			</select></td>
		</tr>
		<tr>
			<th>이동 시간</th>
			<td><input type="text" name="bus_traveltime" value="${bus.bus_traveltime }"></td>
		</tr>
		<tr>
			<th>성인 비용</th>
			<td><input type="text" name="bus_cost_ad" value="${bus.bus_cost_ad }"></td>
		</tr>
		<tr>
			<th>청소년 비용</th>
			<td><input type="text" name="bus_cost_st" value="${bus.bus_cost_st }"></td>
		</tr>
		<tr>
			<th>아동 비용</th>
			<td><input type="text" name="bus_cost_ch" value="${bus.bus_cost_ch }"></td>
		</tr>
	</table>
	<table id="addschedule">
		<tr>
			<th>순서</th><th>출발 시간</th><th>도착 시간</th>
			<th><input type="button" id="addline" value="추가">
			<input type="button" id="deleteline" value="삭제"></th>
		</tr>
	<tbody id="tbody">
	<c:forEach var="b" items="${schedulelist }">
		<tr>
			<td><input type="text" name="bus_seq" value="${b.bus_seq }"></td>
			<td><input type="text" name="bus_departure" value="${b.bus_departure }"></td>
			<td><input type="text" name="bus_arrival" value="${b.bus_arrival }"></td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
	<input type="submit" value="노선 수정">
	<input type="reset" value="초기화">
</form>
</body>
</html>