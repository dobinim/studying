<!-- JSP -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- Java.sql 패키지에 있는 필요한 클래스를 import --%>
<%@ page import = "java.sql.DriverManager" %>
<%@ page import = "java.sql.Connection" %>
<%@ page import = "java.sql.Statement" %>
<%@ page import = "java.sql.ResultSet" %>
<%!
	Connection connection;
	Statement statement;
	ResultSet resultSet;
	// oracle driver 경로
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String uid = "scott";		// 자기 DB의 id
	String upw = "tiger";		// 자기 DB의 password
	String query = "select * from member"; // 이때 SQL문은 대문자로 해도 OK 
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

<title>ㅇㅋ</title>

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

<h3>JDBC를 이용한 데이터베이스 처리</h3>
<%
	// 예외처리구문
	try {
		Class.forName(driver);	// oracle jdbc의 driver로 로드 → DriverManager클래스 사용 가능
		connection = DriverManager.getConnection(url, uid, upw);
		// DBMS와 연결하는 connection 객체 → DriverManger 클래스를 이용해 url, uid, upw 를 가져와 연결
		statement = connection.createStatement();
		// statement → sql문을 실행하는 메서드를 가진 객체
		resultSet = statement.executeQuery(query);
		// query → sql 문장 : 여기서는 select * from member;
		// executeQuery(query) → select 문을 수행하는 메서드로 ResultSet 객체를 반환 (다수의 레코드를 가짐)
		// executeUpdate(query) → select 이외의 DML (데이터 조작 명령 / 예) insert, update, delete 등)에서 사용하며 정수 값을 반환
		while (resultSet.next()) {
					// .next() → 다음 원소가 있냐? 즉, 안에 내용물이 남아 있냐? > 있으면 true, 없으면 false
			String id = resultSet.getString("id");
			// DB의 컬럼이 문자열형(varchar2)이면 getString으로 값을 알아낸다. → .getString("DB의 컬럼명");
			// 만일 컬럼이 숫자라면 그 타입에 따라 정수일 때 getInt("컬럼명"), 실수일 때 getFloat("컬럼명")
			String pw = resultSet.getString("pw");
			String name = resultSet.getString("name");
			String phone = resultSet.getString("phone");
			System.out.println("아이디 : " + id + ", 비밀번호 : " + pw + ", 이름 : " + name + ", 전화번호 : " + phone + "<br/>");
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if (resultSet != null) 
				resultSet.close();
			if (statement != null)
				statement.close();
			if (connection != null)
				connection.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
%>
</body>
</html>