<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<head>
<meta>
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
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
 
   </div>
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
  <button class="dropbtn">고객센터</button>
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
    <a href="BusAdd.bus">버스 추가</a>
    <a href="BusSearch.bus">버스 검색</a>
  </div>
</div>

<div class="id">
   <a href="login.net">로그인</a>
</div>
</div>
</body>
</html>