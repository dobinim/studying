<!-- JSP -->
<%@ page language = "java" contentType="text/html; charset=UTF-8"
    pageEncoding ="UTF-8"%>
<%@ page session = "false" %> <!-- 첫 페이지이므로 session 사용 X  -->
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
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<h3>다른 페이지로 링크</h3>
<a href = "board/view">view 페이지로 이동</a><br/> <!-- a는 get방식 요청 -->
<a href = "board/content">content 페이지로 이동</a><br/>
<a href = "board/reply">reply 페이지로 이동</a><br/>
</body>
</html>
