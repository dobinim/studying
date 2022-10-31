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
		// session 가져오기
		httpSession = request.getSession();
		id = (String)httpSession.getAttribute("id");
		// modify.jsp의 form에서 수정한 값을 파라메터에서 얻어냄 (세션에 있던 값)
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
				int i = statement.executeUpdate(query); // sql이 update문이므로 excuteUpdate()이고 성공시 1 반환
				System.out.println("i : " + i);
				if (i == 1) {
					System.out.println("update success");
					httpSession.setAttribute("name", name); // name이 수정 가능하므로 session 변경
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
				System.out.println("비밀번호가 틀려 수정이 불가능합니다.");
			} 
		}


	private boolean pwConfirm() {
		boolean rs = false;
		String sessionPw = (String)httpSession.getAttribute("pw"); // session에 저장된 pw
		System.out.println("sessionPw" + sessionPw);
		System.out.println("pw : " + pw);
		if (sessionPw.equals(pw)) { // session의 pw와 modify.jsp form의 pw 비교
			rs = true;
		} else {
			rs = false;
		}
		
		return rs;
	}
}