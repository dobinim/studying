<!-- JSP -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id = "student" class = "com.kim.ex1601.Student" scope = "page"/>
<!-- id 속성은 jsp 내의 객체 이름(bean이름)
	 class 속성은 사용할 bean 클래스
	 scope는 사용 범위  -->
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<!-- RWD -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- MS -->
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8,IE=EmulateIE9"/> 

<title>JSP BEAN 사용</title>

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
<div class = "container mx-auto mt-5 border border-warning">
	<h3 style = "text-align:center;color:orange">Bean 관련 액션태그 사용</h3>
	<jsp:setProperty name = "student" property = "name" value = "홍길동"/>
	<!-- jsp:setProperty 액션 태그 : 값을 그 위치에 설정 (setter 메서드)
		 - name 속성 : id로 지정된 빈 이름
		 - property 속성 : 값을 설정해 줄 속성(멤버변수)
		 - value : 설정해 줄 값 → 이때, 모두 "문자열" 처리!! ★★★
		 - 설정방식은 실제로 Student 클래스 안, 해당 멤버 변수의 set 메서드를 호출 
		 
		  	public void setName(String name) {	
			this.name = name;
			}
									                          	 -->
	<jsp:setProperty name = "student" property = "age" value = "13"/>	<!-- 숫자도 문자열로 넣어! -->
	<jsp:setProperty name = "student" property = "grade" value = "6"/>
	<jsp:setProperty name = "student" property = "studentNum" value = "7"/>
	
	<!-- jsp:getProperty 액션 태그 : 반환받은 값을 그 위치에 출력 (getter 메서드) 
		 - name 속성 : id로 설정된 bean 이름
		 - property 속성 : 설정된 값을 가진 속성(멤버변수)
		 - 실제로는 Student 클래스 안, 해당 멤버 변수의 get 메서드를 호출 
		 
		 	public String getName() {
			return name;
			}
																 -->
	
	<h3>이름 : <jsp:getProperty property="name" name="student"/><br/>
		나이 : <jsp:getProperty property="age" name="student"/><br/>
		학년 : <jsp:getProperty property="grade" name="student"/><br/>
		번호 : <jsp:getProperty property="studentNum" name="student"/><br/></h3>
</div>
</body>
</html>