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
@WebServlet("/fex")	// index.html���� form action�� �̰ɷ� �����߱� ������ �� �������� ���´�.
public class FormEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormEx() {
        super();	// ������
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet");
		// get ������� ���������� �ѱ� ó�� �� ��Ĺ �ֽ� ���������� �ڵ� ������
		response.setContentType("text/html; charset = UTF-8");	// !!!!!!!!!!!!! Servlet�� charset = UTF-8 �־��ָ� �ѱ۵� ������ �ʰ� �� ���� !!!!!!!!!!!!
		PrintWriter writer = response.getWriter();
		String id = request.getParameter("id");	// 
		// String javax.servlet.ServletRequest.getParameter(String arg0); : html�� form�� �Է� ��Ʈ���� name �Ӽ��� arg0�� ���� �Է°��� ��ȯ
		writer.println("<html><head></head><body>");
		writer.println("���̵� : " + id);
		writer.println("</body></html>");
		
		writer.close();
		
		// HTML �Է��ؼ� ����ϴ� ���
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		//post ������� ���������� �ѱ� ó��
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println("id�� " + id);
		// checkbox�� ���� ���� �����ϹǷ� request.getParameterValues("�Ӽ���")�� ����ϰ�, �̶� ��ȯ�Ǵ� ���� "���ڿ�" �迭�̴�
		String[] hobbies = request.getParameterValues("hobby");
		System.out.println("�迭" + Arrays.toString(hobbies));
		String major = request.getParameter("major");
		String protocol = request.getParameter("protocol");
		response.setContentType("text/html; charset = UTF-8");

		PrintWriter writer = response.getWriter();
		
		writer.println("<html><head></head><body>");
		writer.println("���̵� : " + id + "<br />");
		writer.println("��й�ȣ : " + pw + "<br />");
		writer.println("��� : " + Arrays.toString(hobbies) + "<br />");
		// Arrays.toString()�� �ش� �迭(���⼱ hobbies)�� ���ڿ��� ��ȯ
		writer.println("���� : " + major + "<br />");
		writer.println("�������� : " + protocol);
		writer.println("</body></html>");
		
		
	}

}
