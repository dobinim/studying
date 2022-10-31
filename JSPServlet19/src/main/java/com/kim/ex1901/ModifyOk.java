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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ModifyOk
 */
@WebServlet("/ModifyOk")
public class ModifyOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	private Statement statement;
	private String name, id, pw, phone1, phone2, phone3, gender;
	HttpSession httpSession;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyOk() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet");
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		request.setCharacterEncoding("UTF-8");
		actionDo(request, response);
	}

	private void actionDo (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// session ��������
		httpSession = request.getSession();
		id = (String)httpSession.getAttribute("id");
		// modify.jsp�� form���� ������ ���� �Ķ���Ϳ��� �� (���ǿ� �ִ� ��)
		name = request.getParameter("name");
		pw = request.getParameter("pw");
		phone1 = request.getParameter("phone1");
		phone2 = request.getParameter("phone2");
		phone3 = request.getParameter("phone3");
		gender = request.getParameter("gender");
		
		if (pwConfirm()) {
			String query = "UPDATE EX19MEMBER SET name = '" + name + "', phone1 = '" + phone1 + "', phone2 = '" 
					+ phone2 + "', phone3 = '" + phone3 + "', gender = '" + gender + "' where id = '" + id + "'";
			
		
			try { 
				Class.forName("oracle.jdbc.driver.OracleDriver");
				connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
				statement = connection.createStatement();
				int i = statement.executeUpdate(query); // sql�� update���̹Ƿ� excuteUpdate()�̰� ������ 1 ��ȯ
				System.out.println("i : " + i);
				if (i == 1) {
					System.out.println("update success");
					httpSession.setAttribute("name", name); // name�� ���� �����ϹǷ� session ����
					response.sendRedirect("ModifyResult.jsp");
				} else {
					System.out.println("update fail");
					response.sendRedirect("modify.jsp");
					}
			} catch (Exception e) {
			e.printStackTrace();
			} finally {
				try {
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
				
			} else {
				System.out.println("��й�ȣ�� Ʋ�� ������ �Ұ����մϴ�.");
			} 
		}


	private boolean pwConfirm() {
		boolean rs = false;
		String sessionPw = (String)httpSession.getAttribute("pw"); // session�� ����� pw
		System.out.println("sessionPw" + sessionPw);
		System.out.println("pw : " + pw);
		if (sessionPw.equals(pw)) { // session�� pw�� modify.jsp form�� pw ��
			rs = true;
		} else {
			rs = false;
		}
		
		return rs;
	}
}