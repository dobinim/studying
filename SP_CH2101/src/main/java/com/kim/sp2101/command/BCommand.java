package com.kim.sp2101.command;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface BCommand {
	public void execute(HttpServletRequest request, Model model); // 추상 메서드 
	
	// request 객체는 클라이언트로부터 온 데이터 값을 위해 사용
	// model 객체는 반환할 jsp를 위해 사용
	// model의 asMap()으로 저장된 데이터를 Map형식으로 추출할 수 있어 파라메터 객체로 사용
}
