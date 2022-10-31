<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<!-- RWD -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- MS -->
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8,IE=EmulateIE9"/> 
<title>home</title>
<!--bootstrap-->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<!--jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!--propper jquery -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!--latest javascript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<!--fontawesome icon-->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" 
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
<!--google icon -->
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

<style>
.row div img {
	margin-left :  auto;
	margin-right : auto;
	display : block;
}
#icon .row div span {
	text-align : center;
	display : block;
	font-weight : bold;
}
#link1, #link2, #link3, #link4, #link5 {
	color : black;
	text-decoration : none;
}
#book a {
	color : black;
	text-decoration : none;
}
#book span {
	display:block;
	text-align:center;
}
#book img {
	 height:300px;
}

</style>
</head>
<body>

<!-- top 메뉴 include -->
<jsp:include page="top.jsp" flush="false"/>

<!-- 상단배너 -->
<div class="container mt-3" id="top-banner">
	<img src="media/library.jpg" style="width:100%;" class="rounded"/>
</div>

<!-- 메뉴 아이콘 -->
<div class="container-xl mt-3 mb-3 pt-2 pb-2 rounded" style="background-color:#ececf0;"id="icon">
	<div class="row">
		<div class="col-1"></div>
		<div class="col-2">
			<img src="media/book.png" alt="자료찾기" style="width:70px; height:70px; text-align:center;"/>
			<span>
				<a href="#" id="link1">자료 찾기</a>
			</span>
		</div>
		<div class="col-2">
			<img src="media/clock.png" alt="자료예약" style="width:70px; height:70px;"/>
			<span>
				<a href="#" id="link2">자료 예약</a>
			</span>
		</div>
		<div class="col-2">
			<img src="media/pc.png" alt="게시판" style="width:70px; height:70px;"/>
			<span>
				<a href="#" id="link3">게시판</a>
			</span>
		</div>
		<div class="col-2">
			<img src="media/tree.png" alt="시설" style="width:70px; height:70px;"/>
			<span>
				<a href="#" id="link4">시설 안내</a>
			</span>
		</div>
		<div class="col-2">
			<img src="media/build.png" alt="소개" style="width:70px; height:70px;"/>
			<span>
				<a href="#" id="link5">도서관 소개</a>
			</span>
		</div>
		<div class="col-1"></div>
	</div>
</div>

<!-- 책 추천 -->
<div class="container mt-3 mb-3 p-2" id="book" style="height:500px;">
	<ul class="nav nav-tabs" role="tablist">
		<li class="nav-item">
			<a href="#book1" class="nav-link active" data-toggle="tab">베스트 셀러</a>
		</li>
		<li class="nav-item">
			<a href="#book2" class="nav-link" data-toggle="tab">추천 도서</a>
		</li>
		<li class="nav-item">
			<a href="#book3" class="nav-link" data-toggle="tab">신간 도서</a>
		</li>
	</ul>
	
	<!-- 책 -->
	<div class="tab-content">
	<!-- 베스트셀러 -->
		<div id="book1" class="container tab-pane active mt-5 mb-5">
			<div class="row">
				<div class="col-3" style="height:300px;">
					<a href="#">
						<img src="media/불편한편의점.jpg" style="text-align:center; width:80%;"/>
					</a>
				</div>
				<div class="col-3">
					<a href="#">
						<img src="media/미드나잇라이브러리.jpg" style="text-align:center; width:80%;"/>
					</a>
				</div>
				<div class="col-3">
					<a href="#">
						<img src="media/1984.jpg" style="text-align:center; width:80%;"/>
					</a>
				</div>
				<div class="col-3">
					<a href="contentView.do?bookId=${home.bookId}">
						<img src="media/나미야잡화점.jpg" style="text-align:center; width:80%;"/>
					</a>
				</div>
			</div>
		</div>
	<!-- 추천도서 -->
		<div id="book2" class="container tab-pane mt-5 mb-5">
			<div class="row">
				<div class="col-3">
					<a href="#">
						<img src="media/테라피스트.jpg" style="text-align:center; width:80%;"/>
					</a>
				</div>
				<div class="col-3">
					<a href="#">
						<img src="media/참을수없는존재의가벼움.jpg" style="text-align:center; width:80%;"/>
					</a>
				</div>
				<div class="col-3">
					<a href="#">
						<img src="media/이웃집 백만장자.jpg" style="text-align:center; width:80%;"/>
					</a>
				</div>
				<div class="col-3">
					<a href="#">
						<img src="media/어린왕자.jpg" style="text-align:center; width:80%;"/>
					</a>
				</div>
			</div>
			<div class="row mt-2">
				<div class="col-3">
					<a href="#"><span>테라피스트</span></a>
				</div>
				<div class="col-3">
					<a href="#"><span>참을 수 없는 존재의 가벼움</span></a>
				</div>
				<div class="col-3">
					<a href="#"><span>이웃집 백만장자</span></a>
				</div>
				<div class="col-3">
					<a href="#"><span>어린 왕자</span></a>
				</div>
			</div>
		</div>
	<!-- 신간도서 -->
		<div id="book3" class="container tab-pane mt-5 mb-5">
			<div class="row">
				<div class="col-md-3">
					<a href="#">
						<img src="media/교도관의눈.jpg" style="text-align:center; width:80%;"/>
					</a>
				</div>
				<div class="col-3">
					<a href="#">
						<img src="media/기적일지도몰라.jpg" style="text-align:center; width:80%;"/>
					</a>
				</div>
				<div class="col-3">
					<a href="#">
						<img src="media/눈물한방울.jpg" style="text-align:center; width:80%;"/>
					</a>
				</div>
				<div class="col-3">
					<a href="#">
						<img src="media/오래된기억들의방.jpg" style="text-align:center; width:80%;"/>
					</a>
				</div>
			</div>
			<div class="row mt-2">
				<div class="col-3">
					<a href="#"><span>교도관의 눈</span></a>
				</div>
				<div class="col-3">
					<a href="#"><span>기적일지도 몰라</span></a>
				</div>
				<div class="col-3">
					<a href="#"><span>눈물 한 방울</span></a>
				</div>
				<div class="col-3">
					<a href="#"><span>오래된 기억들의 방</span></a>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- 배너, 공지 -->
