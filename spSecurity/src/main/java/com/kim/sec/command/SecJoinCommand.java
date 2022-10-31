package com.kim.sec.command;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;

import com.kim.sec.constant.Constant;
import com.kim.sec.dao.SecDao;
import com.kim.sec.dto.JoinDto;

public class SecJoinCommand implements SecCommand {

	@Override
	public void execute(HttpServletRequest request, Model model) {
		
		//��ȣȭ ��ü 
		BCryptPasswordEncoder passwordEncoder = Constant.passwordEncoder;
		
		//form�� �Է� ���� ���� ����
		String bid = request.getParameter("pid");
		String bpw = request.getParameter("ppw");
		String baddress = request.getParameter("paddress");
		String bhobby = request.getParameter("phobby");
		String bprofile = request.getParameter("pprofile");
		
		//��ȣȭ ���� bpw�� bpw_org�� ��������� ����
		String bpw_org = bpw;
		System.out.println(bpw);
		bpw = passwordEncoder.encode(bpw_org); //encode�޼���� ��ȣȭ
		System.out.println(bpw + " size " + bpw.length());
		
		JoinDto dto = new JoinDto(bid, bpw, baddress, bhobby, bprofile);
		
		SecDao sdao = Constant.sdao;
		
		String result = sdao.join(dto);
		request.setAttribute("result", result);
	}

}
