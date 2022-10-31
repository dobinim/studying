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

<title>Join2.jsp</title>

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
a {
	color : #3f3f48;
	font-size : 20px;
	font-family : segoe;
	
}

table {
	text-align : center;
}

thead {
	background-color : #ececf0;
	font-size : 50px;
}

</style>

</head>
<body>

<div class = "container mt-3 mx-auto">
	<table id = "hometable" class = "table mx-auto">
		<thead>
			<th>Join2 요청 결과 - request방식의 DTO 처리</th>
			<!-- Model 값이 객체일 경우 → '속성이름.객체의 변수명' 으로 EL형식에 맞추어 사용 -->
		</thead>
		<tbody>
			<tr>
				<td>이름 : ${member.name}</td>
			</tr>
			<tr>
				<td>email : ${member.email}</td>
			</tr>
			<tr>
				<td>ID : ${member.id}</td>
			</tr>
			<tr>
				<td>PW : ${member.pw}</td>
			</tr>
			<tr>
				<td><a href = "/ex1301" class = "btn btn-info">홈으로</a></td>
			</tr>
			</tbody>
	</table>
</div>
</body>
</html>