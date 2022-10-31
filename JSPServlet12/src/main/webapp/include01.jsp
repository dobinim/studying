<!-- JSP -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<!-- RWD -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- MS -->
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8,IE=EmulateIE9"/> 

<title>JSP Action Tag</title>

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

<div class = "container border border-primary">
	<h3>JSP : INCLUDE 액션 태그입니다.</h3>
	<!-- 얘는 종료태그 없음! empty tag -->
	<jsp:include page = "include02.jsp" flush = "true"/>
	<!-- 지시자의 include는 jsp로 포함되나 액션태그 include는 html로 포함된다.
		 지시자 include의 속성 : file / 액션태그 include의 속성 : page
		 flush = "true" 는 메모리 버퍼를 비우고 삽입 -->
	<jsp:include page = "test.html" flust = "true"/>
	<!-- html 파일도 include 가능 -->
	<h3>다시 원래 페이지인 include01.jsp의 페이지입니다. </h3>
</div>

</body>
</html>