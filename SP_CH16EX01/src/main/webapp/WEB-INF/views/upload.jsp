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

<title>UPLOAD</title>

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

form {
	text-align : center;
}

h3 {
	background-color : lightgray;
	margin-top : 10px;
	color : white;
}
</style>

</head>
<body>

<div class = "container mt-5 mx-auto">
	<h1>파일 업로드</h1>
	<h3>Single File Upload</h3>
	<form action = "uploadSingle" method = "post" enctype = "multipart/form-data" name = "fileSingle">
		파일 업로드  : <input type = "file" name = "file"/> <!-- 1개의 파일만 업로드 가능 --> 
		업로드한 사람 : <input type = "text" name = "src" placeholder = "업로드한 사람의 이름을 입력하세요"/>&nbsp;&nbsp;
		<input type = "submit" value = "Single File">
	</form>
	<br/>
	<h3>Multi File Upload</h3>	<!-- 배열 형태 -->
	<form action = "uploadMulti" method = "post" enctype = "multipart/form-data" name = "fileMulti">
		파일 업로드 : <input type = "file" name = "file" multiple = "multiple"/> 
													<!-- multiple = "multiple" / multiple 속성
														- 여러 개의 파일 업로드 가능 -->
		업로드 한 사람 : <input type = "text" name = "src" placeholder = "업로드한 사람의 이름을 입력하세요"/>&nbsp;&nbsp;
		<input type = "submit" value = "Multi File">
	</form>
</div>
</body>
</html>