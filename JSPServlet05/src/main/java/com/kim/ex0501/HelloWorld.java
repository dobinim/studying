package com.kim.ex0501;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/HW")
// @WebServlet()은 어노테이션 (기능이 있는 주석)으로 URL 매핑을 처리
// @WebServlet()을 사용하지 않으려면 web.xml을 따로 열어 URL 매핑을 해주면 됨
public class HelloWorld extends HttpServlet {
	// HttpServlet → GenericServlet (추상클래스) → Servlet (인터페이스)
	// HttpServlet은 Servlet interface의 GenericServlet abstract class를 상속한 녀석임!
	// Servlet을 사용할 때 무조건 HttpServlet을 상속 받아야 됨 (아니면 기능 X!)
	private static final long serialVersionUID = 1L;
    // serialVersionUID : 일련번호로 프로그램 구분을 위한 번호
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() { // 생성자
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */					
    @Override			// 클라이언트에서 요청 시 get 방식이면 servlet에서 실행해야 할 메서드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // HttpServletRequest request : http에서 요청 객체로 tomcat서버에서 생성하여 전달해 준다
		 // HttpServletResponse response : http에서 응답 객체로 tomcat서버에서 생성하여 전달해 준다
		 // response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Helloworld~~~");
		response.setContentType("text/html; charset=UTF-8");
		// 응답(브라우저로 전달) 컨텐츠는 문자로 된 html이고, 해당 문자는 UTF-8 방식을 지정한다
		PrintWriter writer = response.getWriter(); // response의 getWriter()메서드의 반환된 값 = writer
		// PrintWriter = 출력을 처리하는 객체
		// Servlet에서는 html 문서를 PrintWriter 객체의 println() 메서드로 만들어줌 
		writer.println("<html>");
		writer.println("<head>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>Hello, world~~~</h1>");
		writer.println("</body>");
		writer.println("</html>");
		
		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override			// 클라이언트에서 요청 시 post 방식이면 servlet에서 실행해야 할 메서드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
