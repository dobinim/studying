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
        super();	// Servlet LifeCycleEx 의 생성자
        System.out.println("construct");
       
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    // Servlet 객체 생성 후 초기화 시 한 번만 실행 (초기화 필요 없을 경우엔 생략 → 상위 HttpServlet의 메서드가 실행됨)
	public void init(ServletConfig config) throws ServletException {
					// ServletConfig : Servlet을 구성하는 객체라는 의미
		System.out.println("initiate!");
	}

	/**
	 * @see Servlet#destroy()
	 */
	// Servlet이 종료될 시 한 번만 실행 (생략하면 상위 HttpServlet의 메서드가 실행)
	public void destroy() {
		System.out.println("destroy!");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	// 맨 처음 요청 시에 호출되는 메서드. doGet / doPost 호출 전 작업 필요 시 (생략하면 상위 HttpServlet의 메서드 실행)
	// 보통은 사용 X 
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		response.getWriter().append("Get방식 접속 : ").append(request.getContextPath());
	}		// 관련 설명 보고 싶을 때 구글에 JEE(Java EE) API JAVADOC 검색하면 됨 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		response.getWriter().append("Post방식 접속 : ").append(request.getContextPath());
	}

	@PostConstruct
	// Servlet 객체 생성 후 실행할 메서드 정의 (메서드는 임의로 만듬)
	private void initPostConstruct() {
		System.out.println("initPostConstruct");
	}
	
	@PreDestroy
	// Servlet 종료 전에 실행되는 메서드 정의 (destroy 후 완전히 Servlet을 제거하기 전에 실행)
	private void destroyPreDestroy() {
		System.out.println("destroyPreDestroy");
	}
}
