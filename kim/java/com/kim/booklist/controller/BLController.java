package com.kim.booklist.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kim.booklist.command.BListCommand;
import com.kim.booklist.command.BooklistCommand;
import com.kim.booklist.command.NContentCommand;
import com.kim.booklist.command.NListCommand;
import com.kim.booklist.command.NoticeCommand;
import com.kim.booklist.command.RBListCommand;

/**
 * Servlet implementation class BLController
 */

@WebServlet("*.do")
public class BLController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// commmand�� ó���ϴ� ��ü : �������̽��� ��ü�� ���� �� ������! 
	BooklistCommand command;
	NoticeCommand command2;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BLController() {
        super();
        
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo");
		String viewPage = null; // �̵��� jsp ������ ��ü ����
		String uri = request.getRequestURI();
		System.out.println("uri : " + uri);	// port ��ȣ ������ ���
		String conPath = request.getContextPath();
		System.out.println("context path : " + conPath); // �� ������Ʈ �̸�(�� ���)
		String com = uri.substring(conPath.length());
		System.out.println("com : " + com);	// uri - ������Ʈ ���
		
		if (com.equals("/booklist.do")) {
			System.out.println("booklist.do ��û�Դϴ�.");
			// list.do ��û�� �Խ��� ����Ʈ â�� ����(My_Board ���̺��� ���ڵ���� ������ view�� booklist.jsp ����)
			command = new BListCommand();
			command.execute(request, response);
			viewPage = "booklist.jsp";
		} else if (com.equals("/rbooklist.do")) {
			System.out.println("rbooklist.do ��û�Դϴ�.");
			command = new RBListCommand();
			command.execute(request, response);
			viewPage = "rbooklist.jsp";
		} else if (com.equals("/notice.do")) {
			System.out.println("/notice.do ��û�Դϴ�.");
			command2 = new NListCommand();
			command2.execute(request, response);
			viewPage = "notice.jsp";
		} else if (com.equals("/ncontentView.do")) {
			System.out.println("/ncontentView.do ��û�Դϴ�.");
			command2 = new NContentCommand();
			command2.execute(request, response);
			viewPage = "nContentForm.jsp";
			
		}
		
		// view �������� ������ �̵�
		if (viewPage == null) {	// viewPage�� ���ٸ�
			System.out.println("viewPage�� �����ϴ�.");
		} else {				// viewPage�� �ִٸ�
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
	}
}
