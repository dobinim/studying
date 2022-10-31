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
<title>Login View</title>
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

<div class="container mt-5 p-3">
	<div class="border border-secondary p-5 m-auto" style="width:800px;">
		<h3 class="text-center text-info"><i class="fa fa-user"></i>&nbsp;로그인</h3>
		<hr/>
		
		<div id="div1" class="text-success text-center"></div>
	
		<!-- 로그인 관련 메세지를 서버에서 받아 작성 -->
		<form id="frm1" name="frm1" method="post" action="login">
		<!-- security에서 action 기본설정을 login으로 할 경우 controller로 요청하는 것이 아닌
			 security의 login(login-prosessing-url)으로 요청한다 -->
		
			<!-- crsf를 방지하기 위한 헤더 부분을 숨겨서 추가 -->
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		
			<div class="form-group">
				<label for="uId">아이디</label>
				<input type="email" class="form-control" name="pid" placeholder="EMail주소입력" id="uId" required/>
			</div>
			<div class="form-group">
				<label for="uPw">비밀번호</label>
				<input type="password" class="form-control" name="ppw" placeholder="비밀번호입력" id="uPw" required/>
			</div>
			
			<!-- 로그아웃 안 하고 접속 단절 후 일정시간 로그인 없이 재접속 -->
			<div class="form-group form-check float-right">
				<input type="checkbox" class="form-check-input" id="rememberMe" name="remember-me" checked/>
				<label class="form-check-label" for="rememberMe" aria-describedby="rememberMeHelp">remember-me</label>
				<!-- aria-describedby는 스크린리더에서 설명할 내용 -->
			</div>
			<button type="submit" class="btn btn-outline-primary" style="width:100%;">로그인</button>&nbsp;
			<a href="join_view" class="btn btn-outline-warning" style="width:100%;">회원가입</a>
		</form>
	</div>
</div>

<script>
$(document).ready(function(){ //jstl은 js에 사용 가능
	<c:choose>
		<c:when test="${not empty log}">
			$("#div1").text("Welcome!");
		</c:when>
		<c:when test="${not empty logout}">
			$("#div1").text("로그아웃 성공");
		</c:when>
		<c:when test="${not empty error}">
			$("#div1").text("로그인 실패");
		</c:when>
		<c:otherwise>
			$("#div1").text("Welcome!");
		</c:otherwise>
	</c:choose>
});
</script>
</body>
</html>