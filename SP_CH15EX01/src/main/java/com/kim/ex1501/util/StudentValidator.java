package com.kim.ex1501.util;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.kim.ex1501.dto.StudentDTO;

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		/* Object target : 유효성 검사 대상 객체 
		   Errors errors : BindingResult result의 상위로,
		 				   result를 받는 객체이며
		 				   에러내용을 저장할 객체이다.*/
		System.out.println("validate()");
		StudentDTO student = (StudentDTO)target;
		/* String studentName = student.getName();
		if (studentName == null || studentName.trim().isEmpty()) {
									// trim() → 스페이스(공백) 다 떼어라 
									// isEmply() → 비었는가?
									// → 즉, studentName에 내용물이 없는가? 
			System.out.println("studentName is null");
			errors.rejectValue("name", "trouble"); 
			// name 속성에다 값은 trouble 로 에러를 등록하라.
		} // if 문의 끝  */
		// 위의 주석 부분을 한 줄로 처리할 수 있다. BUT, "String"에 한해서만 가능 ★★★
		// int형이라면 원래대로 처리해야함.
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "trouble");
		
		int studentId = student.getId();
		if (studentId == 0) {
			System.out.println("studentId is 0");
			errors.rejectValue("id", "trouble");
		}

	} // validate()의 끝

}
 