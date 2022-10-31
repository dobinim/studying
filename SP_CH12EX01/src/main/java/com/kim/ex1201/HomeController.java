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
@Controller	// ��Ʈ�ѷ� ���������� ��Ÿ���� ������̼�
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	// @RequestMapping : ��û������� ������̼�
	// method : ��û ���, value : ��û ��� (value = "/" : �ڵ������� ��û����ľ�) 
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";	// home�� /WEB-INF/views/Home.jsp �� ��Ÿ�� (ViewResolver�� �ڵ����� �� ��η� ��������)
	}
	
	@RequestMapping("/board/view") // ��θ� ó�� �� value, method �ʿ� X �� method�� �ڵ� �Ǻ�
	public String view() {
		return "board/view";	// views/board/view.jsp
	}
	
	@RequestMapping("/board/content")  
	public String content(Model model) {
		// org.springframework.ui.Model Ŭ���� : �����͸� ó���ϴ� �������� Ŭ����
		// servlet�� request ó�� ���
		// �Ķ������ Model ��ü�� DispatcherServlet���� �����Ͽ� ����
		model.addAttribute("id", 30); 
		/* model ��ü�� �Ӽ� �߰� : addAttribute 
		 - ���� Object �� �� ��, �⺻�� ~ ��ü���� ���� OK   
		 	cf. request.setAttribute("�Ӽ���", �Ӽ���) */
		return "board/content";
	}
	
	@RequestMapping("/board/reply")
	public ModelAndView reply() {
		// Model�� View �� ������ Ŭ���� 
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", 20); 
		/* addObject("�Ӽ���", �Ӽ���)
		 - ���� Object�� �� ��, �⺻�� ~ ��ü������ ���� �� OK!  */
		mv.setViewName("board/reply");
		
		return mv;
		
	}
}
