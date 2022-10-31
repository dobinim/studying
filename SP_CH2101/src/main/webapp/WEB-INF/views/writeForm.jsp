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

<title>WriteForm</title>

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

																	<!-- 글 작성 영역 -->
																		
<div id = "main" class = "container mt-5">
	<h3 id = "ht" class = "text-center">게시판 작성</h3>
	<form action = "write.do" method = "POST">
		<div class = "form-group">
			<label for = "uname">이름 : </label>
			<input type = "text" class = "form-control" id = "uname" placeholder = "작성자 이름" name = "bName" required/>
		</div>
		<div class = "form-group">
			<label for = "title">제목 : </label>
			<input type = "text" class = "form-control" id = "title" placeholder = "제목 작성" name = "bTitle" required/>
		</div>
		<div class = "form-group">
			<label for = "content">내용 : </label>
			<textarea class = "form-control" id = "content" placeholder = "Enter Content" name = "bContent" rows = "10" required>
			</textarea>
		</div>
		<input type = "submit" class = "btn btn-success" value = "작성">&nbsp;&nbsp;
		<a href = "list.do" class = "btn btn-primary">목록 보기</a> 
	</form>
</div>



</body>
</html>