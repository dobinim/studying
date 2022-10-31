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

	// SecCommand �������̽��� ��ü ����
	private SecCommand com;
	
	// ��ȣȭ ó�� bean���� (���� ��� ����̹Ƿ� ���� �� �����س��� ���)
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
		Constant.passwordEncoder = passwordEncoder;
	}
	
	// SecDaoŬ���� bean ����
	private SecDao sdao;
	
	@Autowired
	public void setSdao(SecDao sdao) {
		this.sdao = sdao;
		Constant.sdao = sdao;
	}
	
	// ȸ������ ó��
	@RequestMapping("/join_view")
	public String join_view() {
		return "join_view";
	}
	
	// �α��� â
	@RequestMapping("/login_view")
	public String logview() {
		return "login_view";
	}
	
	// ȸ������ó�� ��û
	@RequestMapping(value = "/join", produces = "application/text; charset=UTF8") // AJAX�� ��û��
	@ResponseBody // AJAX�� ��û�� 
	public String join(HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("join");
		com = new SecJoinCommand();
		com.execute(request, model);
		// getAttribute() �޼���� ������ ���� ����
		String result = (String)request.getAttribute("result");
		System.out.println("result : " + result);
		if (result.equals("success")) {
			return "join-success";
		} else {
			return "join-failed";
		}
		
	}
}
