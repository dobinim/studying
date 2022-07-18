<!-- JSP -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "sql" uri = "http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix = "x" uri = "http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html>
<html lang = "ko">
<head>
<meta charset="UTF-8">
<!-- RWD -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- MS -->
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8,IE=EmulateIE9"/>

<title>book list 2(추천도서목록)</title>

<!-- bootstrap -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!-- popper JS(jQuery) -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- latest javascript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<!--fontawesome icon (ver 5) -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" 
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
<!-- google icon -->
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

<style>
html, body {
	height : 100%,
	margin : 0,
	padding : 0;
}

h3 {
	text-align:center;
	color : #3f3f48;
}

hr {
	border : 0;
	height : 2px;
	background : gray;
}

#myrthead {
	background-color : #3f3f48;
	color:white;
	text-align : center;
}

#rbooklist_2 {
	color : #3f3f48;
	text-align : center;
}

#booktitle {
	color : #3f3f48;
}

.page-link {
	color : #3f3f48;
	background-color : #ffffff;

}

.page-link:focus {
	background-color : #d7d8df;
	color : #527062;
}

.page-item.active .page-link {
	color : #ececf0;
	background-color : #527062;
	font-weight : bold;
}

#enrollbtn {
	float: right;
}

#login a {
	color : white;
	float : right;
	padding-left : 10px;
	padding-top : 5px;
}
#top-menu li {
	color : white;
	font-weight : bold;
	display : inline-block;
	margin-left : 40px;
	margin-right : 40px;
}
#top-menu a {
	color : white;
	font-weight : bold;
}
#top-menu {
	position : -webkit-sticky;
 	position : sticky;
 	top : 0;
	z-index : 1050;
	margin : 0 auto;
	left : 0;
	right : 0;
}
</style>

<script>


</script>
</head>
<body>

<nav id="login" class="container-fluid" style="height:30px; background-color:#3f3f48;">
	<div class="container">
		<span class="ml-auto mb-auto mr-3">
			<a href="#">회원가입</a>
			<a href="#">로그인</a>
		</span>
	</div>
</nav>

<!-- 로고, 검색창 -->
<div class="container mt-3" id="top">
	<div class="row">
		<div class="col-3 d-flex">
			<div style="display:inline-block; text-align:left;" class="align-self-center">
				<a href="home.do">
					<img src="media/도서관로고.png" alt="logo" style="width:100%;"/>
				</a>
			</div>
		</div>
		
		<div class="col-6 d-flex">	
			<div style="display:inline-block; text-align:center; width:100%;" class="align-self-center">
				<form action="#" method="post" id="search">
					<div class="input-group input-group-lg" style="width:100%;">
						<input type="text" class="form-control" placeholder="검색"/>
						<div class="input-group-append">
							<button class="btn btn-dark" type="submit">
								<i class="fas fa-search"></i>
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		
		<div class="col-3 d-flex">
			<div style="display:inline-block;" class="align-self-center">
				<div class="card" style="height:100px;">
					<div class="row">
						<div class="col-3">
							<img src="media/user.png" class="rounded-circle mt-4 ml-3" style="width:150%;"/>
						</div>
						<div class="col-9">
							<div class="card-body">
								<p class="card-text" style="width:100%;">OOO님 환영합니다.</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- 탑메뉴 -->
<nav id="top-menu" class="navbar navbar-expand-lg navbar-dark container" style="background-color:#527062;">
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#t-toggle">
		<span class="navbar-toggler-icon"></span>
	</button>
	
	<div class="justify-content-center collapse navbar-collapse" id="t-toggle">
		<ul class="navbar-nav">
			<li class="nav-item">
				<a class="nav-link" href="#" id="menu1">도서관소개</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="#" id="menu2">자료검색</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="#" id="menu3">열린공간</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="#" id="menu4">문화강좌</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="#" id="menu5">마이페이지</a>
			</li>
		</ul>
	</div>
</nav>
	
<script>
$(document).ready(function(){
	$("#menu1, #menu2, #menu3, #menu4, #menu5").mouseover(function(){
		$(this).css("color","#dbcfc8");
	});
	$("#menu1, #menu2, #menu3, #menu4, #menu5").mouseout(function(){
		$(this).css("color","white");
	});
});
</script>



																							<!-- 추천도서 게시판 -->
<div class = "container mx-auto mt-3">
	<h3 id = "rbookh3">이 달의 추천도서</h3>
	<table class = "table table-hover" id = "rbooklist">
		<thead id = "myrthead">
			<tr>
				<th>No.</th>
				<th>제목</th>
				<th>저자</th>
				<th>출판사</th>
				<th>출판년도</th>
				<th>등록일</th>
			</tr>
		</thead>
		<tbody id = "rbooklist_2">
			<c:forEach items = "${list}" var = "rdto">
				<tr>
					<td>${rdto.rbId}</td>
					<td>
						<a href = "contentView.do?rbId=${rdto.rbId}" id = "booktitle">${rdto.rbTitle}</a>
					</td>
					<td>${rdto.rbName}</td>
					<td>${rdto.rbPub}</td>
					<td>${rdto.rbPubYear}</td>
					<td>${rdto.rbDate}</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan = "6"><a class = "btn btn-secondary" href = "writeForm.do" id = "enrollbtn">책 등록</a></td>
			</tr>
		</tfoot>

	</table>
	<hr/>
</div>

<div class = "container">
	<ul class = "pagination justify-content-center">
		<li class = "page-item disabled"><a class = "page-link" href = "#">Previous</a></li>
		<li class = "page-item active"><a class = "page-link" href = "#">1</a></li>
		<li class = "page-item"><a class = "page-link" href = "#">2</a></li>
		<li class = "page-item"><a class = "page-link" href = "#">3</a></li>
		<li class = "page-item"><a class = "page-link" href = "#">4</a></li>
		<li class = "page-item"><a class = "page-link" href = "#">5</a></li>
		<li class = "page-item"><a class = "page-link" href = "#">Next</a></li>
	</ul>
</div>
</body>
</html>