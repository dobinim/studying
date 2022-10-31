package com.mkm.ex2201;

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

import com.mkm.ex2201.dao.TicketDao;
import com.mkm.ex2201.dao.tpTicketDao;
import com.mkm.ex2201.dao.trTicketDao;
import com.mkm.ex2201.dto.TicketDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	//Ʈ������X
	private TicketDao dao; //set�޼��带 �̿��� Autowired ����
	@Autowired //servlet-context.xml�� TicketDao bean�� ����
	public void setDao(TicketDao dao) {
		this.dao = dao;
	}
	
	//Ʈ������(Manager)
	private trTicketDao trdao; //set�޼��带 �̿��� Autowired ����
	@Autowired
	public void setTrdao(trTicketDao trdao) {
		this.trdao = trdao;
	}
	
	//Ʈ������(Template)
	private tpTicketDao tpdao; //set�޼��带 �̿��� Autowired ����
	@Autowired
	public void setTpdao(tpTicketDao tpdao) {
		this.tpdao = tpdao;
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
		
		return "buy_ticket";
	}
	
	//Ʈ������ ������
	@RequestMapping("/buy_card")
	public String buy_card(TicketDto ticketDto, Model model) {
		
		System.out.println("buy_card");
		
		//�Ķ���ͷ� dto ��� �� �ڵ� dto ��ü ����
		System.out.println("ticketDto : " + ticketDto.getConsumerId());
		System.out.println("ticketDto : " + ticketDto.getAmount());
		
		dao.buyTicket(ticketDto);
		model.addAttribute("ticketInfo", ticketDto); //end���������� input�� �Է��� ���� �ҷ���
		
		return "buy_ticket_end";
	}
	
	//Ʈ������ ����
	@RequestMapping("/tr_buy_card")
	public String tr_buy_card(TicketDto ticketDto, Model model) {
		
		System.out.println("tr_buy_card");
		
		System.out.println("ticketDto : " + ticketDto.getConsumerId());
		System.out.println("ticketDto : " + ticketDto.getAmount());
		
		trdao.trbuyTicket(ticketDto);
		model.addAttribute("ticketInfo", ticketDto);
		
		return "buy_ticket_end";
	}
	
	//Ʈ������(Template) ����
		@RequestMapping("/tp_buy_card")
		public String tp_buy_card(TicketDto ticketDto, Model model) {
			
			System.out.println("tp_buy_card");
			
			System.out.println("ticketDto : " + ticketDto.getConsumerId());
			System.out.println("ticketDto : " + ticketDto.getAmount());
			
			tpdao.tpbuyTicket(ticketDto);
			model.addAttribute("ticketInfo", ticketDto);
			
			return "buy_ticket_end";
		}
	
}
