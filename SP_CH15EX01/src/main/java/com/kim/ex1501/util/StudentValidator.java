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
		/* Object target : ��ȿ�� �˻� ��� ��ü 
		   Errors errors : BindingResult result�� ������,
		 				   result�� �޴� ��ü�̸�
		 				   ���������� ������ ��ü�̴�.*/
		System.out.println("validate()");
		StudentDTO student = (StudentDTO)target;
		/* String studentName = student.getName();
		if (studentName == null || studentName.trim().isEmpty()) {
									// trim() �� �����̽�(����) �� ����� 
									// isEmply() �� ����°�?
									// �� ��, studentName�� ���빰�� ���°�? 
			System.out.println("studentName is null");
			errors.rejectValue("name", "trouble"); 
			// name �Ӽ����� ���� trouble �� ������ ����϶�.
		} // if ���� ��  */
		// ���� �ּ� �κ��� �� �ٷ� ó���� �� �ִ�. BUT, "String"�� ���ؼ��� ���� �ڡڡ�
		// int���̶�� ������� ó���ؾ���.
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "trouble");
		
		int studentId = student.getId();
		if (studentId == 0) {
			System.out.println("studentId is 0");
			errors.rejectValue("id", "trouble");
		}

	} // validate()�� ��

}
 