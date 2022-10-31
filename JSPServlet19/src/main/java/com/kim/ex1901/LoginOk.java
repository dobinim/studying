package com.kim.ex1901;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginOk
 */
@WebServlet("/LoginOk")
public class LoginOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private Connection connection;
	private Statement stmt;
	private ResultSet resultSet; // select 때는 필요

	private String id, pw, name;
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public LoginOk() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//	response.getWriter().append("Served at: ").append(request.getContextPath());
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean flag = false;
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		
		String query = "SELECT * FROM EX19MEMBER WHERE ID = '" + id + "' AND PW = '" + pw + "'" ;
		// id가 primary key이므로 id와 password가 일치하는 것은 한 개 뿐임! 
		/* 이거 쉽게 하는 법
		  String query = "SELECT * FROM EX19MEMBER WHERE ID = 'id' AND PW = 'pw'
		  → 작은 따옴표 기준으로 큰따옴표 써주면 됨! */
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			stmt = connection.createStatement();
			resultSet = stmt.executeQuery(query); // sql이 select 문이므로 executeQuery(query)를 사용. 반환은 ResultSet 객체
			while (resultSet.next()) {
				flag = true;
				// DB에서 resultSet으로 반환된 값의 컬럼
				name = resultSet.getString("name"); // resultSet의 문자열 컬럼 값(varchar2)은 getString("컬럼이름")으로 불러온다.
				id = resultSet.getString("id");
				pw = resultSet.getString("pw");
			}
			
			if (flag) {
				HttpSession httpSession = request.getSession(); // session은 로그인부터 로그아웃할 때까지 존재
				httpSession.setAttribute("name", name); // session 이름 : name으로 변수 name값 저장
				httpSession.setAttribute("id", id);		// session 이름 : id로 변수 id값 저장 
				httpSession.setAttribute("pw", pw);		// session 이름 : pw로 변수 pw값 저장
				response.sendRedirect("loginResult.jsp");				
			} else {
				response.sendRedirect("login.html");
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (stmt != null)
					stmt.close();
				if (connection != null)
					connection.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
