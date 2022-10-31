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
// @WebServlet()�� ������̼� (����� �ִ� �ּ�)���� URL ������ ó��
// @WebServlet()�� ������� �������� web.xml�� ���� ���� URL ������ ���ָ� ��
public class HelloWorld extends HttpServlet {
	// HttpServlet �� GenericServlet (�߻�Ŭ����) �� Servlet (�������̽�)
	// HttpServlet�� Servlet interface�� GenericServlet abstract class�� ����� �༮��!
	// Servlet�� ����� �� ������ HttpServlet�� ��� �޾ƾ� �� (�ƴϸ� ��� X!)
	private static final long serialVersionUID = 1L;
    // serialVersionUID : �Ϸù�ȣ�� ���α׷� ������ ���� ��ȣ
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() { // ������
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */					
    @Override			// Ŭ���̾�Ʈ���� ��û �� get ����̸� servlet���� �����ؾ� �� �޼���
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // HttpServletRequest request : http���� ��û ��ü�� tomcat�������� �����Ͽ� ������ �ش�
		 // HttpServletResponse response : http���� ���� ��ü�� tomcat�������� �����Ͽ� ������ �ش�
		 // response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Helloworld~~~");
		response.setContentType("text/html; charset=UTF-8");
		// ����(�������� ����) �������� ���ڷ� �� html�̰�, �ش� ���ڴ� UTF-8 ����� �����Ѵ�
		PrintWriter writer = response.getWriter(); // response�� getWriter()�޼����� ��ȯ�� �� = writer
		// PrintWriter = ����� ó���ϴ� ��ü
		// Servlet������ html ������ PrintWriter ��ü�� println() �޼���� ������� 
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
	@Override			// Ŭ���̾�Ʈ���� ��û �� post ����̸� servlet���� �����ؾ� �� �޼���
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
