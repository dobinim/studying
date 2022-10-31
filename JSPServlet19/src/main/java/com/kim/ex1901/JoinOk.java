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
    // ������� (�Ӽ�) ����
	private String name, id, pw, phone1, phone2, phone3, gender; 
	// join.html���� ���޹��� �����͵� ���� (form���� ���� �����ʹ� ��� String)
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
		// post ����� ���� �ѱ�ó��
		request.setCharacterEncoding("UTF-8");
		// Ŭ���̾�Ʈ(Join.html)�κ��� ��û �� �����͵��� request ��ü�� ��������.
		// getParameter("�Է¿����� name �Ӽ���") : �Է°��� ���ϰ�. ��ȯ�� ���ڿ� 
		// getParameterValues("�Է¿����� name �Ӽ���") : checkboxó�� �Է°��� ������ ��� �迭 �������� ��ȯ (���ڿ��迭)
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
		// SQL������ ���ڿ� ������ '' �ȿ� �־��ش�
		// �̰� ������� ���������! �ƴϸ� ���� ������ �� �Էµ�
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			stmt = connection.createStatement();
			int i = stmt.executeUpdate(query); // sql�� insert���̹Ƿ� executeUpdate(query) ��� �� ��ȯ�� int�� (������ 1, ���д� -1)
			if (i == 1) {
				System.out.println("insert success");
				response.sendRedirect("joinResult.jsp"); // ������ �̵�
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
