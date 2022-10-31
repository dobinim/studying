package com.kim.ex0601;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleEx
 */
@WebServlet("/LCE")
public class LifeCycleEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LifeCycleEx() {
        super();	// Servlet LifeCycleEx �� ������
        System.out.println("construct");
       
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    // Servlet ��ü ���� �� �ʱ�ȭ �� �� ���� ���� (�ʱ�ȭ �ʿ� ���� ��쿣 ���� �� ���� HttpServlet�� �޼��尡 �����)
	public void init(ServletConfig config) throws ServletException {
					// ServletConfig : Servlet�� �����ϴ� ��ü��� �ǹ�
		System.out.println("initiate!");
	}

	/**
	 * @see Servlet#destroy()
	 */
	// Servlet�� ����� �� �� ���� ���� (�����ϸ� ���� HttpServlet�� �޼��尡 ����)
	public void destroy() {
		System.out.println("destroy!");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	// �� ó�� ��û �ÿ� ȣ��Ǵ� �޼���. doGet / doPost ȣ�� �� �۾� �ʿ� �� (�����ϸ� ���� HttpServlet�� �޼��� ����)
	// ������ ��� X 
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		response.getWriter().append("Get��� ���� : ").append(request.getContextPath());
	}		// ���� ���� ���� ���� �� ���ۿ� JEE(Java EE) API JAVADOC �˻��ϸ� �� 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		response.getWriter().append("Post��� ���� : ").append(request.getContextPath());
	}

	@PostConstruct
	// Servlet ��ü ���� �� ������ �޼��� ���� (�޼���� ���Ƿ� ����)
	private void initPostConstruct() {
		System.out.println("initPostConstruct");
	}
	
	@PreDestroy
	// Servlet ���� ���� ����Ǵ� �޼��� ���� (destroy �� ������ Servlet�� �����ϱ� ���� ����)
	private void destroyPreDestroy() {
		System.out.println("destroyPreDestroy");
	}
}
