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

<title>book list (도서목록)</title>

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

#mythead {
	background-color : #527062;
	color:white;

}

#booklist_2 {
	color : #3f3f48;
}

#booktitle {
	color : #3f3f48;
}

.page-link {
	color : #3f3f48;
	background-color : #ffffff;

}

.page-link:focus {
	border-color : #527062;
	background-color : #d7d8df;
}

.page-item.active .page-link {
	color : #ececf0;
	background-color : #527062;
	font-weight : bold;
}

</style>

<script>


</script>
</head>
<body>
<div class = "container mx-auto mt-3">
	<h3 id>새로 들어온 책</h3>
	<hr>
	<table class = "table table-hover" id = "booklist">
		<thead id = "mythead">
			<tr>
				<th>No.</th>
				<th>제목</th>
				<th>저자</th>
				<th>출판사</th>
				<th>출판년도</th>
				<th>등록일</th>
			</tr>
		</thead>
		<tbody id = "booklist_2">
			<c:forEach items = "${list}" var = "dto">
				<tr>
					<td>${dto.bId}</td>
					<td>
						<a href = "contentView.do?bId=${dto.bId}" id = "booktitle">${dto.bTitle}</a>
					</td>
					<td>${dto.bName}</td>
					<td>${dto.bPub}</td>
					<td>${dto.bPubYear}</td>
					<td>${dto.bDate}</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan = "6"><a class = "btn btn-secondary" href = "writeForm.do">책 등록</a></td>
			</tr>
		</tfoot>
<!-- 	tbody 에 입력되어 있던 것	
			<tr>
				<td>1</td>
				<td>채식주의자</td>
				<td>한강</td>
				<td>창비</td>
				<td>2007년</td>
				<td>22년 7월 1일</td>
			</tr>
			<tr>
				<td>2</td>
				<td>노랜드</td>
				<td>천선란</td>
				<td>한겨레출판사</td>
				<td>2022년</td>
				<td>22년 7월 1일</td>
			</tr>  -->
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