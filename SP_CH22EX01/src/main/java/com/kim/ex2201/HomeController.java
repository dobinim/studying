package com.kim.ex2201;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kim.ex2201.dao.TicketDAO;
import com.kim.ex2201.dto.TicketDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private TicketDAO dao;
	@Autowired // 주입받음
	public void setDao(TicketDAO dao) {
		this.dao = dao; 
	}
	
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
		
		return "buy_ticket"; // buy_ticket.jsp 
	} // home()의 끝
	
	@RequestMapping("/buy_card")
	public String buy_card(TicketDTO ticketDTO, Model model) {
			// 파라메터로 dto 사용 시 자동으로 dto 객체 생성
		System.out.println("buy_card");
		System.out.println("TicketDTO : " + ticketDTO.getConsumerId());
		System.out.println("TicketDTO : " + ticketDTO.getAmount());
		
		dao.buyTicket(ticketDTO);
		model.addAttribute("ticketInfo", ticketDTO);
		return "buy_ticket_end";
	} // buy_card()의 끝
	
	
}
