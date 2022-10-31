package com.kim.ex0701;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormEx
 */
@WebServlet("/fex")	// index.html에서 form action을 이걸로 설정했기 때문에 이 서블릿으로 들어온다.
public class FormEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormEx() {
        super();	// 생성자
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet");
		// get 방식으로 브라우저에서 한글 처리 → 톰캣 최신 서버에서는 자동 지원됨
		response.setContentType("text/html; charset = UTF-8");	// !!!!!!!!!!!!! Servlet에 charset = UTF-8 넣어주면 한글도 깨지지 않고 잘 나옴 !!!!!!!!!!!!
		PrintWriter writer = response.getWriter();
		String id = request.getParameter("id");	// 
		// String javax.servlet.ServletRequest.getParameter(String arg0); : html의 form의 입력 컨트롤의 name 속성이 arg0인 것의 입력값을 반환
		writer.println("<html><head></head><body>");
		writer.println("아이디 : " + id);
		writer.println("</body></html>");
		
		writer.close();
		
		// HTML 입력해서 사용하는 방법
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		//post 방식으로 브라우저에서 한글 처리
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println("id는 " + id);
		// checkbox는 복수 개를 선택하므로 request.getParameterValues("속성명")을 사용하고, 이때 반환되는 값은 "문자열" 배열이다
		String[] hobbies = request.getParameterValues("hobby");
		System.out.println("배열" + Arrays.toString(hobbies));
		String major = request.getParameter("major");
		String protocol = request.getParameter("protocol");
		response.setContentType("text/html; charset = UTF-8");

		PrintWriter writer = response.getWriter();
		
		writer.println("<html><head></head><body>");
		writer.println("아이디 : " + id + "<br />");
		writer.println("비밀번호 : " + pw + "<br />");
		writer.println("취미 : " + Arrays.toString(hobbies) + "<br />");
		// Arrays.toString()은 해당 배열(여기선 hobbies)을 문자열로 반환
		writer.println("전공 : " + major + "<br />");
		writer.println("프로토콜 : " + protocol);
		writer.println("</body></html>");
		
		
	}

}
