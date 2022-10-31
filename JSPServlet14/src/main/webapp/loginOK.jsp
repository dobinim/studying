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

<title>loginOK</title>

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

<!-- jsp에서는 form이나 param으로 오는 것은 getParameter로 값을 얻어 사용한다 -->

<!-- 선언 : 전역변수 -->
<%!
	String id, pw;
%>

<!-- scriptlet에서 사용 -->
<%
	id = request.getParameter("id"); // 괄호 속 id는 input의 name 속성 값
	pw = request.getParameter("pw"); // 괄호 속 pw는 input의 name 속성 값
	
	if(id.equals("abcde") && pw.equals("12345")) { // 로그인 성공 처리
		// .equals() = 문자열 비교
		// session 객체는 내부 객체로 request 발생 시 자동 생성
		// 따라서 session 객체에 속성 부여
		session.setAttribute("id", id); // session 객체에 "id" 이름으로 입력받은 id값 설정
		// session은 HttpSession 클래스의 객체임 
		response.sendRedirect("welcome.jsp"); // 성공하면 welcome.jsp로 보냄
	} else {
		response.sendRedirect("login.html");  // 실패하면 다시 login.html로 돌아옴
	}
%>
</body>
</html>