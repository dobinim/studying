package com.kim.spsecurity.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kim.spsecurity.command.SecCommand;
import com.kim.spsecurity.command.SecJoinCommand;
import com.kim.spsecurity.constant.Constant;
import com.kim.spsecurity.dao.SecDao;

@Controller
public class SecController {

	// SecCommand 인터페이스의 객체 선언
	private SecCommand com;
	
	// 암호화 처리 bean주입 (공통 사용 요소이므로 주입 후 저장해놓고 사용)
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
		Constant.passwordEncoder = passwordEncoder;
	}
	
	// SecDao클래스 bean 주입
	private SecDao sdao;
	
	@Autowired
	public void setSdao(SecDao sdao) {
		this.sdao = sdao;
		Constant.sdao = sdao;
	}
	
	// 회원가입 처리
	@RequestMapping("/join_view")
	public String join_view() {
		return "join_view";
	}
	
	// 로그인 창
	@RequestMapping("/login_view")
	public String logview() {
		return "login_view";
	}
	
	// 회원가입처리 요청
	@RequestMapping(value = "/join", produces = "application/text; charset=UTF8") // AJAX로 요청시
	@ResponseBody // AJAX로 요청시 
	public String join(HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("join");
		com = new SecJoinCommand();
		com.execute(request, model);
		// getAttribute() 메서드로 설정한 값을 추출
		String result = (String)request.getAttribute("result");
		System.out.println("result : " + result);
		if (result.equals("success")) {
			return "join-success";
		} else {
			return "join-failed";
		}
		
	}
}
