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

<!-- 페이지 위조 요청을 방지하기 위한 태그 -->
<meta id = "_csrf" name = "_csrf" content=${_csrf.token}" /> 

<title>LOGIN_VIEW</title>

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

<div class = "container mt-5 mx-auto text-center">
	<h3 class = "text-info">로그인</h3>
	<div id = "div1" class = "text-success"></div>

	<!-- 로그인 관련 메세지를 서버에서 받아서 작성 -->
	<form id = "frm1" name = "frm1" method = "post" action = "login">
		<!-- security에서 action을 login으로 기본 설정할 경우 controller로 요청 X 
			 → security의 login (login-processing-url)에 요청이 간다.  
			 - csrf 를 방지하기 위한 헤더 부분을 숨겨서 추가 (위의 meta 태그) -->
		<input type = "hidden" name = "${_csrf.parameterName}" value = "${_csrf.token}" />
		<div class = "form-group">
			<label for = "uId">아이디</label>
			<input type = "email" class = "form-control" name = "pid" placeholder="E-Mail 주소 입력" id = "uId" required />
		</div>
		<div class = "form-group">
		
			<label for = "uPw">비밀번호</label>
			<input type = "password" class = "form-control" name = "ppw" id = "uPw" placeholder = "비밀번호 입력" required />
		</div>
		<!-- 로그아웃하지 않고 접속 단절해도 일정 시간 동안 로그인이 유효하게 하기 -->
		<div class = "form-group form-check">
			<input type = "checkbox" class ="form-check-input" id = "rememberMe" name = "remember-me" checked>
			<label class = "form-check-label" for = "rememberMe" aria-describedby="rememberMeHelp">remember-me</label><br/>
															<!-- aria-describedby : 스크린리더가 읽어줄때 출력되는 내용 -->
			<button type = "submit" class = "btn btn-success">로그인</button>&nbsp;&nbsp;
			<a href = "join_view" class = "btn btn-danger">회원가입</a>
		</div>
	</form>

<script>
$(document).ready(function(){
	// c:choose → JSTL의 태그
	// 서버의 것을 가져올 때 유일하게 JSTL 을 사용해 클라이언트에서 사용할 수 있다!
	<c:choose>
		<c:when test = "${not empty log}">
			$("#div1").text("welcome!");
		</c:when>
		<c:when test = "${not empty logout}">
			$("#div1").text("로그아웃 되었습니다.");
		</c:when>
		<c:when test = "${not empty error}">	// 로그인 실패 시
			$("#div1").text("로그인에 실패하였습니다.");
		</c:when>
		<c:otherwise>
			$("#div1").text("WELCOME");	// 로그인 성공 시
		</c:otherwise>
	</c:choose>
	
});

</script>
</div>
</body>
</html> 