<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
<title>회원가입</title>
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

<div class="container mt-5 p-3" id="result"></div><br/> <!-- 가입결과 표시 -->

<div class="container mt-5 p-3">
	<div class="border border-secondary p-5 m-auto">
		<h3 class="text-center text-info"><i class="far fa-address-card"></i>&nbsp;회원가입</h3>
		<form action="join" method="post" id="frm1" name="frm1">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<div class="form-group">
				<label for="uId"><i class="fa fa-check"></i>&nbsp;아이디</label>
				<input type="email" class="form-control" name="pid" placeholder="Email주소입력" required/>
			</div>
			<div class="form-group">
				<label for="uPw"><i class="fa fa-check"></i>&nbsp;비밀번호</label>
				<input type="password" class="form-control" name="ppw" placeholder="비밀번호입력" required/>
			</div>
			<div class="form-group">
				<label for="uAddress"><i class="fa fa-check"></i>&nbsp;주소</label>
				<input type="text" class="form-control" name="paddress" placeholder="주소입력" required/>
			</div>
			<div class="form-group">
				<label for="uHobby"><i class="fa fa-check"></i>&nbsp;취미</label>
				<input type="text" class="form-control" name="phobby" placeholder="취미입력" required/>
			</div>
			<div class="form-group">
				<label for="uProfile"><i class="fa fa-check"></i>&nbsp;자기소개</label>
				<textarea class="form-group" name="pprofile" id="uProfile" rows="6" placeholder="자기소개를 작성하세요" required style="width:100%"></textarea>
				<button type="submit" class="btn btn-outline-warning" style="width:100%;">회원가입</button>&nbsp;
			<button type="reset" class="btn btn-outline-danger" style="width:100%;">취소</button>&nbsp;
			<a href="login_view" class="btn btn-outline-primary" style="width:100%;">로그인</a>
			</div>
		</form>
	</div>
</div>

<script>
$(document).ready(function(){
	$("#frm1").submit(function(event){
		event.preventDefault(); //form의 원래 submit기능을 막고 ajax로 처리
		$.ajax({
			url : $("#frm1").attr("action"),
			type : $("#frm1").attr("method"),
			data : $("#frm1").serialize(),
			success : function(data){
				if(data.search("join-success") > -1){
					$("#result").text("회원가입 성공");
				}
				else {
					$("#result").text("회원가입 실패 다시 시도하세요");
				}
			},
			error : function(){
				$("#result").text("서버 접속 실패");
			}
		});
	});
	

});
</script>
</body>
</html>