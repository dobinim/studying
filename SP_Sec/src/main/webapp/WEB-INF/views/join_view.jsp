<!-- JSP -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
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
<meta id = "_csrf" name = "csrf" content= "${_csrf.token}" />
<title>join_view</title>
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
<div class = "container mt-5" id = "result"></div>	<!-- 가입결과 창 -->
<br/>
<div class = "container mt-3 mx-auto text-center">
	<h3 class = "text-danger">회원가입</h3>
	<form action = "join" method = "post" id = "frm1" name = "frm1">
		<input type = "hidden" name = "${_csrf.parameterName}" value = "${_csrf.token}" />
		<div class = "form-group">
			<label for = "uId">아이디</label>
			<input type = "email" class = "form-control" name = "pid" placeholder = "E-MAIL 주소를 입력하세요." id = "uId" required />
		</div>
		<div class = "form-group">
			<label for = "uPw">비밀번호</label>
			<input type = "password" class = "form-control" name = "ppw" placeholder = "비밀번호를 입력하세요." id = "uPw" required />
		</div>
		<div class = "form-group">
			<label for = "uAddress">주소</label>
			<input type = "text" class = "form-control" name = "paddress" id = "uAddress" placeholder = "주소를 입력하세요." required />
		</div>
		<div class = "form-group">
			<label for = "uHobby">취미</label>
			<input type = "text" class = "form-control" name = "phobby" id = "uHobby" placeholder = "당신의 취미는 무엇입니까?" required />
		</div>
		<div class = "form-group">
			<label for = "uProfile">자기소개</label>
			<textarea class = "form-control" name = "pprofile" id = "uProfile" placeholder = "자기소개를 입력하세요." rows = "10" required></textarea>
		</div>
		<button type = "submit" class = "btn btn-success">회원가입</button>&nbsp;&nbsp;
		<button type = "reset" class = "btn btn-danger">취소</button>&nbsp;&nbsp;
		<a href = "login_view" class = "btn btn-primary">로그인</a>
	</form>


</div>

<script>
$(document).ready(function(){
	$("#frm1").submit(function(event){
		event.preventDefault(); 
		$.ajax({ // 원래 form()의 기능인 submit을 ajax로 처리
			url : $("#frm1").attr("action"),
			type : $("#frm1").attr("method"),
			data : $("#frm1").serialize(),
			success : function(data) {
				if(data.search("join-success") > -1) {
					$("#result").text("가입을 환영합니다.");
				} else {
					$("#result").text("가입에 실패했습니다. 다시 시도하세요.");
				}
			},
			error : function(){
				$("#result").text("서버에 접속 실패하였습니다.");
			}
			
		});
	});
	
});
</script>

</body>
</html>