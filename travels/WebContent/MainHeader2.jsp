<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta>
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
	$(function(){
		$("#login").click(function(){
			window.open("./login.net","login",
					"width=500, height=500, scrollbar=no");
		})//click end
	})//ready end
</script>
<style>
.dropbtn {
    background-color: #4CAF50;
    color: white;
    padding: 16px;
    font-size: 16px;
    border: none;
}

.dropdown {
    position: relative;
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f1f1f1;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

.dropdown-content a:hover {background-color: #ddd}

.dropdown:hover .dropdown-content {
    display: block;
}

.dropdown:hover .dropbtn {
    background-color: #3e8e41;
}

.homeimg{
	display: inline-block;
}
.id{
   display: inline-block;float:right;
}
.full{
   background-color: silver;
}
</style>
</head>
<body>
<div class="full">

   <div class="homeimg">
 		<a href = "./Mainpage.jsp"><img src ="bono.jpg" width=40px ></a>
   </div>
<c:if test="${empty user_id }">
<div class="dropdown">
  <button class="dropbtn">여행지</button>
  <div class="dropdown-content">
    <a href="#">Link 1</a>
    <a href="#">Link 2</a>
    <a href="#">Link 3</a>
  </div>
</div>

<div class="dropdown">
  <button class="dropbtn">일정</button>
  <div class="dropdown-content">
    <a href="#">Link 1</a>
    <a href="#">Link 2</a>
    <a href="#">Link 3</a>
  </div>
</div>

<div class="dropdown">
  <button class="dropbtn">커뮤니티</button>
  <div class="dropdown-content">
    <a href="#">Link 1</a>
    <a href="#">Link 2</a>
    <a href="#">Link 3</a>
  </div>
</div>

<div class="dropdown">
  <button class="dropbtn">버스</button>
  <div class="dropdown-content">
    <a href="AreaList.bus">버스 조회</a>
  </div>
</div>

<div class="dropdown">
  <button class="dropbtn">고객센터</button>
  <div class="dropdown-content">
    <a href="NoticeList.no">공지 사항</a>
    <a href="#">문의 하기</a>
    <a href="#">Link 3</a>
  </div>
</div>

</c:if>

<c:if test="${!empty user_id }">
	
<c:if test="${user_id!='admin'}">
<div class="dropdown">
  <button class="dropbtn">여행지</button>
  <div class="dropdown-content">
    <a href="#">Link 1</a>
    <a href="#">Link 2</a>
    <a href="#">Link 3</a>
  </div>
</div>

<div class="dropdown">
  <button class="dropbtn">일정</button>
  <div class="dropdown-content">
    <a href="#">Link 1</a>
    <a href="#">Link 2</a>
    <a href="#">Link 3</a>
  </div>
</div>

<div class="dropdown">
  <button class="dropbtn">커뮤니티</button>
  <div class="dropdown-content">
    <a href="#">Link 1</a>
    <a href="#">Link 2</a>
    <a href="#">Link 3</a>
  </div>
</div>
<div class="dropdown">
  <button class="dropbtn">버스</button>
  <div class="dropdown-content">
    <a href="AreaList.bus">버스 조회</a>
  </div>
</div>

<div class="dropdown">
  <button class="dropbtn">고객센터</button>
  <div class="dropdown-content">
    <a href="NoticeList.no">공지 사항</a>
    <a href="#">문의 하기</a>
  </div>
</div>

<div class="dropdown">
  <button class="dropbtn">마이 페이지</button>
  <div class="dropdown-content">
    <a href="client_update.net">정보 조회</a>
    <a href=""></a>
  </div>
</div>
</c:if>

<c:if test="${user_id=='admin' }">
<div class="dropdown">
  <button class="dropbtn">여행지 관리</button>
  <div class="dropdown-content">
    <a href="#">축제 관리</a>
    <a href="#">관광 관리</a>
    <a href="#">Link 3</a>
  </div>
</div>

<div class="dropdown">
  <button class="dropbtn">게시판 관리</button>
  <div class="dropdown-content">
    <a href="#">커뮤니티 관리</a>
    <a href="#">커뮤니티 게시판</a>
    <a href="#">Link 3</a>
  </div>
</div>
<div class="dropdown">
  <button class="dropbtn">회원 관리</button>
  <div class="dropdown-content">
    <a href="client_list.net">회원 리스트 </a>
    <a href="#">회원 등등</a>
    <a href="#">Link 3</a>
  </div>
</div>

<div class="dropdown">
  <button class="dropbtn">버스 관리</button>
  <div class="dropdown-content">
    <a href="AreaList.bus">버스 조회</a>
    <a href="BusAdd.bus">버스 추가</a>
    <a href="BusSearch.bus">버스 검색</a>
  </div>
</div>

<div class="dropdown">
  <button class="dropbtn">고객센터</button>
  <div class="dropdown-content">
    <a href="NoticeList.no">공지 사항</a>
    <a href="#">문의 하기</a>
    <a href="#">Link 3</a>
  </div>
</div>

</c:if>
</c:if>

<div class="id">
  	<c:if test="${empty user_id }">
		<a href="" id="login">로그인</a>&nbsp;
		<a href="FindClientData.net" id="find">아이디/비밀번호 찾기</a><br>
		<a href="join.net" id="join">회원가입</a>
	</c:if>
	<c:if test="${!empty user_id }">
		<c:if test="${user_id=='admin' }">
			<span>관리자 ${user_id} 님</span>
			<span>(<a href="logout.net">로그아웃</a>)</span>
		</c:if>
		<c:if test="${user_id!='admin'}">
			<span>일반회원 ${user_id } 님 </span><br>
			<span>(<a href="logout.net">로그아웃</a>)</span>
		</c:if>
	</c:if>
</div>
</div>
</body>
</html>