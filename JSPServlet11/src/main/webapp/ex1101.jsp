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

<title>Request : 내부 출력 객체</title>

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

<body>

<div class = "container">
	<h3> 내부 객체 request 객체의 메서드들 </h3>
	<%
	System.out.println("서버 " + request.getServerName() + "<br/>"); // localhost
	System.out.println("포트 번호 : " + request.getServerPort() + "<br/>"); // 8181
	System.out.println("요청 방식 : " + request.getMethod() + "<br/>"); // GET, POST
	// method post일때는 QueryString에 아무것도 뜨지 않지만, method = get일 때에는 경로 나옴
	System.out.println("프로토콜 : " + request.getProtocol() + "<br/>"); // HTTP/1.1
	System.out.println("URL : " + request.getRequestURL() + "<br/>"); // 전체경로 
	System.out.println("URI : " + request.getRequestURI() + "<br/>");    // PORT 번호 이후 경로
	System.out.println("Query : " + request.getQueryString() + "<br/>"); 
				// get 방식 시 ?뒤의 입력 값들
	%>
</div>
</body>
</html>