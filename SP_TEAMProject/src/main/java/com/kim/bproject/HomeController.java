package com.kim.bproject;

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

import com.kim.bproject.dao.bContentDao;
import com.kim.bproject.dto.RbContentDto;
import com.kim.bproject.dto.bContentDto;
import com.kim.bproject.dto.nContentDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	// bContentDao 객체 선언
	private bContentDao bdao;
	
	@Autowired
	public void setBdao(bContentDao bdao) {
		this.bdao = bdao;
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
		
		return "home"; // redirect에 requestMapping한거 써서 바로 데이터까지 싹 받아볼수있음! 
	}
	
	@RequestMapping("/bList")
	public String bList(HttpServletRequest request, Model model) {
		ArrayList<bContentDto> list = bdao.bListDao();
		model.addAttribute("list", list);
		return "booklist";
	}
	
	@RequestMapping("/RbList")
	public String RbList(HttpServletRequest request, Model model) {
		ArrayList<RbContentDto> list = bdao.RbListDao();
		model.addAttribute("list", list);
		return "rbooklist";
	}
	
	@RequestMapping("/nList")
	public String nList(HttpServletRequest request, Model model) {
		ArrayList<nContentDto> nlist = ndao.nListDao();
		model.addAttribute("list", list);
		return "notice";
	}
	
}
