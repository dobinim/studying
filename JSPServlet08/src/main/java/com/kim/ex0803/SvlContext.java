package com.kim.ex0803;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SvlContext
 */
@WebServlet("/SCT")
public class SvlContext extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvlContext() {
        super();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet");
		String id = this.getServletContext().getInitParameter("id");
		// getServletContext()메서드는 HttpServlet 클래스의 메서드로, 해당 클래스를 상속한 내 Servlet에서도 사용 가능. ServletContext 객체를 반환한다.
		// ServletContext의 getInitParameter("id")로 web.xml에 설정된 id 파라메터 값을 가져온다.
		String pw = getServletContext().getInitParameter("pw");	
		response.setContentType("text/html;charset = UTF-8");
		
		PrintWriter writer = response.getWriter();
		writer.println("<html><head></head><body>");
		writer.println("아이디 : " + id + "<br/>");
		writer.println("비밀번호 : " + pw + "<br/>");
		writer.println("</body></html>");
		
		writer.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8"); // post방식 시 무조건 request에 한글 처리!
			doGet(request, response);
	}

}
