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
<html lang="ko">
<head>
<meta charset="UTF-8">
<!-- RWD -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- MS -->
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8,IE=EmulateIE9"/> 

<title>LIST</title>

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

</head>
<body>
																		<!-- 게시판 영역 -->
<div id = "main" class = "container mt-5">
	<h3 id = "ht" class = "text-center text-danger">게시판</h3>
	<table class = "table table-bordered table-hover">
		<thead class = "thead-dark">
			<tr>
				<th>번호</th> <!-- 게시물 번호 -->
				<th>작성자</th> 
				<th>제목</th>	
				<th>날짜</th> 
				<th>조회수</th> 
			</tr>	
		</thead>
		<tbody> <!-- 게시판의 리스트 부분 → tr을 반복하여 출력 -->
		<!-- EL에서는 request 객체의 속성(attribute)를 바로 사용 가능 -->
			<c:forEach items = "${list}" var = "dto">
							<!-- 실제로는 ArrayList<BDto>의 객체들 / BListCommand 참고
							- forEach 반복문의 items : 콜렉션(배열, list, set 등…)
							- var = items에 들어있는 원소를 나타내는 변수 이름 (지정해주는 것)	-->
				<tr>
					<td>${dto.bId}</td> <!-- 번호 : bId → dto의 객체인 bId니까 이렇게 쳐줌 -->
					<td>${dto.bName}</td>
					<td>
						<!-- 제목에 댓글 갯수를 --로 표시하고 제목 클릭 시 이 게시판 라인의
						게시판 번호를 이용해 DB에서 해당 게시판 번호의 내용을 가져오도록 처리 -->
						<c:forEach begin = "1" end = "${dto.bIndent}"> - </c:forEach>
						<a href = "contentView.do?bId=${dto.bId}">${dto.bTitle}</a>
																<!-- 제목을 따라 내용 보기 -->
					</td>
					<td>${dto.bDate}</td>
					<td>${dto.bHit}</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot class = "table-secondary">
			<tr>
				<td colspan = "5"><a class = "btn btn-primary" href = "writeForm">글작성</a></td>
					<!-- colspan : 하나로 합쳐라 -->
		</tfoot>
	</table>
</div>
</body>
</html>