<!-- JSP -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Enumeration" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<!-- RWD -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- MS -->
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8,IE=EmulateIE9"/> 

<title>Welcome</title>

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

<h3>로그인 성공 시 설정한 세션의 이름과 값</h3>
<%
	Enumeration<String> enumeration = session.getAttributeNames();
	// Enumeration은 반복처리 인터페이스
	// getAttributeNames() : session의 이름들을 Enumeration 형태로 반환
	// Enumeration은 hasMoreElements()와 nextElement() 메서드를 가짐
	while (enumeration.hasMoreElements()) {
		String sName = enumeration.nextElement().toString(); // enumeration의 다음 요소의 값을 문자열로 반환하여 sName에 저장
		System.out.println("세션이름 : " + sName + "<br/>");
		// ↓ session의 이름으로 그 이름에 해당되는 값을 얻어내자.
		String sValue = (String)session.getAttribute(sName);
		// getAttribute(sName)은 Object를 반환 → 문자열로 캐스팅
		if (sValue.equals("abcde")) {
			System.out.println(sValue + "님 안녕하세요." + "<br/>");
		}
	}
%>

<br/>
<a href = "logout.jsp">로그아웃</a>

</body>
</html>