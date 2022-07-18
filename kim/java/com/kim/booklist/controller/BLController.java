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
	// commmand를 처리하는 객체 : 인터페이스를 객체로 선언 → 다형성! 
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
		String viewPage = null; // 이동할 jsp 페이지 객체 선언
		String uri = request.getRequestURI();
		System.out.println("uri : " + uri);	// port 번호 이후의 경로
		String conPath = request.getContextPath();
		System.out.println("context path : " + conPath); // 내 프로젝트 이름(그 경로)
		String com = uri.substring(conPath.length());
		System.out.println("com : " + com);	// uri - 프로젝트 경로
		
		if (com.equals("/booklist.do")) {
			System.out.println("booklist.do 요청입니다.");
			// list.do 요청은 게시판 리스트 창을 구현(My_Board 테이블의 레코드들을 가져와 view인 booklist.jsp 구성)
			command = new BListCommand();
			command.execute(request, response);
			viewPage = "booklist.jsp";
		} else if (com.equals("/rbooklist.do")) {
			System.out.println("rbooklist.do 요청입니다.");
			command = new RBListCommand();
			command.execute(request, response);
			viewPage = "rbooklist.jsp";
		} else if (com.equals("/notice.do")) {
			System.out.println("/notice.do 요청입니다.");
			command2 = new NListCommand();
			command2.execute(request, response);
			viewPage = "notice.jsp";
		} else if (com.equals("/ncontentView.do")) {
			System.out.println("/ncontentView.do 요청입니다.");
			command2 = new NContentCommand();
			command2.execute(request, response);
			viewPage = "nContentForm.jsp";
			
		}
		
		// view 페이지로 페이지 이동
		if (viewPage == null) {	// viewPage가 없다면
			System.out.println("viewPage가 없습니다.");
		} else {				// viewPage가 있다면
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
	}
}
