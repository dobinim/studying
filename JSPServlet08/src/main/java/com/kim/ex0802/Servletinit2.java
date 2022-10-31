package com.kim.ex0802;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servletinit2
 */
// web.xml이 아니라 @WebServlet 어노테이션을 이용 → 이클립스의 servlet 생성창 이용
@WebServlet(
		urlPatterns = { "/Servletinit2" }, // url mapping되면 기본값에서 바뀜
		initParams = { 	// name과 value를 직접 입력해줌
				@WebInitParam(name = "id", value = "abcd"), 
				@WebInitParam(name = "pw", value = "1234"), 
			 	@WebInitParam(name = "path", value = "C:/kim")
		})	//아예 Servlet 만들 때 URL Mapping하는 부분 위에 
			//name이랑 value 값 추가하는 곳에서 넣을 수 있음


public class Servletinit2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servletinit2() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet");
		String id = getInitParameter("id");
		String pw = getInitParameter("pw");
		String path = getInitParameter("path");
		
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter writer = response.getWriter();
		
		writer.println("<html><head></head><body>");
		writer.println("아이디 : " + id + "<br>");
		writer.println("비밀번호 : " + pw + "<br>");
		writer.println("경로 : " + path + "<br>");
		writer.println("</body></html>");
		
		writer.close();

				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
