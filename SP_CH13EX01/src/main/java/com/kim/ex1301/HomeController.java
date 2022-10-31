package com.kim.ex1301;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kim.ex1301.DTO.Member;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
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
		
		return "home";	// home.jsp임 (jsp 생략) → 
	} // home()의 끝
	
	@RequestMapping("/checkId")	// ""안에 무조건 / 있어야 함!
	public String checkId(@RequestParam("id") String id, @RequestParam("pw") int pw, Model model) {
						// "id"의 값을 id객체에 바로 입력
		/* @RequestParam 
		 - request 객체의 파라메터 (즉, query문이나 form의 원소이름인 name 속성값)
		 - Servlet에서는 파라메터의 값을 문자열로 처리 → @RequestParam은 자동 형변환해줌! */
		model.addAttribute("identify", id);
		model.addAttribute("password", pw);
		return "checkId"; // checkId.jsp로 보낸다
	}	// checkId()의 끝
	
	@RequestMapping("/confirmId")
	public String confirmId(HttpServletRequest request, Model model) {
							// HttpServletRequest 객체를 이용해 요청을 처리
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);

		return "confirmId";
	} // confirmId()의 끝
	
	@RequestMapping("/join1")
	public String join1(@RequestParam("name") String name, @RequestParam("id") String id, 
			 @RequestParam("pw") String pw, @RequestParam("email") String email, Model model) {
			// Member DTO객체에 파라메터값 설정
		Member member = new Member();
		member.setName(name);
		member.setId(id);
		member.setPw(pw);
		member.setEmail(email);
		
		model.addAttribute("memberInfo", member);
		/* model.addAttribute(String attributeName, Object attributeValue);
		 - addAttribute() : 속성이름 : 문자열, 값은 object므로 뭐가 오든 OK.
		 - 이때 반환은 model 객체. */
		return "join1";
	} // join1()의 끝
	
	@RequestMapping("/join2")	// 파라메터를 DTO 객체로 → DTO 객체로 바로 받아!
	public String join(Member member) {
		/* RequestMapping 메서드의 파라메터를 DTO객체로 처리 
		 - DTO객체에 파라메터가 자동 저장되고 Model 객체에도 자동 저장됨
		 - Model의 속성이름 → 파라메터이름으로, 값은 파라메터 값으로 저장됨 
		 - 이 경우 member 파라메터의 id, pw, name, email로 저장되는 것.
		 → jsp에서 EL 형식으로 사용 시 ${member.id} 이런 식으로 사용 */
		return "join2"; // model 객체에 자동으로 값이 저장되어 join.jsp에 전달됨
	} // join2()의 끝
	
	@RequestMapping("/student/{studentId}") // {studentId}는 경로 X. 값을 나타내는 변수임! 
	public String getStudent(@PathVariable String studentId, Model model) {
		/* @PathVariable 
		 - 파라메터 변수값으로 경로 처리 */
		model.addAttribute("studentId", studentId);
		return "studentView";
	} // getStudent()의 끝 
}
