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
// web.xml�� �ƴ϶� @WebServlet ������̼��� �̿� �� ��Ŭ������ servlet ����â �̿�
@WebServlet(
		urlPatterns = { "/Servletinit2" }, // url mapping�Ǹ� �⺻������ �ٲ�
		initParams = { 	// name�� value�� ���� �Է�����
				@WebInitParam(name = "id", value = "abcd"), 
				@WebInitParam(name = "pw", value = "1234"), 
			 	@WebInitParam(name = "path", value = "C:/kim")
		})	//�ƿ� Servlet ���� �� URL Mapping�ϴ� �κ� ���� 
			//name�̶� value �� �߰��ϴ� ������ ���� �� ����


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
		writer.println("���̵� : " + id + "<br>");
		writer.println("��й�ȣ : " + pw + "<br>");
		writer.println("��� : " + path + "<br>");
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
