package com.kim.ex1502.util;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.kim.ex1502.dto.StudentDTO;

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// return false;
		return StudentDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("validate()");
		StudentDTO student = (StudentDTO)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "trouble");
		
		int studentId = student.getId();
		if (studentId == 0) {
			System.out.println("studentId is 0");
			errors.rejectValue("id", "trouble");
		}

	}

}
