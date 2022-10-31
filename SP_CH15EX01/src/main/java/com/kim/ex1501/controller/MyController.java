package com.kim.ex1501.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kim.ex1501.dto.StudentDTO;
import com.kim.ex1501.util.StudentValidator;

@Controller
public class MyController {

	@RequestMapping("/studentForm")
	public String studentForm() {
		return "formPage";
	} // studentForm() 끝
	
	@RequestMapping("/create")
	public String studentCreate(@ModelAttribute("student") StudentDTO student, 
			BindingResult result) {
	/* Form의 파라메터를 StudentDTO로 매핑하는 RequestMapping을 사용하며, 
	   @ModelAttribute를 사용                                 
	   
	   * BindingResult 
	   - 에러 내용을 전달하는 Error 인터페이스를 상속한 인터페이스. 
	   
	   - DTO 객체를 파라메터로 사용하면 MODEL에 자동으로 객체값이 저장됨     */
		String page = "createDonePage";
		
		StudentValidator validator = new StudentValidator();
		// 유효성을 체크하는 Validator 인터페이스를 상속
		validator.validate(student, result);
		// student 객체에 대해 유효성을 체크해 에러가 있으면 그 내용을 result에 전달
		if (result.hasErrors()) {
			// result에 에러가 있다면, 즉, 에러가 발생했다면
			page = "formPage"; 
		} 
		
		return page;
	} // studentCreate() 끝
	

}
 