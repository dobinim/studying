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
	
	//SecCommand�������̽��� ��ü ����
	private SecCommand com;
	
	//��ȣȭ ó�� bean����(���� ��� ����̹Ƿ� ���� �� �����صΰ� ���)
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
		Constant.passwordEncoder = passwordEncoder;
	}
	
	//SecDaoŬ���� bean����
	private SecDao sdao;
	@Autowired
	public void setSdao(SecDao sdao) {
		this.sdao = sdao;
		Constant.sdao = sdao;
	}
	
	//�α���â �̵�
	@RequestMapping("/login_view")
	public String login_view() {
		return "login_view";
	}
		
	//ȸ������ ȭ�� ó��
	@RequestMapping("/join_view")
	public String join_view() {
		return "join_view";
	}
	
	//ȸ������ ��û ó��
	@RequestMapping(value = "/join", produces = "application/text;charset=UTF-8")
	@ResponseBody //ajax�� ��û�� ���� jsp�� �ƴ� �Ϲ� ���ڿ�,��ü map, list ������ ��ȯ�� ���
	public String join(HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("join");
		com = new SecJoinCommand();
		com.execute(request, model);
		
		//setAttribute()�޼���� ������ ���� ����
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
	/* @RequestParam() �� ��û ��� �� ? ���� ������ �̸� 
	   : ��, servlet-context.xml�� logout �±� ��� ���̴� /processLogin?logout=1 �� logout �� �ش���.
	   - required = false�� �ʿ����� ������ ��� �Ǵ� �Ķ���� */
		ModelAndView model = new ModelAndView();
		if (log != null && log != "") {
			// log �� �����̰ų� ���� ���°� �ƴ϶��!
			model.addObject("log", "before login!");
		} 
		if (error != null && error != "") {
			model.addObject("error", "Invalid Username or password!");
		}
		if (logout != null && logout != "") {
			model.addObject("logout", "You've been logged out successfully.");
		}
		model.setViewName("login_view"); // jsp ����
		return model;
	}
	
	@RequestMapping("/logout_view")
	public String logout_view() {
		
		return "logout_view";
	}
	
}
