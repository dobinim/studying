package com.kim.batis01;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kim.batis01.dao.ContentDao;
import com.kim.batis01.dao.TicketTransaction;
import com.kim.batis01.dto.ContentDto;
import com.kim.batis01.dto.TicketDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	//ContentDao 객체 선언
	private ContentDao dao;
	
	@Autowired
	public void setDao(ContentDao dao) {
		this.dao = dao;
	}
	
	@Autowired 
	private TicketTransaction tdao;
	// Bean 클래스가 property가 없는 경우 그냥 필드 방식으로 주입.
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		// return "writeForm";
		return "redirect:list";
	} // home의 끝
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		dao.writeDao(request.getParameter("mWriter"), request.getParameter("mContent"));
		//return "redirect:list";
		return "redirect:list";
	}	
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		ArrayList<ContentDto> list = dao.listDao();
		model.addAttribute("list", list);
		return "list"; // 여기다 .jsp 쓰면 X !
	}
	
	@RequestMapping("/writeForm")
	public String writeForm() {
		return "writeForm";
	}
	
	@RequestMapping("/view")
	public String view(HttpServletRequest request, Model model) {
		ContentDto dto = dao.viewDao(request.getParameter("mId"));
		model.addAttribute("contentview", dto);
		return "contentView";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) { 
		dao.deleteDao(request.getParameter("mId"));
		return "redirect:list";
	}
	
	@RequestMapping("/buyForm")
	public String buyForm() {
		return "buyTicket";
	}
	
	@RequestMapping("/buyCard")
	public String buyCard(TicketDto ticketDto, HttpServletRequest request, Model model) {
		System.out.println("buyCard");
		System.out.println("ConsumerId : " + ticketDto.getConsumerId());
		System.out.println("Amount : " + ticketDto.getAmount());
		try { tdao.transAction(dao, ticketDto);
		} catch (Exception e) {
			e.getMessage();
		}
		
		model.addAttribute("ticketInfo", ticketDto);
		return "buyTicketResult";
	}
	
	
}	// 클래스의 끝
