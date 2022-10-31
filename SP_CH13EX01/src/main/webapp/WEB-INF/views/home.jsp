<!-- JSP -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session = "false" %>
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

<title>HOME</title>

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
		<th>Home Page</th>
	</thead>
	<tbody>
		<tr>
			<td><a href = "checkId?id=kim&pw=1234" id = "alink">checkId로 요청</a></td>
		</tr>
		<tr>
			<td><a href = "confirmId?id=kim&pw=1234">confirmId로 요청</a></td>
		</tr>
		<tr>
			<td><a href = "join1?name=kimd&id=kim&pw=1234&email=kim@abcd.com">기존방식으로 DTO처리</a></td>
		</tr>
		<tr>
			<td><a href = "join2?name=kimd&id=kim&pw=1234&email=kim@abcd.com">request 방식으로 DTO처리</a></td>
		</tr>
		<tr>
			<td><a href = "student/10">PathVariable 활용</a></td>
		</tr>
	</tbody>
</table>
	
</div>



</body>
</html>