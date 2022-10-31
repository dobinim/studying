<!-- JSP -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Enumeration" %>
<%@ page import = "com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import = "com.oreilly.servlet.MultipartRequest" %>
<%
	String path = request.getRealPath("fileFolder");
						// .getRealPath() : fileFolder의 실제 경로(tomcat 내)를 반환 → path에 저장
	// 내 경우 C:\KIMKIM\apache-tomcat-9.0.63\wtpwebapps\JSPServlet22\fileFolder 임 (학원 컴 기준)
	int size = 1024 * 1024 * 10; // 10M
	String file = "";
	String oriFile = "";
	try {	// form 에서 multipart/form-data로 넘김 → 여기서 MultipartRequest 객체로 받음!!! ★★
		MultipartRequest multi = new MultipartRequest(request, path, size, "UTF-8", new DefaultFileRenamePolicy());
		Enumeration files = multi.getFileNames();
		// enumeration = 반복할 수 있는 형태의 객체 
		String str = (String)files.nextElement();
									// 다음 원소
		file = multi.getFilesystemName(str);
		oriFile = multi.getOriginalFileName(str);
	} catch (Exception e) {
		e.getMessage();
	}
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

<title>fileFormOk</title>

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

<div class = "container mx-auto mt-300px border border-3 border-warning" style = "text-align : center;">
<h3 class = "text-center"> 업로드가 <span style = "color:blue">성공적으로</span> 이루어졌습니다. </h3>
<a href = "fileFolder/zoom.txt" download>다운로드</a>
</div>
</body>
</html>