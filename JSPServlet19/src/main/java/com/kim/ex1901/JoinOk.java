package com.kim.ex1901;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinOk
 */
@WebServlet("/JoinOk")
public class JoinOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
    // 멤버변수 (속성) 정의
	private String name, id, pw, phone1, phone2, phone3, gender; 
	// join.html에서 전달받은 데이터들 정의 (form으로 받은 데이터는 모두 String)
	private Connection connection;
	private Statement stmt;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinOk() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// 	response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet");
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	doGet(request, response);
		System.out.println("doPost");
		actionDo(request, response);
	}

	private void actionDo (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post 방식을 위해 한글처리
		request.setCharacterEncoding("UTF-8");
		// 클라이언트(Join.html)로부터 요청 시 데이터들은 request 객체에 속해있음.
		// getParameter("입력원소의 name 속성값") : 입력값이 단일값. 반환은 문자열 
		// getParameterValues("입력원소의 name 속성값") : checkbox처럼 입력값이 복수일 경우 배열 형식으로 반환 (문자열배열)
		name = request.getParameter("name");
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		phone1 = request.getParameter("phone1");
		phone2 = request.getParameter("phone2");
		phone3 = request.getParameter("phone3");
		gender = request.getParameter("gender");
		
		//String query = "INSERT INTO EX19MEMBER VALUES(id, pw, name, phone1, phone2, phone3, gender)";
		String query = "INSERT INTO EX19MEMBER VALUES" 
		+ "('" + id + "', '" + pw + "', '" + name + "', '" + phone1 + "', '" + phone2 + "', '" + phone3 + "', '" + gender + "')";
		// SQL에서는 문자열 값들은 '' 안에 넣어준다
		// 이거 순서대로 적어줘야함! 아니면 각자 엉뚱한 값 입력됨
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			stmt = connection.createStatement();
			int i = stmt.executeUpdate(query); // sql이 insert문이므로 executeUpdate(query) 사용 시 반환은 int값 (성공은 1, 실패는 -1)
			if (i == 1) {
				System.out.println("insert success");
				response.sendRedirect("joinResult.jsp"); // 페이지 이동
			} else {
				System.out.println("insert fail");
				// response.sendRedirect("join.html");
			}
		} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if(stmt != null) 
				stmt.close();
			if (connection != null)
				connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		}
	}
	
}
