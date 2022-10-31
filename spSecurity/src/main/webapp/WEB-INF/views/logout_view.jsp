<!-- JSP -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "sql" uri = "http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix = "x" uri = "http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<!-- Spring Security Tag Library -->
<%@ taglib prefix = "sec" uri = "http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<!-- RWD -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- MS -->
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8,IE=EmulateIE9"/> 
<meta id="_csrf" name="csrf" content="${_csrf.token}"/> <!-- 페이지 위조 요청 방지를 위한 태그 -->

<title>LogoutView</title>

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
div {
	height : 500px;
}

h3 {
	padding : 20px;
}

#btn1 {
	width : 700px;
	height : 350px;
	font-size : 100px;
}

</style>
</head>
<body>
																		<!-- d-none : 화면에 뜨게하지 마! -->
<div class = "container mt-3 mx-auto text-center border border-3 border-warning d-none">
	<h3 class = "text-info">로그아웃</h3>
		<h5>정말로 로그아웃 하시겠습니까?</h5>
		<form action = "logout" method = "post" id = "frm1" name = "frm1">
			<!-- crsf를 방지하기 위한 헤더 부분을 숨겨서 추가 -->
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<button type = "submit" class = "btn btn-danger" id = "btn1">로그아웃</button>
		</form>
</div>

<!-- 대신 이 화면으로 넘어오면 btn1을 클릭한걸로 간주되어 자동으로 로그아웃 → 로그인화면으로 돌아감! -->
<script>
$(document).ready(function(){
	$("#btn1").trigger("click");
});
</script>
</body>
</html>