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

<title>DOWNLOAD</title>

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
table {
	text-align : center;
}

thead {
	background-color : #527062;
	color : white;
}
 
h4 {
	color : #3f3f48;
}

</style>
</head>
<body>
<div class = "container mt-5 mx-auto text-center">
	<table class = "table">
		<thead>
			<tr>
				<th><h3>서버 이용 DOWNLOAD</h3></th>
			</tr>
		<tbody>
			<tr><td><h4>작성자  : ${author}</h4> <!-- model 객체니까 EL로 불러올 수 있음 --> </td></tr>
			<tr><td><h4>파일크기 : ${fileSize}</h4></td></tr>
			<tr><td><h4>파일이름 : ${fileName}</h4></td></tr>
			<tr><td><h3>서버를 이용한 다운로드</h3>
			<h4>
				<a href = "download?file_name=${fileName}">${fileName} 다운로드</a>
				<!-- get방식으로 해당 파일이름을 가진 녀석을 다운로드해라 -->
			</h4></td></tr>
			<!-- 크롬과 edge 모두 정상 동작되므로 html5 download 활용 -->
			<tr><td><h3>HTML5를 이용한 다운로드</h3>
			<h4>
				<a href = "upimage/${fileName}" download>	 <!-- servlet에 resource태그로 경로 맵핑을 해두었기때문에 걍 요렇게 써줘도 됨!! -->
					<img src = "upimage/${fileName}" style = "width:100px;height:100px;">
				</a>
			</h4></td></tr>
	</table>
</div>
</body>
</html>