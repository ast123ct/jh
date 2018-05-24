<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>지역</title>
</head>
<script src="http://code.jquery.com/jquery-3.3.1.js"></script>
<script>
	$(document).ready(function(){		
				
		$("#bus_area button").click(function(event){
			 event.preventDefault();
				var senddata = "area=" + $(this).attr('value');	
			 output='';
			//var data = $("bus_area").serialize(); input인 경우
			$.getJSON('Bus/select_start.jsp',senddata,function(rdata){
				$("#bus_start").empty();
				$("#bus_end").empty();
				$("#output").empty();
				output +='<option></option>'
				$(rdata).each(function(index){
					output += '<option value=\"' + this.bus_start + '\">';
					output += this.bus_start +'</option>';
				})//function end
				console.log(output);
					$('#bus_start').append(output);
			})//JSON end						
		})//click end		
		
		$("#bus_start").change(function(event){
			var startdata = "bus_start=" + $(this).val();	
			output='';
			$.getJSON('Bus/select_end.jsp', startdata,function(data){
				$("#bus_end").empty();
				output +='<option></option>'
				$(data).each(function(index){					
					output += '<option value=\"' + this.bus_end + '\">';
					output += this.bus_end +'</option>';
				})//function end
				$('#bus_end').append(output);
			})//JSON end
		})//change end	
		
		$("#bus_end").change(function(envent){
			var enddata = "bus_end=" + $(this).val();
			$.getJSON('Bus/select_no.jsp', enddata, function(data){	
				$(data).each(function(index){
					$("#search").val(this.bus_no);
				})
			})//JSON end
		})//change end
		
		$("#select button").click(function(event){
			event.preventDefault();
			var nodata = "bus_no=" + $("#search").val();	
			output='';
			$.getJSON('Bus/search.jsp', nodata,function(data){
				$(data).each(function(index){
					output += '<tr>';
					output += '<td>'+this.bus_seq+'</td>';
					output += '<td>'+this.bus_linename+'</td>';
					output += '<td>'+this.bus_departure+'</td>';
					output += '<td>'+this.bus_traveltime+'</td>';
					output += '<td>'+this.bus_arrival+'</td>';
					output += '<td>'+this.bus_cost_ad+'</td>';
					output += '<td>'+this.bus_cost_st+'</td>';
					output += '<td>'+this.bus_cost_ch+'</td>';
					output += '</tr>';
				})//function end
				$('#output').append(output);
			})//JSON end
		})//click end
	})//ready end
</script>
<body>
<form id="bus_area">
	<fieldset>
		<table>
			<tr>
			<td><button name="area" value="Seoul">서울</button></td>
			<td><button name="area" value="Incheon">인천</button></td>
			<td><button name="area" value="Daejeon">대전</button></td>
			<td><button name="area" value="Busan">부산</button></td>
			<td><button name="area" value="Daegu">대구</button></td>
			<td><button name="area" value="Gwanju">광주</button></td>
			</tr>
			<tr>
			<td><button name="area" value="Ulsan">울산</button></td>
			<td><button name="area" value="Sejong">세종</button></td>
			<td><button name="area" value="Jeju">제주</button></td>
			<td><button name="area" value="Gyeonggi">경기</button></td>
			<td><button name="area" value="Gangwon">강원</button></td>
			<td><button name="area" value="Chungbuk">충북</button></td>
			</tr>
			<tr>
			<td><button name="area" value="Chungnam">충남</button></td>
			<td><button name="area" value="Jeonbuk">전북</button></td>
			<td><button name="area" value="Jeonnam">전남</button></td>
			<td><button name="area" value="Gyeongbuk">경북</button></td>
			<td><button name="area" value="Gyeongnam">경남</button></td>
			</tr>
		</table>
	</fieldset>
</form>

<form id=select>
	<select id="bus_start" name="bus_start">
	</select>
	<select id="bus_end"  name="bus_end">
	</select>
	<select id="date" name="date">
	</select>
	<button name="search" id="search">조회</button>
<div>
	<table border="1">
	<thead>
		<tr>
			<th>순서</th><th>노선명</th><th>출발 시간</th><th>이동 시간</th><th>도착 시간</th><th>성인 비용</th><th>청소년 비용</th><th>아동 비용</th>
		</tr>
	</thead>
	<tbody id="output"></tbody>
	</table>
</div>
</form>
</body>
</html>

