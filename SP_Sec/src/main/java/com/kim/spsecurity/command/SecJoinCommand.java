package com.kim.spsecurity.command;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;

import com.kim.spsecurity.constant.Constant;
import com.kim.spsecurity.dao.SecDao;
import com.kim.spsecurity.dto.JoinDto;

public class SecJoinCommand implements SecCommand {

	@Override
	public void execute(HttpServletRequest request, Model model) {
		// 암호화 객체
		BCryptPasswordEncoder passwordEncoder = Constant.passwordEncoder;
		
		// form의 입력 원소값을 추출
		String bid = request.getParameter("pid");
		String bpw = request.getParameter("ppw");
		String baddress = request.getParameter("paddress");
		String bhobby = request.getParameter("phobby");
		String bprofile = request.getParameter("pprofile");
		
		// 암호화 전 bpw를 bpw_org에 저장
		String bpw_org = bpw; // bPw_org는 암호화 전 pw
		System.out.println(bpw);
		bpw = passwordEncoder.encode(bpw_org);	// encode메서드 : 암호화
		System.out.println(bpw + " size " + bpw.length());
		
		JoinDto dto = new JoinDto(bid, bpw, baddress, bhobby, bprofile);
		
		// mybatis를 사용하기 위해 인터페이스 ISecDao를 구현한 SecDao 클래스 사용
		SecDao sdao = Constant.sdao;
		
		String result = sdao.join(dto);
		
		request.setAttribute("result", result);
	}
}
