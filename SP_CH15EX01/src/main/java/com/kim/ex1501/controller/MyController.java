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
	} // studentForm() ��
	
	@RequestMapping("/create")
	public String studentCreate(@ModelAttribute("student") StudentDTO student, 
			BindingResult result) {
	/* Form�� �Ķ���͸� StudentDTO�� �����ϴ� RequestMapping�� ����ϸ�, 
	   @ModelAttribute�� ���                                 
	   
	   * BindingResult 
	   - ���� ������ �����ϴ� Error �������̽��� ����� �������̽�. 
	   
	   - DTO ��ü�� �Ķ���ͷ� ����ϸ� MODEL�� �ڵ����� ��ü���� �����     */
		String page = "createDonePage";
		
		StudentValidator validator = new StudentValidator();
		// ��ȿ���� üũ�ϴ� Validator �������̽��� ���
		validator.validate(student, result);
		// student ��ü�� ���� ��ȿ���� üũ�� ������ ������ �� ������ result�� ����
		if (result.hasErrors()) {
			// result�� ������ �ִٸ�, ��, ������ �߻��ߴٸ�
			page = "formPage"; 
		} 
		
		return page;
	} // studentCreate() ��
	

}
 