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
	private ResultSet resultSet; // select ���� �ʿ�

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
		// id�� primary key�̹Ƿ� id�� password�� ��ġ�ϴ� ���� �� �� ����! 
		/* �̰� ���� �ϴ� ��
		  String query = "SELECT * FROM EX19MEMBER WHERE ID = 'id' AND PW = 'pw'
		  �� ���� ����ǥ �������� ū����ǥ ���ָ� ��! */
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			stmt = connection.createStatement();
			resultSet = stmt.executeQuery(query); // sql�� select ���̹Ƿ� executeQuery(query)�� ���. ��ȯ�� ResultSet ��ü
			while (resultSet.next()) {
				flag = true;
				// DB���� resultSet���� ��ȯ�� ���� �÷�
				name = resultSet.getString("name"); // resultSet�� ���ڿ� �÷� ��(varchar2)�� getString("�÷��̸�")���� �ҷ��´�.
				id = resultSet.getString("id");
				pw = resultSet.getString("pw");
			}
			
			if (flag) {
				HttpSession httpSession = request.getSession(); // session�� �α��κ��� �α׾ƿ��� ������ ����
				httpSession.setAttribute("name", name); // session �̸� : name���� ���� name�� ����
				httpSession.setAttribute("id", id);		// session �̸� : id�� ���� id�� ���� 
				httpSession.setAttribute("pw", pw);		// session �̸� : pw�� ���� pw�� ����
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
