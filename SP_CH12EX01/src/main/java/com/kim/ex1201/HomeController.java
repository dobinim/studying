package com.kim.ex1201;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller	// 컨트롤러 페이지임을 나타내는 어노테이션
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	// @RequestMapping : 요청경로지정 어노테이션
	// method : 요청 방식, value : 요청 경로 (value = "/" : 자동적으로 요청경로파악) 
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";	// home은 /WEB-INF/views/Home.jsp 를 나타냄 (ViewResolver가 자동으로 이 경로로 조합해줌)
	}
	
	@RequestMapping("/board/view") // 경로만 처리 시 value, method 필요 X → method는 자동 판별
	public String view() {
		return "board/view";	// views/board/view.jsp
	}
	
	@RequestMapping("/board/content")  
	public String content(Model model) {
		// org.springframework.ui.Model 클래스 : 데이터를 처리하는 스프링의 클래스
		// servlet의 request 처럼 사용
		// 파라메터의 Model 객체는 DispatcherServlet에서 생성하여 전달
		model.addAttribute("id", 30); 
		/* model 객체에 속성 추가 : addAttribute 
		 - 값은 Object 형 → 즉, 기본형 ~ 객체까지 전부 OK   
		 	cf. request.setAttribute("속성명", 속성값) */
		return "board/content";
	}
	
	@RequestMapping("/board/reply")
	public ModelAndView reply() {
		// Model과 View 를 결합한 클래스 
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", 20); 
		/* addObject("속성명", 속성값)
		 - 값은 Object형 → 즉, 기본형 ~ 객체까지도 전부 다 OK!  */
		mv.setViewName("board/reply");
		
		return mv;
		
	}
}
