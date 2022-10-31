<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	String name, id, pw; // session에 저장된 값 

%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<!-- RWD -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- MS -->
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8,IE=EmulateIE9"/> 

<title>LoginResult.jsp 입니다</title>

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
<div class = "container mx-auto mt-5" style = "text-align:center;">
	<h3>로그인에 <span style = "color:green">성공</span>하였습니다.</h3>

<%

	name = (String)session.getAttribute("name");	// session에 저장된 name
	id = (String)session.getAttribute("id");		// session에 저장된 id
	pw = (String)session.getAttribute("pw");		// session에 저장된 pw
			// session.getAttribute() → Object 객체 반환 → so, String으로 형변환
//	if(id == null) {
//		response.sendRedirect("login.html");
//	} 
%>
<%= id %> <br/>
<%= name %> 님 안녕하세요. <br/>
<a href = "modify.jsp">회원 정보 수정</a>
</div>
</body>
</html>