<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>  <!-- jsp에서 해당 객체들 쓸때 import 해주기! -->
<%! // 선언
	Connection connection;
	Statement statement;
	ResultSet resultSet;

	String id, pw, name, phone1, phone2, phone3, gender;
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

<title>modify.jsp</title>

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

<!-- session 객체에 로그인 시 저장해둔 id를 가져와서 자기 정보를 DB에서 가져온다 -->
<%
	id = (String)session.getAttribute("id");	// 세션에 저장된 값 가져옴
	String query = "SELECT * FROM EX19MEMBER WHERE ID = '" + id + "'"; 
	// 문자열의 값에는 '' 하는 것 잊지 말기!
	Class.forName("oracle.jdbc.driver.OracleDriver");
	connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
	statement = connection.createStatement();
	resultSet = statement.executeQuery(query);
	while(resultSet.next()) {
		name = resultSet.getString("name");
		pw = resultSet.getString("pw");
		phone1 = resultSet.getString("phone1");
		phone2 = resultSet.getString("phone2");
		phone3 = resultSet.getString("phone3");
		gender = resultSet.getString("gender");
	}
%>

<hr/>
<div class = "container border border-3 border-warning">
<h3 class = "text-center">내 정보 변경</h3>
<form action = "ModifyOk" method = "post">
	이름 : <input type = "text" name = "name" size = "10" value = <%= name %>><br/>
														<!-- jsp의 표현식 태그를 html의 속성값으로 사용 OK  -->
	아이디 : <%= id %><br/> <!-- 아이디는 primary key라 수정X → 보여주기만 함! -->
	비밀번호 : <input type = "password" name = "pw" size = "10" placeholder = "정확한 비밀번호를 입력하세요."><br/>
	전화번호 : 
	<select name = "phone1">
		<option value = "016">016</option>
		<option value = "017">017</option>
		<option value = "018">018</option>
		<option value = "019">019</option>
		<option value = "010" selected>010</option>
	</select> 
	- &nbsp; <input type = "text" name = "phone2" size = "5" value = <%= phone2 %>>&nbsp; 
	- &nbsp; <input type = "text" name = "phone3" size = "5" value = <%= phone3 %>> <br/>
	<%
	if (gender.equals("man")) {
	%>	
	성별구분 : <input type = "radio" name = "gender" value = "man" checked = "checked">남 &nbsp;
	<input type = "radio" name = "gender" value = "woman">여 <br/>
	<%
	} else {
	%>
	성별구분 : <input type = "radio" name = "gender" value = "man">남 &nbsp;
	<input type = "radio" name = "gender" value = "woman" checked = "checked">여 <br/>
	<%
	}
	%>
	<input type = "submit" value = "정보수정">&nbsp;<input type = "reset" value = "취소">
	
</form>
</div>
</body>
</html>