package com.kim.ex1502.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kim.ex1502.dto.StudentDTO;
import com.kim.ex1502.util.StudentValidator;

@Controller
public class MyController {
	@RequestMapping("/studentForm")
	public String studentForm() {
		return "formPage";
	}
	
	@RequestMapping("/create")
	// 유효성 체크를 위해 DTO 객체 앞에 @Valid 사용 → 스프링이 validate 자동으로 실행
	public String create(@ModelAttribute("student") 
		@Valid StudentDTO student, BindingResult result) {

		String page = "createDonePage";
		if (result.hasErrors()) {
			page = "formPage";
		}
		
		return page;
	} // create()의 끝
	
	// pom.xml에 hibernate와 validation을 사용할 시 @InitBinder 구현
	// StudentValidator클래스를 validator로 설정
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new StudentValidator());
	}
}