<div class="container mt-3" id="event-banner">
	<div class="row">
		<div class="col-md-3" style="padding:0px 5px 0px 0px;">
			<div style="width:100%; height:154px; overflow:auto;">
				<h6 style="font-weight:bold; display:inline;">공지사항</h6>
				<a href="#" style="color:black" class="text-decoration-none">
					<i style="float:right" class="fa fa-plus mr-3 mt-1" title="더보기"></i>
				</a>
				<hr/>
				<a href="#" class="text-decoration-none">
					<span style="text-align:left">공지사항 1</span>
				</a>
				<br/>
				<a href="#" class="text-decoration-none">
					<span style="text-align:left">공지사항 2</span>
				</a>
				<br/>
				<a href="#" class="text-decoration-none">
					<span style="text-align:left">공지사항 3</span>
				</a>
				<br/>
				<a href="#" class="text-decoration-none">
					<span style="text-align:left">공지사항 4</span>
				</a>
				<br/>
				<a href="#" class="text-decoration-none">
					<span style="text-align:left">공지사항 5</span>
				</a>
				<br/>
				<a href="#" class="text-decoration-none">
					<span style="text-align:left">공지사항 6</span>
				</a>
			</div>
		</div>
		<div class="col-md-9" style="padding:0px 0px 0px 5px;">
			<div class="carousel">
				<div id="event" class="carousel slide" data-ride="carousel">
					<ul class="carousel-indicators">
						<li data-target="#event" data-slide-to="0" class="active"></li>
						<li data-target="#event" data-slide-to="1"></li>
						<li data-target="#event" data-slide-to="2"></li>
					</ul>
					
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img src="media/행사1.png" class="w-100 h-100"/>
						</div>
						<div class="carousel-item">
							<img src="media/행사2.png" class="w-100 h-100"/>
						</div>
						<div class="carousel-item">
							<img src="media/행사3.png" class="w-100 h-100"/>
						</div>
					</div>
		
				</div>
			</div>
		</div>
	</div>
</div>

<footer class="container-fluid mt-5" style="height:200px; background-color:#d7d8df;">
	<div class="container pt-3" style="color:#3f3f48; background-color:#d7d8df;">
		<div class=row>
			<div class="col-3">
				<span>이용시간</span><br/>
				<hr style="background-color:#3f3f48;"/>
				<span>평일 9:00 ~ 20:00</span><br/>	
				<span>주말,공휴일 10:00 ~ 18:00</span>
			</div>
			<div class="col-9">
			
			</div>
		</div>	
	</div>
</footer>

<script>
$(document).ready(function(){
	$("#link1, #link2, #link3, #link4, #link5").mouseover(function(){
		$(this).css("color","#527062");
	});
	$("#link1, #link2, #link3, #link4, #link5").mouseout(function(){
		$(this).css("color","black");
	});
});
</script>
</body>
</html>