<!-- JSP -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Arrays" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<!-- RWD -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- MS -->
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8,IE=EmulateIE9"/> 

<title>Front Sample</title>

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
	<h3>입력 parameter 관련 메소드</h3>
	<%!	
		// 전역변수 선언 
		String name, id, pw, major, protocol;
		String[] hobbies;	// checkbox의 복수의 값을 처리하는 변수
	%>
	<%
		request.setCharacterEncoding("UTF-8"); // post방식에서의 한글 인코딩
		name = request.getParameter("name");
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		major = request.getParameter("major");
		protocol = request.getParameter("protocol");
		hobbies = request.getParameterValues("hobby");
		// checkbox의 복수의 값을 처리하는 메소드
	%>
	
	이름 : <%= name %> <br/>
	아이디 : <%= id  %> <br/>
	비밀번호 : <%= pw %> <br/>
	전공 : <%= major %> <br/>
	프로토콜 : <%= protocol %> <br/>
	취미 : <%= Arrays.toString(hobbies) %> <br/>
		
</div>
</body>
</html>