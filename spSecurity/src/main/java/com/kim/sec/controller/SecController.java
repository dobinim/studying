package com.kim.sec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kim.sec.command.SecCommand;
import com.kim.sec.command.SecJoinCommand;
import com.kim.sec.constant.Constant;
import com.kim.sec.dao.SecDao;

@Controller
public class SecController {
	
	//SecCommand인터페이스의 객체 선언
	private SecCommand com;
	
	//암호화 처리 bean주입(공통 사용 요소이므로 주입 후 저장해두고 사용)
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
		Constant.passwordEncoder = passwordEncoder;
	}
	
	//SecDao클래스 bean주입
	private SecDao sdao;
	@Autowired
	public void setSdao(SecDao sdao) {
		this.sdao = sdao;
		Constant.sdao = sdao;
	}
	
	//로그인창 이동
	@RequestMapping("/login_view")
	public String login_view() {
		return "login_view";
	}
		
	//회원가입 화면 처리
	@RequestMapping("/join_view")
	public String join_view() {
		return "join_view";
	}
	
	//회원가입 요청 처리
	@RequestMapping(value = "/join", produces = "application/text;charset=UTF-8")
	@ResponseBody //ajax로 요청이 오고 jsp가 아닌 일반 문자열,객체 map, list 등으로 반환할 경우
	public String join(HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("join");
		com = new SecJoinCommand();
		com.execute(request, model);
		
		//setAttribute()메서드로 설정한 값을 추출
		String result = (String)request.getAttribute("result");
		System.out.println(result);
		
		if(result.equals("success")) {
			return "join-success";
		}
		else {
			return "join_failed";
		}
			
	}
	
	@RequestMapping("/main")
	public String main() {
		return "main_view";
	}
	
	@RequestMapping("/processLogin")
	public ModelAndView processLogin
	(@RequestParam(value = "log", required = false) String log, 
	 @RequestParam(value = "error", required = false) String error,
	 @RequestParam(value = "logout", required = false) String logout) {
	/* @RequestParam() 은 요청 경로 뒤 ? 이후 쿼리의 이름 
	   : 즉, servlet-context.xml의 logout 태그 등에서 보이는 /processLogin?logout=1 의 logout 이 해당함.
	   - required = false는 필요하지 않으면 없어도 되는 파라메터 */
		ModelAndView model = new ModelAndView();
		if (log != null && log != "") {
			// log 가 공백이거나 값이 없는게 아니라면!
			model.addObject("log", "before login!");
		} 
		if (error != null && error != "") {
			model.addObject("error", "Invalid Username or password!");
		}
		if (logout != null && logout != "") {
			model.addObject("logout", "You've been logged out successfully.");
		}
		model.setViewName("login_view"); // jsp 설정
		return model;
	}
	
	@RequestMapping("/logout_view")
	public String logout_view() {
		
		return "logout_view";
	}
	
}
